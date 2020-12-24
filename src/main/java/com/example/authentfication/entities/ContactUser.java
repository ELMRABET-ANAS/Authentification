package com.example.authentfication.entities;

import com.example.authentfication.entities.common.BasicEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ContactUser extends BasicEntity {
    private static final long serialVersionUID = 23450;
    private String type_contact;
    private String contact;

}
