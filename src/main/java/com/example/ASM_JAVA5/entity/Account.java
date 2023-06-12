package com.example.ASM_JAVA5.entity;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import org.hibernate.validator.constraints.Length;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    private int status;

    private int role;

    @NotBlank(message = "Please enter your's name")
    private String name;

//    @NotBlank(message = "Please enter your's avatar")
    private String avatar;

    @NotBlank(message = "Please enter your's email")
    @Email(message = "Sai định dạng")
    private String email;

    @NotBlank(message = "Please enter your's username")
    @Length(min = 6, max = 12, message = "Length of username must be from 6 to 12 chacracter")
    private String username;

    @NotBlank(message = "Please enter your's pass")
    @Length(min = 6, max = 12, message = "Length of password must be from 6 to 12 chacracter")
    private String pass;


    @OneToMany(mappedBy = "account", fetch = FetchType.LAZY)
    private List<Order> orderList;
}
