package com.example.authentfication.entities;

import com.example.authentfication.entities.common.BasicEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@Entity
@Data  @AllArgsConstructor @NoArgsConstructor @ToString
public class AppUser extends BasicEntity {
    private static final long serialVersionUID = 90170;
    @Column(unique = true)
    private String username;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    private boolean activated;
    //private Date createdAt;
   // private Date updatedAt;
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<AppRole> roles=new ArrayList<>();
    @ManyToOne
    private ContactUser contactUser;
}
