import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Tournament } from '../models/tournament';
import { Observable } from 'rxjs';
import { TournamentDetails } from '../models/tournament-details';

@Injectable({
  providedIn: 'root'
})
export class TournamentService {

  private tournamentsUrl: string
  private tournamentDetailsUrl: string
  private tournamentEnroll: string

  constructor(private http: HttpClient) {
    this.tournamentsUrl = 'http://localhost:8080/tournaments/all'
    this.tournamentDetailsUrl = 'http://localhost:8080/tournaments/details/'
    this.tournamentEnroll = 'http://localhost:8080/tournaments/enroll'
  }

  public findAll(): Observable<Tournament[]> {
    return this.http.get<Tournament[]>(this.tournamentsUrl);
  }

  public findTournamentDetailsUsingId(id: string): Observable<TournamentDetails> {
    return this.http.get<TournamentDetails>(this.tournamentDetailsUrl.concat(id))
  }

  public findTournamentDetailsUsingIdAndEmail(id: string, email: string): Observable<TournamentDetails> {
    return this.http.post<TournamentDetails>(this.tournamentDetailsUrl.concat(id), email);
  }

  public enrollForTournament(userEmail: string, tournamentId: string) {
    return this.http.post<any>(this.tournamentEnroll, {
      userEmail: userEmail,
      tournamentId: tournamentId
    });
  }

}