import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Match } from '../models/match';
import { UpdateTournamentMatches } from '../models/update-tournament-matches';

@Injectable({
  providedIn: 'root'
})
export class MatchService {
  private generateTournamentMatchesUrl: string = "http://localhost:8080/generate-tournament-matches"
  private updateMatchUrl: string = "http://localhost:8080/update-match"

  constructor(private http: HttpClient) { }

  public generateTournamentMatches(generateTournamentMatches: UpdateTournamentMatches) {
    return this.http.post<any>(this.generateTournamentMatchesUrl, generateTournamentMatches);
  }

  public updateMatch(match: Match) {
    return this.http.put<any>(this.updateMatchUrl, match)
  }
}
