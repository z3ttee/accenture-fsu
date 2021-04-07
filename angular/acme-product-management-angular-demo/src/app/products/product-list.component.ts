import { Component } from "@angular/core";
import products from "../../api/products/products.json"

@Component({
    selector: "pm-products",
    templateUrl: "./product-list.component.html"
})
export class ProductListComponent {
    pageTitle: string = "Product List";
    products: any[] = products;
}