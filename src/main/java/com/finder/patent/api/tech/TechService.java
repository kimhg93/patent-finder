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

    public List<Map<String, Object>> selectPatentListByTechDetail(Map<String, Object> param) {
        return techDao.selectPatentListByTechDetail(param);
    }

    public List<Map<String, Object>> selectPatentListByTechRange(Map<String, Object> param) {
        return techDao.selectPatentListByTechRange(param);
    }

    public List<Map<String, Object>> selectPatentListByTechEtcDetail(Map<String, Object> param) {
        return techDao.selectPatentListByTechEtcDetail(param);
    }

    public List<Map<String, Object>> selectPatentListByTechEtcRange(Map<String, Object> param) {
        return techDao.selectPatentListByTechEtcRange(param);
    }

    public List<Map<String, Object>> selectPatentList(Map<String, Object> param) {
        String source = param.get("source").toString();
        String searchType = param.get("searchType").toString();

        if("main".equalsIgnoreCase(source)){
            if("detail".equalsIgnoreCase(searchType)){
                return selectPatentListByTechDetail(param);
            } else {
                return selectPatentListByTechRange(param);
            }
        } else {
            if("detail".equalsIgnoreCase(searchType)){
                return selectPatentListByTechEtcDetail(param);
            } else {
                return selectPatentListByTechEtcRange(param);
            }
        }
    }

    public Integer selectParentListCount(Map<String, Object> param){
        String source = param.get("source").toString();
        String searchType = param.get("searchType").toString();

        if("main".equalsIgnoreCase(source)){
            if("detail".equalsIgnoreCase(searchType)){
                return techDao.selectPatentListByTechDetailCount(param);
            } else {
                return techDao.selectPatentListByTechRangeCount(param);
            }
        } else {
            if("detail".equalsIgnoreCase(searchType)){
                return techDao.selectPatentListByTechEtcDetailCount(param);
            } else {
                return techDao.selectPatentListByTechEtcRangeCount(param);
            }
        }
    }

    public Map<String, Object> getFieldAndItem(String number) {
        return techDao.getFieldAndItem(number);
    }
}
