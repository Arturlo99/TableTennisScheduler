import { Component, OnInit } from '@angular/core';
import { TournamentDetails } from '../models/tournament-details';
import { TournamentService } from '../services/tournament.service';
import { ActivatedRoute, Router } from '@angular/router';
import { SessionService } from '../services/session.service';
import { UserForTournament } from '../models/user-for-tournament';
import { MatTableDataSource } from '@angular/material/table';
import { Match } from '../models/match';
import { EditMatchResultsDialogComponent } from './edit-match-results-dialog/edit-match-results-dialog.component';
import { MatDialog } from '@angular/material/dialog';


export interface UserTableData {
  position: number;
  name: string
  matchResult: string
}
@Component({
  selector: 'app-event-details',
  templateUrl: './event-details.component.html',
  styleUrls: ['./event-details.component.css']
})
export class EventDetailsComponent implements OnInit {
  tournamentDetails?: TournamentDetails
  tournamentId: string
  currentDate
  isClosed: boolean
  shouldDisableEnrollButton: boolean = true
  displayedColumns: string[] = ['position', 'name'];
  dataSource: any;
  usersTableData: any[] = []
  tournamentMatches: Match[] = []

  constructor(private session: SessionService, private tournamentService: TournamentService, private route: ActivatedRoute,
    private router: Router, public dialog: MatDialog) {
    this.tournamentId = this.route.snapshot.paramMap.get('id');
    this.currentDate = new Date();
  }

  ngOnInit(): void {
    if (sessionStorage.getItem('token') == '' || sessionStorage.getItem('token') == null || !this.session.loggedIn) {
      this.tournamentService.findTournamentDetailsUsingId(this.tournamentId).subscribe(data => {
        this.tournamentDetails = data;
        this.checkIfEnrollButtonShouldBeDisabled()
        this.prepareUsersDataToDisplay(data.users)
      })
    } else {
      this.tournamentService.findTournamentDetailsUsingIdAndEmail(this.tournamentId, this.session.getEmailFromSession())
        .subscribe(data => {
          this.tournamentDetails = data;
          this.checkIfEnrollButtonShouldBeDisabled()
          this.prepareUsersDataToDisplay(data.users)
        })
    }
  }

  enroll() {
    this.tournamentService.enrollForTournament(this.session.getEmailFromSession(), this.tournamentId).subscribe(data => {
      this.tournamentDetails.userEnrolled = data.userEnrolled
      this.tournamentDetails.enrolledPlayers = data.enrolledPlayers
    }), (error) => {
      if (error.status == 405) {
        alert('Action is not possible.')
      } else {
        alert('Something went wrong.')
      }
    }
  }

  checkIfEnrollButtonShouldBeDisabled() {
    if (!this.session.loggedIn || this.currentDate > this.tournamentDetails.date) {
      this.shouldDisableEnrollButton = true;
    }
  }

  prepareUsersDataToDisplay(users?: UserForTournament[]) {
    for (let i in users) {
      for (let j in users) {
        if (i > j) {
          this.tournamentMatches.push(new Match(+this.tournamentId, +i, +j, '3:0', ''))
        }
      }
      this.displayedColumns.push(i);
      this.usersTableData.push({
        position: +i, name: users[i].name.charAt(0).concat('. ' + users[i].lastName),
        matches: this.tournamentMatches.filter(match => match.firstPlayerId === +i)
      })

    }
    this.dataSource = new MatTableDataSource(this.usersTableData);
  }

  openEditMatchResultsPopup(match: Match) {
    const dialogRef = this.dialog.open(EditMatchResultsDialogComponent, { data: { match: match } })

    dialogRef.afterClosed().subscribe(result => {
      if (result !== false) {
        match.finalResult = result;
      }
    });
  }
}

