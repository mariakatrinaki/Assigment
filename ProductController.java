package gr.mariakapa.cinema.RestController;


import gr.mariakapa.cinema.Entity.Product;
import gr.mariakapa.cinema.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {


     @Autowired
      ProductService productService;

     @PostMapping("/saveProduct")
    public void  saveProduct(@RequestBody Product product){
         productService.saveProduct(product);

    }

    @GetMapping("/product/name/{name}")
    public Product findProductByName(@PathVariable String name){

         return productService.findProductByName(name);
    }


    @DeleteMapping("/deleteProduct/{idOrder}/{idProduct}")
    public void deleteProductById(@PathVariable int idOrder,@PathVariable int idProduct){

         productService.deleteProductById(idOrder,idProduct);
    }

}
