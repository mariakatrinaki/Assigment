package gr.mariakapa.cinema.RestController;

import gr.mariakapa.cinema.Entity.Order;
import gr.mariakapa.cinema.Entity.Product;
import gr.mariakapa.cinema.Repository.ProductRepository;
import gr.mariakapa.cinema.RequestResponse.OrderResponse;
import gr.mariakapa.cinema.Service.OrderSevice;
import gr.mariakapa.cinema.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {

      @Autowired
      OrderSevice orderSevice;

      @Autowired
      UserService userService;

      @Autowired
      ProductRepository productRepository;

      @PostMapping("/saveOrder")
      public Order saveOrder(@RequestBody Order order){
         return  orderSevice.saveOrder(order);
      }


      @GetMapping("/order/{id}")
      public List<Product> findOrderById(@PathVariable int id){

            return productRepository.findAllByOrderDetails(id);
      }


    @DeleteMapping("/deleteOrder/{idOrder}")

      public void deleteOrderById(@PathVariable int idOrder ){
            orderSevice.deleteOrderById(idOrder);
    }

}
