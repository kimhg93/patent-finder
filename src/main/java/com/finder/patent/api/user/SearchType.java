package com.finder.patent.api.user;

import java.util.List;
import java.util.Map;

public enum SearchType {
    MAIN_DETAIL {
        @Override
        public List<Map<String, Object>> fetchData(Map<String, Object> param, UserDao userDao) {
            return userDao.selectFinderDataDetail(param);
        }

        @Override
        public Integer fetchCount(Map<String, Object> param, UserDao userDao) {
            return userDao.selectFinderDataDetailCount(param);
        }
    },
    MAIN_RANGE {
        @Override
        public List<Map<String, Object>> fetchData(Map<String, Object> param, UserDao userDao) {
            return userDao.selectFinderDataRange(param);
        }

        @Override
        public Integer fetchCount(Map<String, Object> param, UserDao userDao) {
            return userDao.selectFinderDataRangeCount(param);
        }
    },
    UNIV_DETAIL {
        @Override
        public List<Map<String, Object>> fetchData(Map<String, Object> param, UserDao userDao) {
            return userDao.selectFinderDataUnivDetail(param);
        }

        @Override
        public Integer fetchCount(Map<String, Object> param, UserDao userDao) {
            return userDao.selectFinderDataUnivDetailCount(param);
        }
    },
    UNIV_RANGE {
        @Override
        public List<Map<String, Object>> fetchData(Map<String, Object> param, UserDao userDao) {
            return userDao.selectFinderDataUnivRange(param);
        }

        @Override
        public Integer fetchCount(Map<String, Object> param, UserDao userDao) {
            return userDao.selectFinderDataUnivRangeCount(param);
        }
    },
    COMP_DETAIL {
        @Override
        public List<Map<String, Object>> fetchData(Map<String, Object> param, UserDao userDao) {
            return userDao.selectFinderDataCompDetail(param);
        }

        @Override
        public Integer fetchCount(Map<String, Object> param, UserDao userDao) {
            return userDao.selectFinderDataCompDetailCount(param);
        }
    },
    COMP_RANGE {
        @Override
        public List<Map<String, Object>> fetchData(Map<String, Object> param, UserDao userDao) {
            return userDao.selectFinderDataCompRange(param);
        }

        @Override
        public Integer fetchCount(Map<String, Object> param, UserDao userDao) {
            return userDao.selectFinderDataCompRangeCount(param);
        }
    };


    public abstract List<Map<String, Object>> fetchData(Map<String, Object> param, UserDao userDao);
    public abstract Integer fetchCount(Map<String, Object> param, UserDao userDao);

    public static SearchType fromString(String searchType, int buttonType) {
        // view type = 1: main 2:univ 3:comp
        switch (buttonType){
            case 1:
                if("detail".equalsIgnoreCase(searchType)) return MAIN_DETAIL;
                else return MAIN_RANGE;
            case 2:
                if("detail".equalsIgnoreCase(searchType)) return UNIV_DETAIL;
                else return UNIV_RANGE;
            case 3:
                if("detail".equalsIgnoreCase(searchType)) return COMP_DETAIL;
                else return COMP_RANGE;
            default: return null;
        }
    }
}
