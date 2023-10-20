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


    public List<Map<String, Object>> selectFinderDataDetail(Map<String, Object> param) {
        return sqlSession.selectList(namespace + ".selectFinderDataDetail", param);
    }

    public List<Map<String, Object>> selectFinderDataRange(Map<String, Object> param) {
        return sqlSession.selectList(namespace + ".selectFinderDataRange", param);
    }

    public Integer selectFinderDataDetailCount(Map<String, Object> param) {
        return sqlSession.selectOne(namespace + ".selectFinderDataDetailCount", param);
    }

    public Integer selectFinderDataRangeCount(Map<String, Object> param) {
        return sqlSession.selectOne(namespace + ".selectFinderDataRangeCount", param);
    }

    // univ
    public List<Map<String, Object>> selectFinderDataUnivDetail(Map<String, Object> param) {
        return sqlSession.selectList(namespace + ".selectFinderDataUnivDetail", param);
    }

    public List<Map<String, Object>> selectFinderDataUnivRange(Map<String, Object> param) {
        return sqlSession.selectList(namespace + ".selectFinderDataUnivRange", param);
    }

    public Integer selectFinderDataUnivDetailCount(Map<String, Object> param) {
        return sqlSession.selectOne(namespace + ".selectFinderDataUnivDetailCount", param);
    }

    public Integer selectFinderDataUnivRangeCount(Map<String, Object> param) {
        return sqlSession.selectOne(namespace + ".selectFinderDataUnivRangeCount", param);
    }

    // comp
    public List<Map<String, Object>> selectFinderDataCompDetail(Map<String, Object> param) {
        return sqlSession.selectList(namespace + ".selectFinderDataCompDetail", param);
    }

    public List<Map<String, Object>> selectFinderDataCompRange(Map<String, Object> param) {
        return sqlSession.selectList(namespace + ".selectFinderDataCompRange", param);
    }

    public Integer selectFinderDataCompDetailCount(Map<String, Object> param) {
        return sqlSession.selectOne(namespace + ".selectFinderDataCompDetailCount", param);
    }

    public Integer selectFinderDataCompRangeCount(Map<String, Object> param) {
        return sqlSession.selectOne(namespace + ".selectFinderDataCompRangeCount", param);
    }

    // seller
    public List<Map<String, Object>> selectSellerData(Map<String, Object> param) {
        return sqlSession.selectList(namespace + ".selectSellerData", param);
    }

    public Integer selectSellerDataCount(Map<String, Object> param) {
        return sqlSession.selectOne(namespace + ".selectSellerDataCount", param);
    }
}
