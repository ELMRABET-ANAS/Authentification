package com.example.authentfication.dao;

import com.example.authentfication.entities.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface AppRoleRepo extends JpaRepository<AppRole,String> {
    public AppRole findByRoleName(String roleName);
}
