package com.fierastudio.linktracker.entity;

import lombok.Data;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(	name = "link_access" )
public class LinkAccess {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @ManyToOne
    private Link link;

    @NotNull
    private Date access_time;

    public LinkAccess(){

    }

    public LinkAccess(Link link){
        this.link = link;
        this.access_time = new Date();
    }
}
