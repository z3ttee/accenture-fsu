import { Component, OnInit } from '@angular/core'
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from './auth.service';

@Component({
  templateUrl: "./profile.component.html"
})
export class ProfileComponent implements OnInit {

  public profileForm!: FormGroup;

  constructor(private authService: AuthService, private router: Router){}

  public ngOnInit(): void {
    let firstname = new FormControl(this.authService.currentUser?.firstname, Validators.required);
    let lastname = new FormControl(this.authService.currentUser?.lastname, Validators.required);

    this.profileForm = new FormGroup({
      firstname,
      lastname
    });
  }

  public save(formValues: any): void {
    if(this.profileForm.valid) {
      this.authService.updateCurrentUser(formValues.firstname, formValues.lastname);
      this.router.navigate(["/"])
    }
  }

  public cancel(): void {
    this.router.navigate(["/"])
  }

}