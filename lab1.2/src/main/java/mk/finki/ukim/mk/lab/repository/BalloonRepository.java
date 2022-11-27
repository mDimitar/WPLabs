package mk.finki.ukim.mk.lab.repository;

import mk.finki.ukim.mk.lab.model.Balloon;
import mk.finki.ukim.mk.lab.model.Manufacturer;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class BalloonRepository {

    List<Balloon> list = new ArrayList<>();
    private final ManufacturerRepository manufacturerRepository;

    public BalloonRepository(ManufacturerRepository manufacturerRepository) {
        this.manufacturerRepository = manufacturerRepository;
    }

    @PostConstruct
    public void init(){
        list.add(new Balloon("Red"," Red Balloon",manufacturerRepository.findAll().get(0)));
        list.add(new Balloon("Pink"," Pink Balloon",manufacturerRepository.findAll().get(2)));
        list.add(new Balloon("Blue"," Blue Balloon",manufacturerRepository.findAll().get(3)));
        list.add(new Balloon("Yellow"," Yellow Balloon",manufacturerRepository.findAll().get(4)));
        list.add(new Balloon("Purple"," Purple Balloon",manufacturerRepository.findAll().get(0)));
        list.add(new Balloon("Black"," Black Balloon",manufacturerRepository.findAll().get(1)));
        list.add(new Balloon("White"," White Balloon",manufacturerRepository.findAll().get(2)));
        list.add(new Balloon("Gray"," Gray Balloon",manufacturerRepository.findAll().get(3)));
        list.add(new Balloon("Sky Blue"," Sky Blue Balloon",manufacturerRepository.findAll().get(4)));
        list.add(new Balloon("Green"," Green Balloon",manufacturerRepository.findAll().get(2)));
    }
    public List<Balloon> findAllBalloons(){
        return list;
    }

    public List<Balloon> findAllByNameOrDescription(String text){

        List<Balloon> equal = new ArrayList<>();

        for(int i=0;i<list.size();i++){
            if(list.get(i).getDescription().contains(text) || list.get(i).getName().contains(text)){
                equal.add(list.get(i));
            }
        }
        return equal;
    }
    public Balloon save(Balloon balloon){
        list.removeIf(balloon1 -> balloon1.getId().equals(balloon.getId())); //odstrani go stariot ako veke postoi
        list.add(balloon);
        return balloon;
    }
    public Optional<Balloon> findById(Long id){
        return list.stream().filter(balloon -> balloon.getId().equals(id)).findFirst();
    }
    public void delete(Balloon balloon){
        list.removeIf(balloon1 -> balloon1.getId().equals(balloon.getId()));
    }
}
