package com.finder.patent.api.user;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/*")
public class UserController {

    private final UserService userService;

    @GetMapping(value = "/finder/data")
    public ResponseEntity<Map<String, Object>> selectFinderData(String id, String password, String searchType, int page, int size){
        Map<String, Object> param = new HashMap<>();
        Map<String, Object> result = new HashMap<>();

        if(searchType == null || "".equalsIgnoreCase(searchType)) searchType = "detail";

        param.put("id", id);
        param.put("password", password);
        param.put("searchType", searchType);
        param.put("from", (page-1) * size);
        param.put("size", size);

        result.put("totalCount", userService.selectFinderDataCount(param));
        result.put("list", userService.selectFinderData(param));

        return ResponseEntity.ok().body(result);
    }

    @GetMapping(value = "/name/data")
    public ResponseEntity<Map<String, Object>> selectNameData(String appNm, int page, int size){
        Map<String, Object> param = new HashMap<>();
        Map<String, Object> result = new HashMap<>();


        param.put("appNm", appNm);
        param.put("from", (page-1) * size);
        param.put("size", size);

        result.put("totalCount", userService.selectNameDataCount(param));
        result.put("list", userService.selectNameData(param));

        return ResponseEntity.ok().body(result);
    }


    @GetMapping(value = "/univ/{searchType}")
    public ResponseEntity<Map<String, Object>> selectFinderDataUniv(@PathVariable String searchType,
                                                                    String ipc, int page, int size){
        Map<String, Object> param = new HashMap<>();
        Map<String, Object> result = new HashMap<>();

        param.put("ipc", ipc);
        param.put("searchType", searchType);
        param.put("from", (page-1) * size);
        param.put("size", size);

        result.put("totalCount", userService.selectFinderDetailDataCount(param, 2));
        result.put("list", userService.selectFinderDetailData(param, 2));

        return ResponseEntity.ok().body(result);
    }

    @GetMapping(value = "/comp/{searchType}")
    public ResponseEntity<Map<String, Object>> selectFinderDataComp(@PathVariable String searchType,
                                                                    String ipc, int page, int size){
        Map<String, Object> param = new HashMap<>();
        Map<String, Object> result = new HashMap<>();
        param.put("ipc", ipc);
        param.put("searchType", searchType);
        param.put("from", (page-1) * size);
        param.put("size", size);

        result.put("totalCount", userService.selectFinderDetailDataCount(param, 3));
        result.put("list", userService.selectFinderDetailData(param, 3));

        return ResponseEntity.ok().body(result);
    }


    @GetMapping(value = "/seller/data")
    public ResponseEntity<Map<String, Object>> selectSellerData(String id, String password, String searchType, int page, int size){
        Map<String, Object> param = new HashMap<>();
        Map<String, Object> result = new HashMap<>();
        param.put("id", id);
        param.put("password", password);
        param.put("searchType", searchType);
        param.put("from", (page-1) * size);
        param.put("size", size);

        result.put("totalCount", userService.selectSellerDataCount(param));
        result.put("list", userService.selectSellerData(param));

        return ResponseEntity.ok().body(result);
    }



}
