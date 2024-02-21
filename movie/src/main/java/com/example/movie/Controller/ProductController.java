package com.example.movie.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.movie.Service.ProductService;
import com.example.movie.model.ProductModel;

@RestController
public class ProductController {
    private ProductService productService;
    

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/product")
    public ResponseEntity<ProductModel>postProduct(@RequestBody ProductModel productModel)
    {
        if(productService.saveProduct(productModel)==true)
        {
            return new ResponseEntity<>(productModel,HttpStatus.CREATED);
        }
        return new ResponseEntity<>(productModel,HttpStatus.INTERNAL_SERVER_ERROR);
        
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<ProductModel> getProduct(@PathVariable("id") int id)
    {
        ProductModel p=productService.getProduct(id);
        if(p==null)
        {
            return new ResponseEntity<>(p,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(p,HttpStatus.OK);
       
        
    }

    @GetMapping("/products")
    public ResponseEntity<List<ProductModel>> getProducts()
    {
        List<ProductModel>b=productService.getAllProduct();
        if(b.size()==0)
        {
            return new ResponseEntity<>(b,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(b,HttpStatus.OK);
    }

    @PutMapping("products/{id}")
    public ResponseEntity<ProductModel> putMethodName(@PathVariable("id") int id, @RequestBody  ProductModel productModel)
    {
        if(productService.updateProduct(id,productModel)==true)
        {
            return new ResponseEntity<>(HttpStatus.OK);
            
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("products/{id}")
    public ResponseEntity<ProductModel>delete(@PathVariable int id)
    {
        if(productService.deleteProduct(id)==true)
        {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
