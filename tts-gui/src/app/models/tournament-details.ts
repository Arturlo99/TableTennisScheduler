import { UserForTournament } from "./user-for-tournament"
import { Match } from "./match"

export class TournamentDetails {
    name: string
    date: string
    organizerId: number
    organizerName: string
    organizerLastName: string
    description: string
    enrolledPlayers: number
    city: string
    street: string
    maxPlayers: number
    userEnrolled: boolean
    users: UserForTournament[]
    matches: Match[]
}
