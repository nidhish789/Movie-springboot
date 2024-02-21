package com.example.movie.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.movie.Repository.ProductRepo;
import com.example.movie.model.ProductModel;

@Service
public class ProductService {
    private ProductRepo productRepo;
    
    public ProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }
    public boolean saveProduct(ProductModel productModel)
    {
        try {
                productRepo.save(productModel);
            
            } 
            catch (Exception e) {
               return false;
            }
            return true;
        
    }
    public ProductModel getProduct(int id)
    {
        return productRepo.findById(id).orElse(null);
    }
   
    public List<ProductModel>getAllProduct()
    {
        return productRepo.findAll();
    }

    public boolean updateProduct(int id,ProductModel productModel)
    {
        if(this.getProduct(id)==null)
        {
            return false;
        }
        try {
                    productRepo.save(productModel);
            } 
            catch (Exception e) {
               return false;
            }
            return true;
        
    }

    public boolean deleteProduct(int id)
    {
        if(this.getProduct(id)==null)
        {
            return false;
        }
        try {
                    productRepo.deleteById(id);
            } 
            catch (Exception e) {
               return false;
            }
            return true;
    }
}
