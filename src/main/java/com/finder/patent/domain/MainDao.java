package com.finder.patent.domain;

import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class MainDao {

    private final SqlSession sqlSession;

    public List<Map<String, Object>> selectTechField() {
        return sqlSession.selectList("default-mapper.selectTechField");
    }

    public List<Map<String, Object>> selectTechItems(int techFieldNo) {
        return sqlSession.selectList("default-mapper.selectTechItems", techFieldNo);
    }

    public List<Map<String, Object>> selectTechEtcs() {
        return sqlSession.selectList("default-mapper.selectTechEtcs");
    }
}
