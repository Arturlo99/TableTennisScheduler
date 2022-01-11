import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Match } from '../models/match';
import { UpdateTournamentMatches } from '../models/update-tournament-matches';
import { GlobalConstants } from '../common/global-constants';

@Injectable({
  providedIn: 'root'
})
export class MatchService {
  private generateTournamentMatchesUrl: string = GlobalConstants.apiURL + "generate-tournament-matches"
  private updateMatchUrl: string = GlobalConstants.apiURL + "update-match"

  constructor(private http: HttpClient) { }

  public generateTournamentMatches(generateTournamentMatches: UpdateTournamentMatches) {
    return this.http.post<any>(this.generateTournamentMatchesUrl, generateTournamentMatches);
  }

  public updateMatch(match: Match) {
    return this.http.put<any>(this.updateMatchUrl, match)
  }
}
