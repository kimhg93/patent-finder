package com.finder.patent.api.ipc;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class IpcService {

    private final IpcDao ipcDao;

    public Map<String, Object> getFieldAndItem(String number) {
        return ipcDao.getFieldAndItem(number);
    }

    public List<Map<String, Object>> selectPatentListByNumber(Map<String, Object> param) {
        String searchType = param.get("searchType").toString();

        if("detail".equalsIgnoreCase(searchType)){
            return ipcDao.selectPatentListByNumberDetail(param);
        } else {
            return ipcDao.selectPatentListByNumberRange(param);
        }

    }

    public Integer selectParentListByNumberCount(Map<String, Object> param) {
        String searchType = param.get("searchType").toString();

        if("detail".equalsIgnoreCase(searchType)){
            return ipcDao.selectParentListByNumberDetailCount(param);
        } else {
            return ipcDao.selectPatentListByNumberRangeCount(param);
        }
    }
}
