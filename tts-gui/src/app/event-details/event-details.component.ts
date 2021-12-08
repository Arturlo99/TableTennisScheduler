import { Component, OnInit } from '@angular/core';
import { TournamentDetails } from '../models/tournament-details';
import { TournamentService } from '../services/tournament.service';
import { ActivatedRoute } from '@angular/router';
import { SessionService } from '../services/session.service';
import { UserForTournament } from '../models/user-for-tournament';
import { MatTableDataSource } from '@angular/material/table';
import { Match } from '../models/match';
import { EditMatchResultsDialogComponent } from './edit-match-results-dialog/edit-match-results-dialog.component';
import { MatDialog } from '@angular/material/dialog';
import { MatchService } from '../services/match.service';
import { UpdateTournamentMatches } from '../models/update-tournament-matches';
import { formatDate } from '@angular/common';
import { MatSnackBar } from '@angular/material/snack-bar';


export interface UserTableData {
  position: number;
  name: string
  matches: Match[]
}
@Component({
  selector: 'app-event-details',
  templateUrl: './event-details.component.html',
  styleUrls: ['./event-details.component.css']
})
export class EventDetailsComponent implements OnInit {
  tournamentDetails?: TournamentDetails
  tournamentId: string
  currentDate = formatDate(new Date(), 'yyyy-MM-dd', 'en')
  wereMatchesGenerated?: boolean
  shouldDisableEnrollButton: boolean = true
  displayedColumns: string[] = ['position', 'name'];
  dataSource: any;
  usersTableData: UserTableData[] = []
  email = ' '


  constructor(private session: SessionService, private tournamentService: TournamentService, private route: ActivatedRoute,
    public dialog: MatDialog, private matchService: MatchService, private snackBar: MatSnackBar) {
    this.tournamentId = this.route.snapshot.paramMap.get('id');
  }

  ngOnInit(): void {
    if (this.session.loggedIn) {
      this.email = this.session.getEmailFromSession()
    }
    this.tournamentService.findTournamentDetailsUsingIdAndEmail(this.tournamentId, this.email)
      .subscribe(response => {
        if (response.matches.length > 0) {
          this.wereMatchesGenerated = true
        }
        this.tournamentDetails = response;
        this.checkIfEnrollButtonShouldBeDisabled()
        this.prepareUsersDataToDisplay(response.users)
      })
  }

  enroll() {
    this.tournamentService.enrollForTournament(this.session.getEmailFromSession(), this.tournamentId).subscribe(data => {
      this.tournamentDetails.userEnrolled = data.userEnrolled
      this.tournamentDetails.enrolledPlayers = data.enrolledPlayers
      this.snackBar.open('The operation was successful', 'Ok', {
        duration: 2000,
      });
      this.tournamentService.findTournamentDetailsUsingIdAndEmail(this.tournamentId, this.email)
      .subscribe(response => {
        this.prepareUsersDataToDisplay(response.users)
      })
    }), (error) => {
      if (error.status == 405) {
        this.snackBar.open('Operation not allowed!', 'Ok', {
          duration: 2000,
        });
      } else {
        this.snackBar.open('Unrecognized error occured!', 'Ok', {
          duration: 2000,
        });
      }
    }
  }

  checkIfEnrollButtonShouldBeDisabled() {
    if (!this.session.loggedIn || this.currentDate > this.tournamentDetails.date.split('T')[0] || this.wereMatchesGenerated ||
        (this.tournamentDetails.enrolledPlayers == this.tournamentDetails.maxPlayers) && !this.tournamentDetails.userEnrolled ) {
      this.shouldDisableEnrollButton = true;
    } else {
      this.shouldDisableEnrollButton = false;
    }
  }

  prepareUsersDataToDisplay(users?: UserForTournament[]) {
    this.displayedColumns = ['position', 'name'];
    this.usersTableData = []
    for (let i in users) {
      this.displayedColumns.push(i);
      this.usersTableData.push({
        position: +i, name: users[i].name.charAt(0).concat('. ' + users[i].lastName), matches: this.tournamentDetails.matches.filter(match => match.firstPlayerId === users[i].id || match.secondPlayerId === users[i].id)
      })
    }
    this.dataSource = new MatTableDataSource(this.usersTableData);
  }

  openEditMatchResultsPopup(match: Match) {
    const dialogRef = this.dialog.open(EditMatchResultsDialogComponent)

    dialogRef.afterClosed().subscribe(result => {
      if (result.saved === true) {
        match.finalResult = result.result;
        this.matchService.updateMatch(match).subscribe(response => {
          this.snackBar.open('Result saved successfully.', 'Ok', {
            duration: 2000,
          });
        })
      }
    });
  }

  generateMatches() {
    if (this.tournamentDetails.users.length > 0) {
      let generatedMatches = []
      for (let i in this.tournamentDetails.users) {
        for (let j in this.tournamentDetails.users) {
          if (i > j) {
            generatedMatches.push(new Match(+this.tournamentId, this.tournamentDetails.users[i].id, this.tournamentDetails.users[j].id, '0:0'))
          }
        }
      }
      this.matchService.generateTournamentMatches(new UpdateTournamentMatches(generatedMatches,
        this.session.getEmailFromSession())).subscribe((response) => {
          this.snackBar.open('Successfully generated matches!', 'Ok', {
            duration: 2000,
          });
          this.wereMatchesGenerated = true
          this.tournamentService.getTournamentMatches(+this.tournamentId).subscribe(response => {
            this.tournamentDetails.matches = response
            this.updateTable()
          })
        }, (error) => {
          if (error.status === 405)
            this.snackBar.open('Operation not allowed!', 'Ok', {
              duration: 2000,
            });
        })
    }
  }

  updateTable() {
    for (let i in this.tournamentDetails.users) {
      this.usersTableData[i].matches = this.tournamentDetails.matches.filter(match => this.tournamentDetails.users[i].id === match.firstPlayerId)
    }
    this.dataSource = new MatTableDataSource(this.usersTableData);
  }

  isRoleAdmin() {
    return this.session.getUserRole() === 'ROLE_ADMIN'
  }
}
