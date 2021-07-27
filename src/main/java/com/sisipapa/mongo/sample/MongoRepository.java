package com.sisipapa.mongo.sample;

import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

@AllArgsConstructor
@Repository
public class MongoRepository {

    private MongoTemplate mongoTemplate;

    /**
     * save 등록
     * @param user
     */
    public void save(User user){
        mongoTemplate.save(user);
    }

    /**
     * insert 등록
     * @param user
     */
    public void insert(User user){
        mongoTemplate.insert(user);
    }

    /**
     * 수정과 동시에 조회
     * @param whereField
     * @param whereValue
     * @param updateField
     * @param updateValue
     */
    public void findAndModify(String whereField,
                              String whereValue,
                              String updateField,
                              String updateValue){
        mongoTemplate.findAndModify(
                Query.query(Criteria.where(whereField).is(whereValue)),
                Update.update(updateField, updateValue),
                User.class
        );
    }

    /**
     * 단일 데이터 수정
     * @param whereField
     * @param whereValue
     * @param updateField
     * @param updateValue
     */
    public void updateFirst(String whereField,
                              String whereValue,
                              String updateField,
                              String updateValue){
        mongoTemplate.updateFirst(
                Query.query(Criteria.where(whereField).is(whereValue)),
                Update.update(updateField, updateValue),
                User.class
        );
    }

    /**
     * 복수 데이터 수정
     * @param whereField
     * @param whereValue
     * @param updateField
     * @param updateValue
     */
    public void updateMulti(String whereField,
                              String whereValue,
                              String updateField,
                              String updateValue){
        mongoTemplate.updateMulti(
                Query.query(Criteria.where(whereField).is(whereValue)),
                Update.update(updateField, updateValue),
                User.class
        );
    }
}
