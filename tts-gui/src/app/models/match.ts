export class Match {
    tournamentId: number
    firstPlayerId: number
    secondPlayerId: number
    finalResult: string
    setResults: string

    constructor( tournamentId: number, firstPlayerId: number, secondPlayerId: number, finalResult: string,setResults: string) {
        this.tournamentId = tournamentId
        this.firstPlayerId = firstPlayerId
        this.secondPlayerId = secondPlayerId
        this.finalResult = finalResult
        this.setResults = setResults
    }
}
