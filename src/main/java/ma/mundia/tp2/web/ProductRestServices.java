package ma.mundia.tp2.web;

import ma.mundia.tp2.entites.Product;
import ma.mundia.tp2.repostory.InterfaceReposotory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductRestServices {
    @Autowired
    private InterfaceReposotory productReposotory;
    @GetMapping("/product")
    public List<Product> findAll(){
        return  productReposotory.findAll();
    }
    @GetMapping("/produit/{id}")
    public Product findproduct(@PathVariable Long id){
        return productReposotory.findById(id).get();
    }
}
