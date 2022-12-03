package mk.finki.ukim.mk.lab.service.implementations;

import mk.finki.ukim.mk.lab.model.Order;
import mk.finki.ukim.mk.lab.repository.OrderRepository;
import mk.finki.ukim.mk.lab.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImplementation implements OrderService{

    private final OrderRepository orderRepository; //dependency

    public OrderServiceImplementation(OrderRepository order){
        this.orderRepository = order;
    }

    @Override
    public Order placeOrder(String balloonColor, String clientName, String address, String size) {
        Order obj = new Order(balloonColor,size,clientName,address,null);
        orderRepository.addNewOrders(obj);
        return obj;
    }
    public List<Order> getAllOrders(){
        return orderRepository.getAllOrders();
    }
}
