package com.example.authentfication.entities.common;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@AllArgsConstructor
public abstract class BasicEntity implements Serializable {

	 static final long serialVersionUID = 35311;
	 
	 @Id
	 @JsonProperty("_id")
	 private String id;

	 
	 public BasicEntity() {
		 super();
		 this.id=UUID.randomUUID().toString();
	 }

}
