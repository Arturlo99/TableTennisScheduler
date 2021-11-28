import { AfterViewInit, Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { Tournament } from '../models/tournament';
import { TournamentService } from '../services/tournament.service';
import { MatSort, Sort } from '@angular/material/sort';

@Component({
  selector: 'app-events-list',
  templateUrl: './events-list.component.html',
  styleUrls: ['./events-list.component.css']
})
export class EventsListComponent implements OnInit {
  displayedColumns: string[] = ['name', 'place', 'date', 'enrolledPlayers']
  tournaments: Tournament[]
  dataSource: MatTableDataSource<Tournament>
  currentDate
  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;

  constructor( private tournamentService: TournamentService) {
      this.tournamentService.findAll().subscribe(data => {
      data.sort((a, b) => (a.date > b.date ? -1 : 1));
      this.tournaments = data
      this.dataSource = new MatTableDataSource(this.tournaments)
      this.dataSource.paginator = this.paginator
      this.dataSource.sort = this.sort;
    })
    this.currentDate = new Date()
  }

  ngOnInit(): void {
    if (this.isRoleAdmin()){
      this.displayedColumns.push('actions');
    }

  }

  isRoleAdmin() {
    return sessionStorage.getItem('role') === "ROLE_ADMIN";
  }

}
