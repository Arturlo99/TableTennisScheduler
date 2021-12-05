export class Match {
    matchId?: number
    tournamentId: number
    firstPlayerId: number
    secondPlayerId: number
    finalResult: string

    constructor( tournamentId: number, firstPlayerId: number, secondPlayerId: number, finalResult: string) {
        this.tournamentId = tournamentId
        this.firstPlayerId = firstPlayerId
        this.secondPlayerId = secondPlayerId
        this.finalResult = finalResult
    }
}
