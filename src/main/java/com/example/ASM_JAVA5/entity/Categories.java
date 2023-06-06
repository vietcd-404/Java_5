package com.example.ASM_JAVA5.entity;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "categories")
public class Categories {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotBlank(message = "Please enter your's name")
    @Column(name = "name")
    private String name;


    @Column(name = "status")
    private int status;

    @OneToMany(mappedBy = "categories", fetch = FetchType.LAZY)
    private List<Product> productList;
}
