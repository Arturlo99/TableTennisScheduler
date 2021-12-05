import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Tournament } from '../models/tournament';
import { Observable } from 'rxjs';
import { TournamentDetails } from '../models/tournament-details';

@Injectable({
  providedIn: 'root'
})
export class TournamentService {
  tournamentsUrl = 'http://localhost:8080/tournaments/all'
  tournamentDetailsUrl = 'http://localhost:8080/tournaments/details/'
  tournamentEnrollUrl = 'http://localhost:8080/tournaments/enroll'
  tournamentDeleteUrl = 'http://localhost:8080/delete-event/'

  constructor(private http: HttpClient) { }

  public findAll(): Observable<Tournament[]> {
    return this.http.get<Tournament[]>(this.tournamentsUrl);
  }

  public findTournamentDetailsUsingIdAndEmail(id: string, email: string): Observable<TournamentDetails> {
    return this.http.post<TournamentDetails>(this.tournamentDetailsUrl.concat(id), email);
  }

  public enrollForTournament(userEmail: string, tournamentId: string) {
    return this.http.post<any>(this.tournamentEnrollUrl, {
      userEmail: userEmail,
      tournamentId: tournamentId
    });
  }

  public deleteTournament(tournamentId: number) {
    return this.http.delete<any>(this.tournamentDeleteUrl.concat(tournamentId.toString()));
  }

  public getTournamentMatches(tournamentId: number) {
    return this.http.get<any>(`http://localhost:8080/get-tournament${tournamentId}-matches`)
  }
}