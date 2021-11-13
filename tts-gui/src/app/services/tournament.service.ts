import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Tournament } from '../models/tournament';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TournamentService {

  private tournamentsUrl: string;

  constructor(private http: HttpClient) { 
    this.tournamentsUrl = 'http://localhost:8080/tournaments/all'
   }

   public findAll(): Observable<Tournament[]> {
     return this.http.get<Tournament[]>(this.tournamentsUrl);
   }
}
