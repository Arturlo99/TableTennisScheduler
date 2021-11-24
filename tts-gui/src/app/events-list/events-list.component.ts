import { Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { Tournament } from '../models/tournament';
import { SessionService } from '../services/session.service';
import { TournamentService } from '../services/tournament.service';

@Component({
  selector: 'app-events-list',
  templateUrl: './events-list.component.html',
  styleUrls: ['./events-list.component.css']
})
export class EventsListComponent implements OnInit {
  @ViewChild(MatPaginator) paginator: MatPaginator;

  displayedColumns: string[] = ['name', 'place', 'date', 'enrolledPlayers']
  tournaments: Tournament[]
  dataSource: MatTableDataSource<Tournament>
  currentDate

  constructor(private tournamentService: TournamentService) {
    this.currentDate = new Date()
  }

  ngOnInit(): void {
    this.tournamentService.findAll().subscribe(data => {
      this.tournaments = data
      this.dataSource = new MatTableDataSource(this.tournaments)
      this.dataSource.paginator = this.paginator
    })
  }

  isRoleAdmin() {
    return sessionStorage.getItem('role') === "ROLE_ADMIN";
  }

}
