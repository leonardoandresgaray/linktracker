package com.fierastudio.linktracker.entity;

import lombok.Data;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@Entity
@Table(	name = "link_access" )
public class LinkAccess {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    @ManyToOne
    private Link link;

    @NotBlank
    private Date access_time;
}
