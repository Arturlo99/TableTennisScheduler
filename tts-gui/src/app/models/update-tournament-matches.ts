import { Match } from "./match"

export class UpdateTournamentMatches {
    matches: Match[]
    userEmail: string

    constructor(matches: Match[], userEmail: string) {
        this.matches = matches
        this.userEmail = userEmail
    }
}
