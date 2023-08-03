package com.example.socks.model;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
@Table(name = "socks")
public class Sock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String color;
    private Integer cottonPart;
    @Column(name = "sock_count")
    private Long count;

}
