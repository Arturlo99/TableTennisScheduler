import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Tournament } from '../models/tournament';
import { Observable } from 'rxjs';
import { TournamentDetails } from '../models/tournament-details';
import { GlobalConstants } from '../common/global-constants';
import { FormGroup } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { SessionService } from './session.service';

@Injectable({
  providedIn: 'root'
})
export class TournamentService {
  private tournamentsUrl = GlobalConstants.apiURL + 'tournaments/all'
  private tournamentDetailsUrl = GlobalConstants.apiURL + 'tournaments/details/'
  private tournamentEnrollUrl = GlobalConstants.apiURL + 'tournaments/enroll'
  private tournamentDeleteUrl = GlobalConstants.apiURL + 'delete-event/'

  constructor(private http: HttpClient, private snackBar: MatSnackBar, private router: Router, private session: SessionService) { }

  public findAll(): Observable<Tournament[]> {
    return this.http.get<Tournament[]>(this.tournamentsUrl);
  }

  public findTournamentDetailsUsingIdAndEmail(id: string, email: string): Observable<TournamentDetails> {
    return this.http.post<TournamentDetails>(this.tournamentDetailsUrl.concat(id), email);
  }

  public enrollInOrWithdrawFromTournament(userEmail: string, tournamentId: string) {
    return this.http.post<any>(this.tournamentEnrollUrl, {
      userEmail: userEmail,
      tournamentId: tournamentId
    });
  }

  public deleteTournament(tournamentId: number) {
    return this.http.delete<any>(this.tournamentDeleteUrl.concat(tournamentId.toString()));
  }

  createNewTournament(createEventForm: FormGroup) {
    this.http.post<any>(GlobalConstants.apiURL + 'create-event', {
      name: createEventForm.value.name,
      city: createEventForm.value.city,
      street: createEventForm.value.street,
      date: this.session.toLocalDateTime(createEventForm.value.date, createEventForm.value.time),
      maxPlayers: createEventForm.value.maxPlayers,
      description: createEventForm.value.description,
      organizerEmail: this.session.getEmailFromSession()
    }).subscribe((response) => {
      this.snackBar.open('Successfully created new tournament!', 'Ok', {
        duration: 2000,
      });
      this.router.navigate(['']);
    }, (error) => {
      this.snackBar.open('You are not allowed to create new tournament.', 'Ok', {
        duration: 2000,
      });
    })
  }
}