package com.WebtecFinalProject.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@Entity
public class Soldier {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String username;

    private String email;

    @Column(name = "`rank`")
    @Enumerated(EnumType.STRING)
    private Rank rank;

    private int militaryNumber;
    private String password;

    @OneToMany(mappedBy = "soldier")
    private List<Request> requests;
}
