package com.sisipapa.mongo.sample;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MongoRepositoryTest {

    @Autowired
    MongoRepository mongoRepository;

    @Test
    void save() {
        User user = User.builder().id(null).name("aaa").email("aaa@a.com").password("aaapwd").build();
        mongoRepository.save(user);
    }

    @Test
    void insert() {
        User user = User.builder().id(null).name("bbb").email("bbb@b.com").password("bbbpwd").build();
        mongoRepository.insert(user);
    }
    @Test
    void findAndModify() {
        User user = User.builder().id(null).name("bbb").email("bbb@b.com").password("bbbpwd").build();
        mongoRepository.findAndModify("name", "aaa", "email", "aaa-0@b.com");
    }

    @Test
    void updateFirst() {
        User user = User.builder().id(null).name("bbb").email("bbb@b.com").password("bbbpwd").build();
        mongoRepository.updateFirst("name", "bbb", "email", "bbb-0@b.com");
    }

    @Test
    void updateMulti() {
        User user = User.builder().id(null).name("bbb").email("bbb@b.com").password("bbbpwd").build();
        mongoRepository.updateMulti("name", "aaa", "email", "aaa-1@b.com");
    }
}