import { Injectable } from "@angular/core";
import { IUser } from "./user.model";

@Injectable()
export class AuthService {

    public currentUser?: IUser;

    public loginUser(username: string, password: string): void {
        this.currentUser = {
            id: 1,
            firstname: "Cedric",
            lastname: "Zitzmann",
            username
        }
    }

    public isAuthenticated(): boolean {
        return !!this.currentUser;
    }

    public updateCurrentUser(firstname: string, lastname: string): void {
        if(this.currentUser) {
            this.currentUser.firstname = firstname;
            this.currentUser.lastname = lastname;
        }
    }

}