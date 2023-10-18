package com.finder.patent.api.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserDao userDao;

    public Map<String, Object> getFieldAndItem(String number) {
        return userDao.getFieldAndItem(number);
    }

    public List<Map<String, Object>> selectPatentListByNumber(Map<String, Object> param) {
        String searchType = param.get("searchType").toString();

        if("detail".equalsIgnoreCase(searchType)){
            return userDao.selectPatentListByNumberDetail(param);
        } else {
            return userDao.selectPatentListByNumberRange(param);
        }

    }

    public Integer selectParentListByNumberCount(Map<String, Object> param) {
        String searchType = param.get("searchType").toString();

        if("detail".equalsIgnoreCase(searchType)){
            return userDao.selectParentListByNumberDetailCount(param);
        } else {
            return userDao.selectPatentListByNumberRangeCount(param);
        }
    }
}
