package com.dao;

import java.util.List;

import com.pojo.Classes;
import org.springframework.stereotype.Repository;

@Repository
public interface Mappers {
    public List<Classes> findClassesByName(String name);
}
