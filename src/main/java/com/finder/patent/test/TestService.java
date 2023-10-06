package com.finder.patent.test;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TestService {

    private final TestDao testDao;

    public String getTestData() {
        return testDao.getTestData();
    }
}
