package com.boats.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "boats")
public class BoatModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String brand;
    private Integer year;
    private String description;
    @ManyToOne
    @JoinColumn(name = "categoryId")
    @JsonIgnoreProperties("boats")
    private CategoryModel category;
    //{doctor,client}
    @OneToMany(mappedBy = "boat")
    @JsonIgnoreProperties({"boat", "client"})
    private List<MessageModel> messages;
    @OneToMany(mappedBy = "boat")
    @JsonIgnoreProperties({"boats", "client"})
    private List<ReservationModel> reservations;

}