import { Component, OnInit } from '@angular/core';
import {LocationService} from "../../services/location.service";
import {Location} from "../../models/location";

@Component({
  selector: 'app-list-location',
  templateUrl: './list-locations.component.html',
  styleUrls: ['./list-locations.component.css']
})

export class ListLocationsComponent implements OnInit {

  locations: Location[] = [];

  filters = {
    keyword: ''
  }

  constructor(private _locationService: LocationService) { }

  ngOnInit(): void {
    this.listLocations();
  }

  deleteLocation(id: number) {
    this._locationService.deleteLocation(id).subscribe(
      data => {
        console.log('delete response', data);
        this.listLocations();
      }
    )
  }

  listLocations(): void {
    this._locationService.getLocations().subscribe(
      data => this.locations = this.filterLocations(data)
    )
  }

  filterLocations(locations: Location[]) {
    return locations.filter((e) => {
      return e.title.toLowerCase().includes(this.filters.keyword.toLowerCase());
    })
  }
}
