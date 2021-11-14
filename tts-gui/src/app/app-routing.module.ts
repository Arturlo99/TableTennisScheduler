import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BackgroundComponent } from './background/background.component';
import { EventDetailsComponent } from './event-details/event-details.component';
import { EventsListComponent } from './events-list/events-list.component';
import { RegistrationComponent } from './registration/registration.component';

const routes: Routes = [
  { path: '', component: BackgroundComponent },
  { path: 'tournaments/all', component: EventsListComponent },
  { path: 'tournaments/details/:id', component: EventDetailsComponent },
  { path: 'register', component: RegistrationComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
