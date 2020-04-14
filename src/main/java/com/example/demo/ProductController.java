package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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

//    @RequestMapping("/edit/{id}")
//    public ModelAndView showEditProductPage(@PathVariable(name = "id") int id) {
//        ModelAndView mav = new ModelAndView("edit_product");
//        Products product = productService.get(id);
//        mav.addObject("product", product);
//
//        return mav;
//    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditProductPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("edit_product");
        Products product = productService.get(id);
        mav.addObject("product", product);

        return mav;
    }

    @RequestMapping(value = "/edit/{id}/save", method = RequestMethod.POST)
    public String editProduct(@RequestParam("productName") String productName, @RequestParam("productId") Integer productId) {
        Products pro = new Products(productId, productName);
        productService.save(pro);

        return "redirect:/";
    }


    @RequestMapping("/delete/{id}")
    public String deleteProduct(@PathVariable(name = "id") int id) {
        productService.delete(id);
        return "redirect:/";
    }


}