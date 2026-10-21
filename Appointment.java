package org.example.veterinarskaklinika.model;

public class Appointment {
    private Long id;
    private String date;
    private String time;
    private String status;
    private Long petId;

    public Appointment(Long id, String date, String time, String status, Long petId) {
        this.id = id;
        this.date = date;
        this.time = time;
        this.status = status;
        this.petId = petId;
    }

    public Long getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getStatus() {
        return status;
    }

    public Long getPetId() {
        return petId;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setPetId(Long petId) {
        this.petId = petId;
    }

    public void setStatus(String status) {
        this.status = status;
    }



}


