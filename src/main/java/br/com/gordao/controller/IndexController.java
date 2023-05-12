package br.com.gordao.controller;

import br.com.gordao.entity.Product;
import br.com.gordao.repository.ProductRepository;
import br.com.gordao.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.UUID;

@Controller
public class IndexController {

    @Autowired
    private ProductService productService;


    @GetMapping("/")
    public ModelAndView homepage(){
        ModelAndView mv = new ModelAndView("index");

        List<Product> productList = this.productService.getProductList();
        mv.addObject("productList", productList);
        return mv;
    }

    @GetMapping("/product/list")
    public ModelAndView getList(){
        ModelAndView mv = new ModelAndView("product/product_list");

        List<Product> productList = this.productService.getProductList();
        mv.addObject("productList", productList);
        return mv;
    }

    @GetMapping("/product/new")
    public ModelAndView createProduct(){
        ModelAndView mv = new ModelAndView("product/product_form");
        return mv;
    }

    @PostMapping("/product/new")
    public String saveProduct(@Valid Product product, BindingResult result, RedirectAttributes redirect){
        if (result.hasErrors()){
            redirect.addFlashAttribute(
                    "message",
                    "Verifique os campos obrigatorios"
            );
            return "redirect:/product/new";
        }
        this.productService.createProduct(product);

        return "redirect:/product/list";
    };

    @PostMapping("/product/delete/{id}")
    public String saveProduct(@PathVariable("id") UUID id ){


        return "redirect:/product/list";
    };
}
