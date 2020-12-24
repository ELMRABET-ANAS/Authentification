package com.example.authentfication.service;

import com.example.authentfication.dao.AppRoleRepo;
import com.example.authentfication.dao.AppUserRepo;
import com.example.authentfication.entities.AppRole;
import com.example.authentfication.entities.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AppUserRepo appUserRepo;
    @Autowired
    private AppRoleRepo appRoleRepo;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;



    @Override
    public AppUser saveUser(String username, String password, String confirmedPassword) {
        AppUser user=appUserRepo.findByUsername(username);
        if(user!=null) throw new RuntimeException("user is already exist");
        if(!password.equals(confirmedPassword)) throw new RuntimeException("please confirm your password!");
        AppUser appUser=new AppUser();
        appUser.setUsername(username);
        appUser.setActivated(true);
        appUser.setPassword(bCryptPasswordEncoder.encode(password));

        appUserRepo.save(appUser);
        addRoleToUser(username,"Admin");
        return appUser;
    }

    @Override
    public AppUser saveUserAdmin(String username, String password, String confirmedPassword) {
        AppUser user=appUserRepo.findByUsername(username);
        if(user!=null) throw new RuntimeException("user is already exist");
        if(!password.equals(confirmedPassword)) throw new RuntimeException("please confirm your password!");
        AppUser appUser=new AppUser();
        appUser.setUsername(username);
        //appUser.setCreatedAt(new Date());
        appUser.setActivated(true);
        appUser.setPassword(bCryptPasswordEncoder.encode(password));

        appUserRepo.save(appUser);
        addRoleToUser(username,"AGENT");
        return appUser;
    }

    @Override
    public AppUser saveUserAgent(String username, String password, String confirmedPassword) {
        AppUser user=appUserRepo.findByUsername(username);
        if(user!=null) throw new RuntimeException("user is already exist");
        if(!password.equals(confirmedPassword)) throw new RuntimeException("please confirm your password!");
        AppUser appUser=new AppUser();
        appUser.setUsername(username);
       // appUser.setCreatedAt(new Date());
        appUser.setActivated(true);
        appUser.setPassword(bCryptPasswordEncoder.encode(password));

        appUserRepo.save(appUser);
        addRoleToUser(username,"Client");
        return appUser;
    }

    @Override
    public AppRole save(AppRole role) {

        return appRoleRepo.save(role);
    }

    @Override
    public AppUser loadUserByNameUser(String username) {

        return appUserRepo.findByUsername(username);
    }

    @Override
    public List<AppUser> users() {
        return appUserRepo.findAll();
    }

    @Transactional
    @Override
    public void deleteUser(String id) throws Exception {
        AppUser user = appUserRepo.findById(id).get();
        if (user == null)
            throw new Exception("user not found");
        try {
            appUserRepo.deleteById(id);

        } catch (Exception ex) {
            System.out.println(ex);

        }

    }

    @Override
    public void addRoleToUser(String username, String rolename) {
         AppUser appUser=appUserRepo.findByUsername(username);
         AppRole appRole=appRoleRepo.findByRoleName(rolename);
         appUser.getRoles().add(appRole);
    }
    @Bean
    BCryptPasswordEncoder getBCPE(){
        return new BCryptPasswordEncoder();
    }
}
