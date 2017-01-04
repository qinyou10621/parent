package com.dao;

import com.pojo.Classes;
import com.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Mappers {

    public List<Classes> findClassesByName(String name);

    public void insertUser(String username, String password);

}
