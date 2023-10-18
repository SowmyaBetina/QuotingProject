import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { FeatureService } from 'src/services/feature.service';

@Component({
  selector: 'app-feature',
  templateUrl: './feature.component.html',
  styleUrls: ['./feature.component.css']
})
export class FeatureComponent implements OnInit{
  features!: any[];
  productName!: string;

  constructor(
    private featureService: FeatureService,
    private route: ActivatedRoute 
  ) {}

  ngOnInit(): void {
    const productName = this.route.snapshot.paramMap.get('name');

    this.featureService.getFeaturesForProduct(productName).subscribe((data: any) => {
      console.log(data);
      
      this.features = data;
    });
  }

}
