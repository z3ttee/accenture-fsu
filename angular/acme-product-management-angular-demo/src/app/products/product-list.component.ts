import { Component, OnInit } from "@angular/core";
import products from "../../api/products/products.json"
import { IProduct } from "./product";

@Component({
    selector: "pm-products",
    templateUrl: "./product-list.component.html",
    styleUrls: ["./product-list.component.css"]
})
export class ProductListComponent implements OnInit {
    
    pageTitle: string = "Product List";
    imageWidth: number = 50;
    imageMargin: number = 2;
    showImage: boolean = false;

    products: IProduct[] = products

    private _listFilter: string = "";

    get listFilter(): string {
        return this._listFilter;
    }
    set listFilter(value: string) {
        this._listFilter = value;
        console.log("Filter: " + value);
    }

    public toggleImage(): void {
        this.showImage = !this.showImage;
    }

    public ngOnInit(): void {
        console.log("this is OnInit");
    }
}