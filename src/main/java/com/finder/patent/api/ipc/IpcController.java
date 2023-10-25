package com.finder.patent.api.ipc;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/*")
public class IpcController {

    private final IpcService ipcService;

    @GetMapping(value = "/data/number/{appNumber}")
    public ResponseEntity<Map<String, Object>> getFieldAndItem(@PathVariable String appNumber,
                                                               String searchType, String source, int page, int size){
        Map<String, Object> result = new HashMap<>();
        Map<String, Object> param = new HashMap<>();

        param.put("appNumber", appNumber);
        param.put("searchType", searchType == null ? "" : searchType);
        param.put("source", source);
        param.put("from", (page-1) * size);
        param.put("size", size);

        result.put("totalCount", ipcService.selectParentListByNumberCount(param));
        result.put("list", ipcService.selectPatentListByNumber(param));


        return ResponseEntity.ok().body(result);
    }



}
