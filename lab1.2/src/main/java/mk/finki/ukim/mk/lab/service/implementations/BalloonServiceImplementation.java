package mk.finki.ukim.mk.lab.service.implementations;

import mk.finki.ukim.mk.lab.model.Balloon;
import mk.finki.ukim.mk.lab.model.Manufacturer;
import mk.finki.ukim.mk.lab.repository.BalloonRepository;
import mk.finki.ukim.mk.lab.repository.ManufacturerRepository;
import mk.finki.ukim.mk.lab.service.BalloonService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BalloonServiceImplementation implements BalloonService {

    //BalloonService треба да зависи од BalloonRepository
    private final BalloonRepository balloonRepository; //dependecies se final!!
    private final ManufacturerRepository manufacturerRepository;

    //constructor
    public BalloonServiceImplementation(BalloonRepository balloonRepository,ManufacturerRepository manufacturerRepository){
        this.manufacturerRepository = manufacturerRepository;
        this.balloonRepository = balloonRepository;
    }

    @Override
    public List<Balloon> listAll() {
        return balloonRepository.findAllBalloons();
    }

    @Override
    public List<Balloon> searchByNameOrDescription(String text) {

        List<Balloon> equal = new ArrayList<>();
        equal = balloonRepository.findAllByNameOrDescription(text);

        return equal;
    }

    @Override
    public Balloon addBalloon(String name, String description, Long manufacturerId) {
        Manufacturer manu = manufacturerRepository.findById(manufacturerId).get();
        Balloon balloon = new Balloon(name,description,manu);
        balloonRepository.save(balloon);
        return balloon;
    }

    @Override
    public Balloon findById(Long id) {
        Optional<Balloon> balloon = balloonRepository.findById(id);
        //ako balonot postoi
        //optional isPresent() vrakja bool
        if(balloon.isPresent())
            return balloon.get();
        //else
        return null;
    }
    public Balloon updateBalloon(Long id, String name, String description, Long manufacturerId){
        Balloon bal = balloonRepository.findById(id).get();
        bal.setName(name);
        bal.setDescription(description);
        Manufacturer manufacturer = manufacturerRepository.findById(manufacturerId).get();
        bal.setManufacturer(manufacturer);
        balloonRepository.save(bal);
        return bal;
    }
    public Balloon delete(Long id){
        Balloon balloon = balloonRepository.findById(id).get();
        balloonRepository.delete(balloon);
        return balloon;
    }
}

