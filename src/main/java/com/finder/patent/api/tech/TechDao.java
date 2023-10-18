package com.finder.patent.api.tech;

import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class TechDao {

    private final SqlSession sqlSession;
    
    private String namespace = "com.finder.patent.tech.mapper";

    public List<Map<String, Object>> selectTechField() {
        return sqlSession.selectList(namespace + ".selectTechField");
    }

    public List<Map<String, Object>> selectTechItems(int techFieldNo) {
        return sqlSession.selectList(namespace + ".selectTechItems", techFieldNo);
    }

    public List<Map<String, Object>> selectTechEtcs() {
        return sqlSession.selectList(namespace + ".selectTechEtcs");
    }

    public List<Map<String, Object>> selectPatentListByTechDetail(Map<String, Object> param) {
        return sqlSession.selectList(namespace + ".selectPatentListByTechDetail", param);
    }

    public List<Map<String, Object>> selectPatentListByTechRange(Map<String, Object> param) {
        return sqlSession.selectList(namespace + ".selectPatentListByTechRange", param);
    }

    public List<Map<String, Object>> selectPatentListByTechEtcDetail(Map<String, Object> param) {
        return sqlSession.selectList(namespace + ".selectPatentListByTechEtcDetail", param);
    }

    public List<Map<String, Object>> selectPatentListByTechEtcRange(Map<String, Object> param) {
        return sqlSession.selectList(namespace + ".selectPatentListByTechEtcRange", param);
    }

    public Integer selectPatentListByTechDetailCount(Map<String, Object> param) {
        return sqlSession.selectOne(namespace + ".selectPatentListByTechDetailCount", param);
    }

    public Integer selectPatentListByTechRangeCount(Map<String, Object> param) {
        return sqlSession.selectOne(namespace + ".selectPatentListByTechRangeCount", param);
    }

    public Integer selectPatentListByTechEtcDetailCount(Map<String, Object> param) {
        return sqlSession.selectOne(namespace + ".selectPatentListByTechEtcDetailCount", param);
    }

    public Integer selectPatentListByTechEtcRangeCount(Map<String, Object> param) {
        return sqlSession.selectOne(namespace + ".selectPatentListByTechEtcRangeCount", param);
    }

    public Map<String, Object> getFieldAndItem(String number) {
        return sqlSession.selectOne(namespace + ".getFieldAndItem", number);
    }
}
