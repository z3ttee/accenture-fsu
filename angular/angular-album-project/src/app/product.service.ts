import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import { pipe } from 'rxjs';
import { map } from 'rxjs/add/operator/map';

@Injectable()
export class ProductService {

  private _albumUrl = "../assets/album.json"

  constructor(private _http: Http) { }

  public getAlbum(id: number) {
    return this._http.get(this._albumUrl);
  }
}
