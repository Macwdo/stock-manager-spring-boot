package br.com.gordao.service;

import br.com.gordao.entity.Product;
import br.com.gordao.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getProductList() {
        Iterable<Product> productIterable = this.productRepository.findAll();
        return Streamable.of(productIterable).stream().toList();
    }

    public Product createProduct(Product product){
        this.productRepository.save(product);
        return product;
    }

    public void deleteProduct(Long id){
        this.productRepository.deleteById(id);
    }

    public Product getProduct(Long id){
        return this.productRepository.findById(id).get();
    }

    public Product editProduct(Long id, Product product){
        return this.productRepository.save(product);
    }

}
