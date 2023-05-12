package br.com.gordao.service;

import br.com.gordao.entity.Product;
import br.com.gordao.entity.Sale;
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
}
