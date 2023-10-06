package com.finder.patent.test;

import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class TestDao {

    private final SqlSession sqlSession;

    public String getTestData(){
        return sqlSession.selectOne("default-mapper.selectOneTest");
    }
}
