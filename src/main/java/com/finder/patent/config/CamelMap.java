package com.finder.patent.config;

import org.springframework.jdbc.support.JdbcUtils;

import java.util.HashMap;

public class CamelMap extends HashMap {
    // 임시 map
    public Object put(Object key, Object value) {
        return super.put(JdbcUtils.convertUnderscoreNameToPropertyName((String) key), value);
    }
}
