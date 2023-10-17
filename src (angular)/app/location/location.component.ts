import { Component } from '@angular/core';
import { LocationService } from 'src/services/location.service';
import { OnInit } from '@angular/core';
import axios from 'axios';
@Component({
  selector: 'app-location',
  templateUrl: './location.component.html',
  styleUrls: ['./location.component.css']
})
export class LocationComponent implements OnInit {
  locationDetails: any[] = [];
   location: any = {};
  // private apiUrl = "https://international-street.api.smarty.com/verify";
   constructor(private locationService: LocationService) { }
  // private authID = "bbaa299a-dd4a-e323-175f-9913b057ac20";
  // private authToken = "exehWj2KjOv4Dd0Bogyw";
  // private key = "180409436444364927";
  // ngOnInit(): void {
  //   this.locationService.getLocationDetails().subscribe((data) => {
  //     this.locationDetails = data;
  //   });
  //   this.verifyLocation();
  // }
  // verifyLocation(): void {
  //   axios.get(this.apiUrl, { params: { "key": this.key } }).then(response => console.log(response.data))
  // }
  //onSubmit() {
  //   this.locationService.addLocation(this.location).subscribe(
  //     (data) => {

  //       console.log('Location added successfully:', data);
  //       this.location = {};
  //     },

  //   );
  // }
  //}
  ngOnInit(): void {
    this.locationService.getLocationDetails().subscribe((data) => {
      this.locationDetails = data;
    });
  }
  onSubmit() {
    this.locationService.addLocation(this.location).subscribe(
      (data) => {
        
        console.log('Location added successfully:', data);

        
        this.location = {};
      },
      (error) => {
        
        console.error('Error adding location:', error);
      }
    );
  }

}

