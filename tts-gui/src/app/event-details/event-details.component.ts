import { Component, OnInit } from '@angular/core';
import { TournamentDetails } from '../models/tournament-details';
import { TournamentService } from '../services/tournament.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-event-details',
  templateUrl: './event-details.component.html',
  styleUrls: ['./event-details.component.css']
})
export class EventDetailsComponent implements OnInit {

  tournamentDetails: TournamentDetails
  tournamentId: string

  constructor(private tournamentService: TournamentService, private route: ActivatedRoute) { 
    this.tournamentId = this.route.snapshot.paramMap.get('id');
  }

  ngOnInit(): void {
    this.tournamentService.findTournamentDetailsUsingId(this.tournamentId).subscribe( data => {
      this.tournamentDetails = data;
    })
  }
}
