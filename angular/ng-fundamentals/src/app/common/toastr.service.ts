import { Injectable } from "@angular/core";

declare let toastr: any;

@Injectable()
export class ToastrService {

    public success(message: string, title?: string): void {
        toastr.success(message, title);
    }

    public info(message: string, title?: string): void {
        toastr.info(message, title);
    }

    public warning(message: string, title?: string): void {
        toastr.warning(message, title);
    }

    public error(message: string, title?: string): void {
        toastr.error(message, title);
    }

}