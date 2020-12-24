package com.example.authentfication.service;

import com.example.authentfication.entities.AppRole;
import com.example.authentfication.entities.AppUser;

import java.util.List;

public interface AccountService {
    public AppUser saveUser(String username,String password,String confirmedPassword);
    public AppUser saveUserAdmin(String username,String password,String confirmedPassword);
    public AppUser saveUserAgent(String username,String password,String confirmedPassword);
    public AppRole save(AppRole role );
    public AppUser loadUserByNameUser(String username);
    public List<AppUser> users();
    void deleteUser(String id) throws Exception;
    public void addRoleToUser(String username,String rolename);

}
