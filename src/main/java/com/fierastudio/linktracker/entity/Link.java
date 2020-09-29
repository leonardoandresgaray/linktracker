package com.fierastudio.linktracker.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(	name = "link" )
public class Link {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    @Size(max = 2048)
    private String target;

    @NotBlank
    @Size(max = 200)
    private String link;

    @NotBlank
    @Size(max = 200)
    private String password;
}
