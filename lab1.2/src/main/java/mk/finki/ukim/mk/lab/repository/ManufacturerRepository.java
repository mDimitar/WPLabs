package mk.finki.ukim.mk.lab.repository;

import mk.finki.ukim.mk.lab.model.Balloon;
import mk.finki.ukim.mk.lab.model.Manufacturer;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ManufacturerRepository {
    List<Manufacturer> manufacturer = new ArrayList<>();

    @PostConstruct
    public void init(){
        manufacturer.add(new Manufacturer("Germany","Germany","Germany1"));
        manufacturer.add(new Manufacturer("Switzerland","Switzerland","Switzerland1"));
        manufacturer.add(new Manufacturer("Sweden","Sweden","Sweden1"));
        manufacturer.add(new Manufacturer("Norway","Norway","Norway1"));
        manufacturer.add(new Manufacturer("Italy","Italy","Italy1"));
    }
    public List<Manufacturer> findAll(){
        return this.manufacturer;
    }

    public Optional<Manufacturer> findById(Long id){
        return this.manufacturer.stream().filter(manufacturer -> manufacturer.getId().equals(id)).findFirst();
    }
}
