package com.project.isge.project.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.persistence.Id;
import lombok.Data;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Evaluation {
    @Id
    @GeneratedValue
    private int id;

    private String name;

    private float average;


    @OneToMany(mappedBy = "author", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Criterion> todoList  = new ArrayList<>();
    private LocalDate createdAt;


    @PrePersist
    public void setup() {
        this.createdAt = LocalDate.now();
    }
}
