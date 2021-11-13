import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BackgroundComponent } from './background/background.component';
import { EventsListComponent } from './events-list/events-list.component';

const routes: Routes = [
  { path: '', component: BackgroundComponent },
  { path: 'tournaments/all', component: EventsListComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
