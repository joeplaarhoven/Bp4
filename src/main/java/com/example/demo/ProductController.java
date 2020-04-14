package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;

    @RequestMapping("/")
    public String viewHomePage(Model model) {
        List<Products> listProducts = productService.listAll();
        model.addAttribute("listProducts", listProducts);

        return "index";
    }

    @RequestMapping("/new")
    public String showNewProductPage(Model model) {
        Products products = new Products();
        model.addAttribute("products", products);

        return "new_product";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveProduct(@RequestParam("productName") String productName) {
        Products pro = new Products(productName);
        productService.save(pro);

        return "redirect:/";
    }
//
//    @GetMapping("/add")
//    public String greetingForm(Model model) {
//        model.addAttribute("product", new Product());
//        return "greeting";
//    }
//
//    @PostMapping(path="/add") // Map ONLY POST Requests
//    public @ResponseBody String addNewProduct (@RequestParam String productName) {
//        // @ResponseBody means the returned String is the response, not a view name
//        // @RequestParam means it is a parameter from the GET or POST request
//
//        Product n = new Product();
//        n.setProductName(productName);
//        productRepo.save(n);
//        return "result";
//    }
//
//    @GetMapping("/blog/{id}")
//    public Optional<Product> show(@PathVariable String productIds){
//        int productId = Integer.parseInt(productIds);
//        return productRepo.findById(productId);
//    }
//
//
//
//    @PostMapping("/blog")
//    public Product create(@RequestBody Map<String, String> body){
//        String productName = body.get("productName");
//        return productRepo.save(new Product(productName));
//    }


}