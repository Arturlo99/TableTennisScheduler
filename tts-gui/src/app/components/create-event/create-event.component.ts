import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { TournamentService } from '../../services/tournament.service';

@Component({
  selector: 'app-create-event',
  templateUrl: './create-event.component.html',
  styleUrls: ['./create-event.component.css']
})
export class CreateEventComponent implements OnInit {
  createEventForm = this.formBuilder.group({
    name: ['', [Validators.required]],
    city: ['', [Validators.required]],
    street: ['', [Validators.required]],
    date: ['', [Validators.required]],
    time: ['', [Validators.required]],
    maxPlayers: ['', [Validators.required]],
    description: ['', []],
  })

  constructor(private formBuilder: FormBuilder, private tournamentService: TournamentService) { }

  ngOnInit(): void {
  }

  myFilter = (d: Date | null): boolean => {
    const date = (d || new Date());
    // It is only possible to select future date 
    return date > new Date();
  };

  createNewTournament() {
    this.tournamentService.createNewTournament(this.createEventForm)
  }
}