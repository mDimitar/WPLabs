package mk.finki.ukim.mk.lab.repository;

import mk.finki.ukim.mk.lab.model.Order;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderRepository {

    List<Order> list = new ArrayList<>();
    public void addNewOrders(Order obj){
        list.add(obj);
    }
    public List<Order> getAllOrders(){
        return list;
    }
}
