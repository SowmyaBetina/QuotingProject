import { Component } from '@angular/core';
import { ProductService } from 'src/services/product.service';
@Component({
  selector: 'app-configuration',
  templateUrl: './configuration.component.html',
  styleUrls: ['./configuration.component.css']
})
export class ConfigurationComponent {
  products: string[] = []; 

  constructor(private productService: ProductService) {}

  ngOnInit(): void {
    this.productService.getProductNames().subscribe((data: string[]) => {
      this.products = data;
    });
  }

}
