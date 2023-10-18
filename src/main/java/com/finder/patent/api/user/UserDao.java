package com.finder.patent.api.user;

import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class UserDao {

    private final SqlSession sqlSession;
    
    private String namespace = "com.finder.patent.user.mapper";

    public Map<String, Object> getFieldAndItem(String number) {
        return sqlSession.selectOne(namespace + ".getFieldAndItem", number);
    }

    public List<Map<String, Object>> selectPatentListByNumberDetail(Map<String, Object> param) {
        return sqlSession.selectList(namespace + ".selectPatentListByNumberDetail", param);
    }

    public List<Map<String, Object>> selectPatentListByNumberRange(Map<String, Object> param) {
        return sqlSession.selectList(namespace + ".selectPatentListByNumberRange", param);
    }

    public Integer selectParentListByNumberDetailCount(Map<String, Object> param) {
        return sqlSession.selectOne(namespace + ".selectParentListByNumberDetailCount", param);
    }

    public Integer selectPatentListByNumberRangeCount(Map<String, Object> param) {
        return sqlSession.selectOne(namespace + ".selectPatentListByNumberRangeCount", param);
    }
}
