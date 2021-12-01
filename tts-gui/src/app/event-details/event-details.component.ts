import { Component, OnInit } from '@angular/core';
import { TournamentDetails } from '../models/tournament-details';
import { TournamentService } from '../services/tournament.service';
import { ActivatedRoute, Router } from '@angular/router';
import { SessionService } from '../services/session.service';

@Component({
  selector: 'app-event-details',
  templateUrl: './event-details.component.html',
  styleUrls: ['./event-details.component.css']
})
export class EventDetailsComponent implements OnInit {
  dbUrl = 'https://raw.githubusercontent.com/Drarig29/brackets-viewer.js/master/demo/db.json';
  tournamentDetails: TournamentDetails
  tournamentId: string
  currentDate


  constructor(private session: SessionService, private tournamentService: TournamentService, private route: ActivatedRoute, private router: Router) {
    this.tournamentId = this.route.snapshot.paramMap.get('id');
    this.currentDate = new Date();
  }

  ngOnInit(): void {
    if (sessionStorage.getItem('token') == '' || sessionStorage.getItem('token') == null || !this.session.loggedIn) {
      this.tournamentService.findTournamentDetailsUsingId(this.tournamentId).subscribe(data => {
        this.tournamentDetails = data;
      })
    } else {
      this.tournamentService.findTournamentDetailsUsingIdAndEmail(this.tournamentId, this.session.getEmailFromSession())
        .subscribe(data => {
          this.tournamentDetails = data;
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

  isUserLoggedIn(){
    return this.session.loggedIn;
  }
}

