package com.fierastudio.linktracker.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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
    @JsonIgnore
    private String password;

    @NotNull
    private Boolean valid;

    @Column(name="expiration_time")
    private Boolean expirationTime;

    public Link(){

    }

    public Link(String url, String password, String link){
        this.target = url;
        this.password = password;
        this.link = link;
        this.valid = Boolean.TRUE;
    }
}
