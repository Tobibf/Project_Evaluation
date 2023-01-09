package com.project.isge.project.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Module {
    @Id
    @GeneratedValue
    private long id;

    @Column(unique = true)
    private String name;

    @OneToMany(mappedBy = "module", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Evaluation> evaluationList = new ArrayList<>();

    private LocalDate createdAt;
    @PrePersist
    public void setup() {
        this.createdAt = LocalDate.now();
    }
}
