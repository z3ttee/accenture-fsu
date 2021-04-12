import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { UserSettings } from './user-settings';

@Injectable({
  providedIn: 'root'
})
export class DataService {

  constructor(private http: HttpClient) {}

  postUserSettingsForm(userSettings: UserSettings): Observable<any> {
      //return of(userSettings);
      return this.http.post("https://3460935248ae5fd66cccf0095db6da40.m.pipedream.net/", userSettings);
  }

  getSubscriptionTypes(): Observable<any> {
    return of(["Monthly", "Annual", "Lifetime"])
  }
}
