package ma.mundia.tp2;

import ma.mundia.tp2.entites.Product;
import ma.mundia.tp2.repostory.InterfaceReposotory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class Tp2Application implements CommandLineRunner {
    @Autowired
    private InterfaceReposotory productReposotory;
    @Override
    public void run(String... args) throws Exception {
      //  productReposotory.save(new Product(null,"Computer",9255,5));
      //  productReposotory.save(new Product(null,"Printer",1855,9));
      //  productReposotory.save(new Product(null,"SmartPhone",5255,15));
        List<Product> productList = productReposotory.findAll();
        productList.forEach(produit->{
            System.out.println(produit.toString());
        });
        try{
            Product product=productReposotory.findById(Long.valueOf(1)).orElseThrow(()->new RuntimeException("produit no trouve"));
            System.out.println("************");
            System.out.println(product.getId());
            System.out.println(product.getNom());
            System.out.println(product.getPrix());

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
       List<Product> produi= productReposotory.findByNomContains("n");
        produi.forEach(produit->{
            System.out.println(produit.toString());
        });
        System.out.println("list produit 2");
        List<Product> produi2= productReposotory.search("%C%");
        produi2.forEach(produitr->{
            System.out.println(produitr.toString());
        });
        System.out.println("-----------price------------");
        List<Product> price= productReposotory.findByPrixGreaterThan(555);
        price.forEach(pricepri->{
            System.out.println(pricepri.toString());
        });
    }

    public static void main(String[] args) {
        SpringApplication.run(Tp2Application.class, args);
    }

}
