package com.finder.patent.api.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserDao userDao;

    public List<Map<String, Object>> selectFinderData(Map<String, Object> param) {
        String type = param.get("searchType").toString();
        return SearchType.fromString(type, 1).fetchData(param, userDao);
    }

    public Integer selectFinderDataCount(Map<String, Object> param) {
        String type = param.get("searchType").toString();
        return SearchType.fromString(type, 1).fetchCount(param, userDao);
    }

    public List<Map<String, Object>> selectFinderDetailData(Map<String, Object> param, int buttonType) {
        String type = param.get("searchType").toString();
        return SearchType.fromString(type, buttonType).fetchData(param, userDao);
    }

    public Integer selectFinderDetailDataCount(Map<String, Object> param, int buttonType) {
        String type = param.get("searchType").toString();
        return SearchType.fromString(type, buttonType).fetchCount(param, userDao);
    }

    public List<Map<String, Object>> selectSellerData(Map<String, Object> param) {
        return userDao.selectSellerData(param);
    }

    public Integer selectSellerDataCount(Map<String, Object> param) {
        return userDao.selectSellerDataCount(param);
    }

    public List<Map<String, Object>> selectNameData(Map<String, Object> param) {
        return userDao.selectNameData(param);
    }

    public Integer selectNameDataCount(Map<String, Object> param) {
        return userDao.selectNameDataCount(param);
    }
}
