import { AfterViewInit, Component, OnInit, ViewChild, Inject } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { Tournament } from '../models/tournament';
import { TournamentService } from '../services/tournament.service';
import { MatSort } from '@angular/material/sort';
import {MatDialog, MatDialogRef, MAT_DIALOG_DATA} from '@angular/material/dialog';

@Component({
  selector: 'app-events-list',
  templateUrl: './events-list.component.html',
  styleUrls: ['./events-list.component.css']
})
export class EventsListComponent implements OnInit {
  displayedColumns: string[] = ['name', 'place', 'date', 'enrolledPlayers']
  tournaments: Tournament[]
  indexToBeDeleted: number =-1;
  dataSource: MatTableDataSource<Tournament>
  currentDate
  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;

  constructor(private tournamentService: TournamentService, public dialog: MatDialog) {
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
    if (this.isRoleAdmin()) {
      this.displayedColumns.push('actions');
    }
  }

  isRoleAdmin() {
    return sessionStorage.getItem('role') === "ROLE_ADMIN";
  }

  deleteTournament(tournamentId: number) {
    this.tournamentService.deleteTournament(tournamentId).subscribe(data => {
      this.tournaments.forEach((tournament, id) => {
        if(tournament.id === tournamentId) this.tournaments.splice(id,1);
      });
      this.dataSource = new MatTableDataSource(this.tournaments);
    });
  }

  openConfirmationPopup(tournamentId: number){
    const dialogRef = this.dialog.open(DialogOverviewExampleComponent)

    dialogRef.afterClosed().subscribe(result => {
      if (result === true) {
        this.deleteTournament(tournamentId);
      }
    });
  }

}

@Component({
  selector: 'dialog-overview-example-dialog',
  templateUrl: './dialog-content-example-dialog.html',
})
export class DialogOverviewExampleComponent {
  constructor(
    public dialogRef: MatDialogRef<DialogOverviewExampleComponent>,
    @Inject(MAT_DIALOG_DATA) public tournamentId: number,
  ) {}

  onNoClick(): void {
    this.dialogRef.close();
  }
}