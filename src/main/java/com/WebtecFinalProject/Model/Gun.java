package com.WebtecFinalProject.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

@Data
@Entity
public class Gun {

    @Id
    @GeneratedValue
    private UUID id;

    private String manufacturer;

    private String model;

    @Column(name = "`guntype`")
    @Enumerated(EnumType.STRING)
    private Guntype guntype;

    private String serialNumber;

    private Date purchaseDate;

    private String registrationNumber;

    @OneToMany(mappedBy = "gun")
    private List<Request> requests;


}
