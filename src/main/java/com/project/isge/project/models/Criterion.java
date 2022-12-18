package com.project.isge.project.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Criterion {
    @Id
    @GeneratedValue
    private int id;

    @Column(unique = true)
    private String name;

    @ManyToOne
    private Evaluation author;

    private LocalDate createdAt;

    @PrePersist
    public void setup() {
        this.createdAt = LocalDate.now();
    }
}
