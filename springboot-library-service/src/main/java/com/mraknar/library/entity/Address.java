package com.mraknar.library.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "addresses")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "street", nullable = false,  length = 30)
    private String street;

    @Column(name = "city", nullable = false, length = 30)
    private String city;

    @Column(name = "district", nullable = false, length = 30)
    private String district;

    @Column(name = "country", nullable = false,  length = 30)
    private String country;

    @Column(name = "zipcode", nullable = false,   length = 10)
    private String zipcode;

}






