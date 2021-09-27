import { Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {map} from "rxjs/operators";
import {Location} from "../models/location";

@Injectable({
  providedIn: 'root'
})

export class LocationService{

  private getUrl: string = 'http://localhost:8080/api/locations';

  constructor(private _httpClient: HttpClient) {}

  getLocations(): Observable<Location[]> {
    return this._httpClient.get<Location[]>(this.getUrl).pipe(
      map(response => response)
    )
  }

  saveLocation(location: Location): Observable<Location> {
    return this._httpClient.post<Location>(this.getUrl, location);
  }

  gerLocation(id: number): Observable<Location> {
    return this._httpClient.get<Location>(`${this.getUrl}/${id}`).pipe(
      map(response => response)
    )
  }

  deleteLocation(id: number): Observable<any> {
    return this._httpClient.delete(`${this.getUrl}/${id}`, {responseType: 'text'});
  }
}
