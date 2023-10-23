package com.finder.patent.api.tech;

import java.util.List;
import java.util.Map;

public enum SearchType {
    MAIN_DETAIL {
        @Override
        public List<Map<String, Object>> fetchData(Map<String, Object> param, TechDao techDao) {
            return techDao.selectPatentListByTechDetail(param);
        }

        @Override
        public Integer fetchCount(Map<String, Object> param, TechDao techDao) {
            return techDao.selectPatentListByTechDetailCount(param);
        }
    },
    MAIN_RANGE {
        @Override
        public List<Map<String, Object>> fetchData(Map<String, Object> param, TechDao techDao) {
            return techDao.selectPatentListByTechRange(param);
        }

        @Override
        public Integer fetchCount(Map<String, Object> param, TechDao techDao) {
            return techDao.selectPatentListByTechRangeCount(param);
        }
    },
    ETC_DETAIL {
        @Override
        public List<Map<String, Object>> fetchData(Map<String, Object> param, TechDao techDao) {
            return techDao.selectPatentListByTechEtcDetail(param);
        }

        @Override
        public Integer fetchCount(Map<String, Object> param, TechDao techDao) {
            return techDao.selectPatentListByTechEtcDetailCount(param);
        }
    },
    ETC_RANGE {
        @Override
        public List<Map<String, Object>> fetchData(Map<String, Object> param, TechDao techDao) {
            return techDao.selectPatentListByTechEtcRange(param);
        }

        @Override
        public Integer fetchCount(Map<String, Object> param, TechDao techDao) {
            return techDao.selectPatentListByTechEtcRangeCount(param);
        }
    };


    public abstract List<Map<String, Object>> fetchData(Map<String, Object> param, TechDao techDao);
    public abstract Integer fetchCount(Map<String, Object> param, TechDao techDao);

    public static SearchType fromString(String source, String searchType) {
        if("main".equalsIgnoreCase(source)){
            if("detail".equalsIgnoreCase(searchType)) return MAIN_DETAIL;
            else return MAIN_RANGE;
        } else {
            if("detail".equalsIgnoreCase(searchType)) return ETC_DETAIL;
            else return ETC_RANGE;
        }
    }
}
