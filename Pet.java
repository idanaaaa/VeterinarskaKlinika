package org.example.veterinarskaklinika.model;

public class Pet {
    private Long id;
    private String name;
    private String rasa;
    private String vrsta;

    public Pet(Long id, String name, String rasa, String vrsta) {
        this.id = id;
        this.name = name;
        this.rasa = rasa;
        this.vrsta = vrsta;
    }


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getRasa() {
        return rasa;
    }

    public String getVrsta() {
        return vrsta;
    }

}
