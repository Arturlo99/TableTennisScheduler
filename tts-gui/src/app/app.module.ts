import { Injectable, NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NavbarComponent } from './navbar/navbar.component';
import { BackgroundComponent } from './background/background.component';
import { HttpClientModule, HttpHandler, HttpInterceptor, HttpRequest, HTTP_INTERCEPTORS } from '@angular/common/http';
import { EventsListComponent } from './events-list/events-list.component';
import { MatCardModule } from '@angular/material/card';
import { MatTableModule } from '@angular/material/table';
import { MatPaginatorModule } from '@angular/material/paginator';
import { EventDetailsComponent } from './event-details/event-details.component';
import { RegistrationComponent } from './registration/registration.component';
import { FormBuilder, ReactiveFormsModule } from '@angular/forms';
import { LoginComponent } from './login/login.component';
import { CreateEventComponent } from './create-event/create-event.component';
import { MatInputModule } from '@angular/material/input';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatNativeDateModule } from '@angular/material/core';
import { MatSelectModule } from '@angular/material/select';
import { MatSortModule } from '@angular/material/sort';
import {MatDialogModule} from '@angular/material/dialog';
import { DialogOverviewExampleComponent } from './events-list/events-list.component';
import { MatDialogContent, MatDialogActions } from '@angular/material/dialog';
import { EditMatchResultsDialogComponent } from './event-details/edit-match-results-dialog/edit-match-results-dialog.component';
import { FormsModule } from '@angular/forms';

@Injectable()
export class XhrInterceptor implements HttpInterceptor {

  intercept(req: HttpRequest<any>, next: HttpHandler) {
    if (sessionStorage.getItem('token') != '') {
      const xhr = req.clone({
        setHeaders: {
          Authorization: 'Basic ' + sessionStorage.getItem('token')
        }
      });
      return next.handle(xhr);
    }
    else {
      const xhr = req.clone({
        headers: req.headers.delete('Authorization')
      });
      return next.handle(xhr);
    }
  }
}

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    BackgroundComponent,
    EventsListComponent,
    EventDetailsComponent,
    RegistrationComponent,
    LoginComponent,
    CreateEventComponent,
    DialogOverviewExampleComponent,
    EditMatchResultsDialogComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatToolbarModule,
    MatButtonModule,
    MatIconModule,
    HttpClientModule,
    MatCardModule,
    MatTableModule,
    MatPaginatorModule,
    ReactiveFormsModule,
    MatInputModule,
    MatDatepickerModule,
    MatNativeDateModule,
    MatSelectModule,
    MatSortModule,
    MatDialogModule,
    FormsModule
  ],
  providers: [{ provide: HTTP_INTERCEPTORS, useClass: XhrInterceptor, multi: true }],
  bootstrap: [AppComponent]
})
export class AppModule { }