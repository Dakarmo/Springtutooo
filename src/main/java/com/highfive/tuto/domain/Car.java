package com.highfive.tuto.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "car")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "model")
    private Model model;

    @Column(name = "price")
    private BigDecimal price;

    @OneToMany(mappedBy = "car", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Sale> sales = new ArrayList<>();

    @ManyToMany
    @JoinTable(
        name = "CarEngine",
        joinColumns = @JoinColumn(name = "car"),
        inverseJoinColumns = @JoinColumn(name = "engine")
    )
    private Set<Engine> engines = new HashSet<>();

        @ManyToMany
        @JoinTable(
            name = "CarFeature",
            joinColumns = @JoinColumn(name = "car"),
            inverseJoinColumns = @JoinColumn(name = "feature")
            
        )
    private Set<Feature> features = new HashSet<>();

    
}
