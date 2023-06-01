package br.com.gordao.controller;

import br.com.gordao.entity.Product;
import br.com.gordao.repository.ProductRepository;
import br.com.gordao.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductService productService;


    @GetMapping("/")
    public ModelAndView getList(){
        ModelAndView mv = new ModelAndView("product/product_list");

        List<Product> productList = this.productService.getProductList();
        mv.addObject("productList", productList);
        return mv;
    }

    @GetMapping("/new")
    public ModelAndView createProduct(){
        ModelAndView mv = new ModelAndView("product/product_form");
        return mv;
    }

    @PostMapping("/save")
    public String saveProduct(@Valid Product product, BindingResult result, RedirectAttributes redirect){
        if (result.hasErrors()){
            redirect.addFlashAttribute(
                    "message",
                    "Verifique os campos obrigatorios"
            );
            return "redirect:/new";
        }
        this.productRepository.save(product);
        return "redirect:/";
    };

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") Long id){
        this.productService.deleteProduct(id);
        return "redirect:/";
    };

    @GetMapping("/edit/{id}")
    public ModelAndView editProduct(@PathVariable("id") Long id){
        ModelAndView mv = new ModelAndView("product/product_edit");

        Product product = this.productService.getProduct(id);
        mv.addObject("product", product);
        return mv;
    };

}
