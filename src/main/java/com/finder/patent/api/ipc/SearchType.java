package com.finder.patent.api.ipc;

import java.util.List;
import java.util.Map;

public enum SearchType {
    MAIN {
        @Override
        public List<Map<String, Object>> fetchData(Map<String, Object> param, IpcDao ipcDao) {
            return ipcDao.selectPatentListByNumber(param);
        }

        @Override
        public Integer fetchCount(Map<String, Object> param, IpcDao ipcDao) {
            return ipcDao.selectPatentListByNumberCount(param);
        }
    },
    MAIN_DETAIL {
        @Override
        public List<Map<String, Object>> fetchData(Map<String, Object> param, IpcDao ipcDao) {
            return ipcDao.selectPatentListByNumberDetail(param);
        }

        @Override
        public Integer fetchCount(Map<String, Object> param, IpcDao ipcDao) {
            return ipcDao.selectParentListByNumberDetailCount(param);
        }
    },
    MAIN_RANGE {
        @Override
        public List<Map<String, Object>> fetchData(Map<String, Object> param, IpcDao ipcDao) {
            return ipcDao.selectPatentListByNumberRange(param);
        }

        @Override
        public Integer fetchCount(Map<String, Object> param, IpcDao ipcDao) {
            return ipcDao.selectPatentListByNumberRangeCount(param);
        }
    };


    public abstract List<Map<String, Object>> fetchData(Map<String, Object> param, IpcDao ipcDao);
    public abstract Integer fetchCount(Map<String, Object> param, IpcDao ipcDao);

    public static SearchType fromString(String searchType) {
        if(searchType == null || "".equalsIgnoreCase(searchType)) return MAIN;
        else if("detail".equalsIgnoreCase(searchType)) return MAIN_DETAIL;
        else return MAIN_RANGE;
    }
}
