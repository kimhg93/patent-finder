package com.finder.patent.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class MainService {

    private final MainDao mainDao;

    public List<Map<String, Object>> selectTechFiled() {
        return mainDao.selectTechField();
    }

    public List<Map<String, Object>> selectTechItems(int techFieldNo) {
        return mainDao.selectTechItems(techFieldNo);
    }

    public List<Map<String, Object>> selectTechEtcs() {
        return mainDao.selectTechEtcs();
    }
}
