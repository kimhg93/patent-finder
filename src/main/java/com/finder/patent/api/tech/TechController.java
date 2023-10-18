package com.finder.patent.api.tech;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/*")
public class TechController {

    private final TechService techService;

    @GetMapping(value = "/tech")
    public ResponseEntity<List<Map<String, Object>>> tech(){
        return ResponseEntity.ok().body(techService.selectTechFiled());
    }

    @GetMapping(value = "/tech/{techFieldNo}")
    public ResponseEntity<List<Map<String, Object>>> techDetail(@PathVariable int techFieldNo){
        return ResponseEntity.ok().body(techService.selectTechItems(techFieldNo));
    }

    @GetMapping(value = "/tech/etc")
    public ResponseEntity<List<Map<String, Object>>> techEtc(){
        List<Map<String, Object>> list = techService.selectTechEtcs();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/data/tech/{techFieldNo}/{techItemNo}")
    public ResponseEntity<Map<String, Object>> patentListByTechDetail(@PathVariable int techFieldNo,
                                                                      @PathVariable int techItemNo,
                                                                      String searchType, String source, int page, int size){
        Map<String, Object> result = new HashMap<>();
        Map<String, Object> param = new HashMap<>();

        param.put("techFieldNo", techFieldNo);
        param.put("techItemNo", techItemNo);
        param.put("searchType", searchType);
        param.put("source", source);
        param.put("from", (page-1) * size);
        param.put("size", size);

        result.put("totalCount", techService.selectParentListCount(param));
        result.put("list", techService.selectPatentList(param));

        return ResponseEntity.ok().body(result);
    }


}
