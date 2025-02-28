package com.example.authentfication.dao;

import com.example.authentfication.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface AppUserRepo extends JpaRepository<AppUser,String> {
    public AppUser findByUsername(String username);
}
