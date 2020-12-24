package com.example.authentfication.entities;

import com.example.authentfication.entities.common.BasicEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;

@Entity
@Data @ToString @NoArgsConstructor @AllArgsConstructor
public class AppRole extends BasicEntity {
    private static final long serialVersionUID = 48970;





    private String roleName;
}
