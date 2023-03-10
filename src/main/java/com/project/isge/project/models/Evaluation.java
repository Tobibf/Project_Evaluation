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
    private long id;

    private String user;

    @Column(columnDefinition = "integer default 0")
    private float average;

    @ManyToOne
    private Module module;

    @OneToMany(mappedBy = "evaluation", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Notation> noteList  = new ArrayList<>();
    private LocalDate createdAt;


    @PrePersist
    public void setup() {
        this.createdAt = LocalDate.now();
    }
}
