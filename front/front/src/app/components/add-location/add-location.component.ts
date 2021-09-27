import { Component, OnInit } from '@angular/core';
import {LocationService} from "../../services/location.service";
import {ActivatedRoute, Router} from "@angular/router";
import {Location} from "../../models/location";

@Component({
  selector: 'app-add-location',
  templateUrl: './add-location.component.html',
  styleUrls: ['./add-location.component.css']
})

export class AddLocationComponent implements OnInit {

  location: Location= new Location();

  constructor(private _locationService: LocationService,
              private _router: Router,
              private _activatedRoute: ActivatedRoute) { }

  ngOnInit(): void {
    const isIdPresent = this._activatedRoute.snapshot.paramMap.has('id');
    if (isIdPresent) {
      // @ts-ignore
      const id = +this._activatedRoute.snapshot.paramMap.get('id');
      this._locationService.gerLocation(id).subscribe(
        data => this.location = data
      )
    }
  }

  saveLocation() {
    if (this.location.locations != '' && this.location.locations != null
        && this.location.title != '' && this.location.title != null) {
      this._locationService.saveLocation(this.location).subscribe(
        data => {
          console.log('response', data);
          this._router.navigateByUrl("/locations");
        }
      )
    } else {
      console.log('Parameters must be not empty!');
    }
  }

  deleteLocation(id: number) {
    this._locationService.deleteLocation(id).subscribe(
      data => {
        console.log('delete response', data);
        this._router.navigateByUrl("/locations");
      }
    )
  }

}
