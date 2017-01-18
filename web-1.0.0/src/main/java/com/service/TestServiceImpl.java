package com.service;

import com.dao.Mappers;
import com.pojo.Classes;
import com.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

import java.util.List;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private Mappers mappers;

    @Autowired
    private ShardedJedisPool sharedJedisPool;

//    @Autowired
//    private JedisCluster jedisCluster;

    /**
     * 测试单redis客户端读写redis缓存
     */
    public void redisSetTestMS(String key, String value) {
        ShardedJedis shardeJedis = sharedJedisPool.getResource();
        shardeJedis.set(key, value);
    }

    public void redisGetTestMS(String key) {
        ShardedJedis shardeJedis = sharedJedisPool.getResource();
        String result = shardeJedis.get(key);
        System.out.println(result);
    }

    /**
     * 测试redis集群写功能
     */
//    public void redisTestCluster(String key, String value) {
//
//        jedisCluster.set(key, value);
//    }
    public List<Classes> findInformation(String className) {

        return mappers.findClassesByName(className);
    }

    public void insertUser(String username, String password) {

        mappers.insertUser(username, password);
    }

    public void update(Student student) {

        mappers.upDate(student);
    }


}
