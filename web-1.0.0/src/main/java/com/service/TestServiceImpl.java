package com.service;

import com.dao.Mappers;
import com.pojo.Classes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TestServiceImpl implements TestService {


    @Autowired
    private Mappers mappers;

    public List<Classes> findInformation(String className) {

        return mappers.findClassesByName(className);
    }

    public void insertUser(String username, String password) {
        mappers.insertUser(username, password);
    }

}
