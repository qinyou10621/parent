package com.service;

import com.pojo.Classes;

import java.util.List;

public interface TestService {
    public List<Classes> findInformation(String className);

    public void insertUser(String username, String password);
}
