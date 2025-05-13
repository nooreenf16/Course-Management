package com.example.instructor;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GenerationType;
import jakarta.persistence.SequenceGenerator;

@Entity
@Table(name = "instructor")
public class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "instructor_seq_generator")
    @SequenceGenerator(name = "instructor_seq_generator", sequenceName = "instructor_id_seq", allocationSize = 1)
    private Long id;
    private String name;
    private String office;
    private String phone;
    private String email;

    public Instructor() {
    }

    public Instructor(String name, String office, String phone, String email) {
        this.name = name;
        this.office = office;
        this.phone = phone;
        this.email = email;
    }

    public Instructor(Long id, String name, String office, String phone, String email) {
        this.id = id;
        this.name = name;
        this.office = office;
        this.phone = phone;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() { return email;}
    public void setEmail(String email) { this.email = email;}
}
