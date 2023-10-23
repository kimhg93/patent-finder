package com.finder.patent.api.tech;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class TechService {

    private final TechDao techDao;

    public List<Map<String, Object>> selectTechFiled() {
        return techDao.selectTechField();
    }

    public List<Map<String, Object>> selectTechItems(int techFieldNo) {
        return techDao.selectTechItems(techFieldNo);
    }

    public List<Map<String, Object>> selectTechEtcs() {
        return techDao.selectTechEtcs();
    }

    public List<Map<String, Object>> selectPatentList(Map<String, Object> param) {
        String source = param.get("source").toString();
        String searchType = param.get("searchType").toString();
        return SearchType.fromString(source, searchType).fetchData(param, techDao);
    }

    public Integer selectParentListCount(Map<String, Object> param){
        String source = param.get("source").toString();
        String searchType = param.get("searchType").toString();
        return SearchType.fromString(source, searchType).fetchCount(param, techDao);
    }

    public Map<String, Object> getFieldAndItem(String number) {
        return techDao.getFieldAndItem(number);
    }
}
