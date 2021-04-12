import { Component, OnInit } from '@angular/core';
import { UserSettings } from "../data/user-settings";

@Component({
  selector: 'app-user-settings-form',
  templateUrl: './user-settings-form.component.html',
  styleUrls: ['./user-settings-form.component.css']
})
export class UserSettingsFormComponent implements OnInit {

  originalUserSettings: UserSettings = {
    name: "Milton",
    emailOffers: true,
    interfaceStyle: "dark",
    subscriptionType: "2",
    notes: "Some notes..."
  }

  userSettings: UserSettings = { ...this.originalUserSettings }

  constructor() { }

  

  ngOnInit(): void {
  }

}
