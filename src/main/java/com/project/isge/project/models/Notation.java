package com.project.isge.project.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Notation {
    @Id
    @GeneratedValue
    private long id;

    private float note;
    @ManyToOne
    private Evaluation evaluation;

    @ManyToOne
    private Criterion criterion;
}
