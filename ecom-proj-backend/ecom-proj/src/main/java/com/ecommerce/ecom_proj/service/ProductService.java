package com.ecommerce.ecom_proj.service;

import com.ecommerce.ecom_proj.model.Product;
import com.ecommerce.ecom_proj.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repo;


    public List<Product> getAllProducts() {
        return repo.findAll();
    }

    public Product getProductById(int id) {
        return repo.findById(id).orElse(null);
    }

    public Product addProduct(Product product, MultipartFile imageFile) throws IOException {
        product.setImageName(imageFile.getOriginalFilename());
        product.setImageTypes(imageFile.getContentType());
        product.setImageData(imageFile.getBytes());
        //product.getImageData();
         return repo.save(product);

    }


    public Product updateProduct(int id, Product product, MultipartFile imageFile) {
        try {
            product.setImageName(imageFile.getOriginalFilename());
            product.setImageTypes(imageFile.getContentType());
            product.setImageData(imageFile.getBytes()); // ✅ Set image data
            return repo.save(product);
        } catch (IOException e) {
            throw new RuntimeException("Failed to read image file", e);
        }
    }

//    public Product updateProduct(int id, Product product, MultipartFile imageFile) {
//        product.setImageName(imageFile.getOriginalFilename());
//        product.setImageTypes(imageFile.getContentType());
//        product.getImageData();
//        return repo.save(product);
//
//    }

    public void deleteProduct(int id) {
        repo.deleteById(id);
    }

    public List<Product> searchProducts(String keyword) {
        return repo.searchProducts(keyword);
    }
}
