import { Component } from '@angular/core';
import { OnInit } from '@angular/core';
import { ProductService } from 'src/services/product.service';
import { Router } from '@angular/router';
import { FeatureService } from 'src/services/feature.service';
import { ParameterService } from 'src/services/parameter.service';
import { HttpClient } from '@angular/common/http';
@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit{
  products!: any[]; 

  constructor(private http: HttpClient, private productService: ProductService) {}

  ngOnInit(): void {
    
    this.productService.getProducts().subscribe((data: any) => {
      this.products = data;
    });
  }
 

}
