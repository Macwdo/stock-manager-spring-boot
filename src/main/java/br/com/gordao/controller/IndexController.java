package br.com.gordao.controller;

import br.com.gordao.entity.Product;
import br.com.gordao.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public ModelAndView getList(){
        ModelAndView mv = new ModelAndView("index");

        List<Product> productList = this.productService.getProductList();
        mv.addObject("productList", productList);
        return mv;

    }
}
