package mk.finki.ukim.mk.lab.model;

import lombok.Data;


@Data
public class Balloon {
    private String name;
    private String description;

    private Long id;

    Manufacturer manufacturer;


    public Balloon(String name, String description, Manufacturer manufacturer){
        this.name = name;
        this.description = description;
        this.id = (long)(Math.random() * 1000);
        this.manufacturer = manufacturer;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Long getId() {
        return id;
    }
}
