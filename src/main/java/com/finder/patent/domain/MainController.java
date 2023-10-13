package com.finder.patent.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class MainController {

    private final MainService mainService;

    @GetMapping(value = "/api/index")
    public ResponseEntity<String> index(){
        return ResponseEntity.ok().body(null);
    }

    @GetMapping(value = "/api/tech")
    public ResponseEntity<List<Map<String, Object>>> tech(){
        return ResponseEntity.ok().body(mainService.selectTechFiled());
    }

    @GetMapping(value = "/api/tech/{techFieldNo}")
    public ResponseEntity<List<Map<String, Object>>> techDetail(@PathVariable int techFieldNo){
        return ResponseEntity.ok().body(mainService.selectTechItems(techFieldNo));
    }

    @GetMapping(value = "/api/tech/etc")
    public ResponseEntity<List<Map<String, Object>>> techEtc(){
        List<Map<String, Object>> list = mainService.selectTechEtcs();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/api/tech/{code}/{codeDetail}")
    public ResponseEntity<List<Map<String, Object>>> detail(@PathVariable int code, @PathVariable int codeDetail){
        List<Map<String, Object>> list = new ArrayList<>();

        addList(list, "10-2022-7020222", "2011.07.11", "인자 IX 폴리펩티드 및 이들의 사용 방법(FACTOR IX POLYPEPTIDES AND METHODS OF USE THEREOF)", "바이오버라티브 테라퓨틱스 인크.(미국 매사추세츠 (우편번호 *****) 월섬 *엔디 에비뉴 ***)","피어스 글렌(미국 * 매사추...)|트루스 사만사(미국 * 매사추...)|피터스 로버트 티(미국 * 매사추세츠...)|장 하이얀(미국 * 매사...)", "10-2022-0097518", "2022.07.07", "", "", "ui001-XXXX", 3,"A61K", "38^48", "협의가능", "02-2000-1114");
        addList(list, "10-2022-7007777", "2011.10.12", "인간 파필로마 바이러스에 대한 백신 및 이것을 사용하는 방법(VACCINES FOR HUMAN PAPILLOMA VIRUS AND METHODS FOR USING THE SAME)", "더 트러스티스 오브 더 유니버시티 오브 펜실베니아(미국 펜실베니아 필라델피아 (우편번호 *****) 월넛 스트리트 **** *플로어)","웨이너 데이비드 비.(미국 * 펜실...)|얀 지안(미국 * 펜실베...)", "10-2022-0035279", "2022.03.21", "", "", "ui001-XXXX", 3,"C07K", "14^005", "협의가능", "02-2000-1114");
        addList(list, "10-2021-7026627", "2011.03.25", "오디오 재생을 위한 오디오 사운드필드 표현을 디코딩하는 방법 및 장치(METHOD AND DEVICE FOR DECODING AN AUDIO SOUNDFIELD REPRESENTATION FOR AUDIO PLAYBACK)", "돌비 인터네셔널 에이비(아일랜드 디** 브이케이** 더블린 그랜드 커널 독랜즈 블록 씨 서 존 로저슨스 키 **)","바트케, 요한-마커스(독일 * 하노버 칼 비헤르트 ...)|케일러, 플로리안(독일 * 하노버 칼 비헤르트 ...)|보엠, 요하네스(독일 * 하노버 칼 비헤르트 ...)", "10-2021-0107165", "2021.08.31", "", "", "ui001-XXXX", 3,"H04S", "3^02", "협의가능", "02-2000-1114");
        addList(list, "10-2019-7006079", "2011.12.31", "상부 레벨 인덱스 파일들을 자동적으로 생성하기 위한 시스템들 및 방법들(SYSTEMS AND METHODS FOR AUTOMATICALLY GENERATING TOP LEVEL INDEX FILES)", "디빅스, 엘엘씨(미국 캘리포니아 ***** 샌디에이고 스위트 *** 라 졸라 빌리지 드라이브 ****)","브라네스 제이슨(미국 캘리포니아 ...)|월린 에반(미국 캘리포니아  ...)|페레이라 에데르손(미국 캘리포니아 ...)", "10-2019-0025751", "2019.03.11", "10-2166291-0000", "2020.10.08", "ui001-XXXX", 3,"H04N", "21^2662", "협의가능", "02-2000-1114");
        addList(list, "10-2022-7031881", "2011.12.01", "송신방법, 송신장치, 수신방법 및 수신장치(TRANSMISSION METHOD, TRANSMITTER, RECEPTION METHOD AND RECEIVER)", "선 페이턴트 트러스트(미국 뉴욕주 ***** 뉴욕 ** 플로어 메디슨 애비뉴 ***)","무라카미 유타카(일본국 오오사카후 가도마시...)|기무라 도모히로(일본국 오오사카후 가도마시...)|오우치 미키히로(일본국 오오사카후 가도마시...)", "10-2022-0132651", "2022.09.30", "10-2559204-0000", "2023.07.20", "ui001-XXXX", 3,"H04L", "27^34", "협의가능", "02-2000-1114");
        addList(list, "10-2017-7037509", "2011.05.06", "조직이식과 조직복제 방법 및 장치(METHOD AND APPARATUS FOR TISSUE GRAFTING AND COPYING)", "더 제너럴 하스피탈 코포레이션(미국, 메사추세츠 *****, 보스톤 프룻트 스트리트 **)","앤더슨, 리차드, 알.(미국 매사추세츠주 *...)|파리넬리, 윌리암, 에이.(미국 매사추세츠주 *...)|프란코 왈프레(미국 매사추세츠주 *...)|탐, 죠슈아(미국 매사추세츠주 *...)|사카모토, 페르난다, 에이치.(미국 매사추세츠주 *...)|도우카스, 아포스톨로스, 쥐.(미국 매사추세츠주 *...)|푸쉬케, 마틴(미국 매사추세츠주 *...)|야오, 민(미국 매사추세츠주 *...)", "10-2018-0005715", "2018.01.16", "10-1909645-0000", "2018.10.12", "ui001-XXXX", 3,"A61B", "17^322", "협의가능", "02-2000-1114");
        addList(list, "10-2017-7033107", "2011.04.28", "마루 패널 및 마루 패널 제조 방법(FLOOR PANEL AND METHODS FOR MANUFACTURING FLOOR PANELS)", "플로어링 인더스트리즈 리미티드 에스에이알엘(룩셈부르크 엘-**** 베르트랑쥬 뤼 데 메로빙지앙 (제트아이 부르미흐트) **비)","메르세망 로랑(벨기에 비-*...)|세게르뜨 마르땡(벨기에 비-...)|티에르 베르나르(벨기에 비-** 아이...)|클레망 벤자맹(벨기에 비-* ...)|메센 크리스토프(벨기에 비-* 리...)", "10-2017-0129958", "2017.11.27", "10-1910313-0000", "2018.10.15", "ui001-XXXX", 3,"B32B", "27^06", "협의가능", "02-2000-1114");
        addList(list, "10-2014-7013162", "2011.10.21", "환원 기체에 의한 흑연 열적 정화(Graphite Thermal Decontamination with Reducing Gases)", "엘렉트리씨트 드 프랑스(프랑스 파리 에프-***** **-** 아베뉴 드 베그램)","메이슨 제이 브래들리(미국 아이다호 ***** 도넬리 피너클 코트 **)|브라운 토마스(미국 조지아 ***** 애틀란타 유닛 **** *** ** 스트리트 노스이스트)|토랍자데 사하(미국 조지아 ***** 애틀란타 매디슨 드라이브 *****)|올랜더 조나단(미국 테네시 ***** 존스버러 유닛 ** *** 올드 스테이트 루트 **)", "10-2014-0101735", "2014.08.20", "10-1666138-0000", "2016.10.07", "ui001-XXXX", 3,"G21F", "9^14", "협의가능", "02-2000-1114");
        addList(list, "10-2014-7017299", "2011.11.30", "보급제, 표면처리 강판의 제조방법(Supplement and method for producing surface-treated steel sheet)", "니혼 파커라이징 가부시키가이샤(일본 도쿄도 쥬오꾸 니혼바시 *쵸메 **방 *고)","요시다 유타(일본 도쿄도 쥬오꾸 니혼바시 *쵸메 **방 *고 니혼 파커라이징 가부시키가이샤 내)|스나다 히로키(일본 도쿄도 쥬오꾸 니혼바시 *쵸메 **방 *고 니혼 파커라이징 가부시키가이샤 내)|야마모토 시게키(일본 도쿄도 쥬오꾸 니혼바시 *쵸메 **방 *고 니혼 파커라이징 가부시키가이샤 내)|야마구치 히데히로(일본 도쿄도 쥬오꾸 니혼바시 *쵸메 **방 *고 니혼 파커라이징 가부시키가이샤 내)", "10-2014-0084363", "2014.07.04", "10-1457852-0000", "2014.10.28", "ui001-XXXX", 3,"C25D", "9^10", "협의가능", "02-2000-1114");
        addList(list, "10-2014-7016109", "2011.12.20", "BAMBAM:고처리율 서열분석 데이터의 병렬 비교 분석(BAMBAM: PARALLEL COMPARATIVE ANALYSIS OF HIGH-THROUGHPUT SEQUENCING DATA)", "더 리젠츠 오브 더 유니버시티 오브 캘리포니아(미합중국, *****-**** 캘리포니아, 오클랜드, 프랭클린 스트리트 ****, *th 플로어)","샌본 존 재커리(미국 ***** 캘리포니아주 산타 크루스 유니버시티 오브 캘리포니아 산타 크루스)|하우슬러 데이비드(미국 ***** 캘리포니아주 산타 크루스 유니버시티 오브 캘리포니아 산타 크루스)", "10-2014-0089609", "2014.07.15", "10-1663951-0000", "2016.10.04", "ui001-XXXX", 3,"G16B", "20^00", "협의가능", "02-2000-1114");
        addList(list, "10-2013-7009422", "2011.09.16", "비복 신경 전도 속도 및 진폭의 자동 측정 장치 및 방법(APPARATUS AND METHOD FOR THE AUTOMATED MEASUREMENT OF SURAL NERVE CONDUCTION VELOCITY AND AMPLITUDE)", "뉴로메트릭스 인코포레이티드(미국 매사추세츠주 ***** 월섬 포스 애비뉴 **)","뵈트허 보니진(미국 매사추세츠주 ***** 메이나드 엘름 코트 *)|크라이언 마크(미국 매사추세츠주 ***** 메이나드 올드 말버러 로드 **)|고자니 샤이 엔.(미국 메릴랜드주 ***** 부르클린 요크 테라스 **)|허브 글렌(미국 매사추세츠주 ***** 웨스턴 뉴턴 스트리트 **)|콩 수안(미국 메릴랜드주 ***** 액톤 푸트남 로드 *)|윌리엄스 마이클(미국 매사추세츠주 ***** 멜로즈 헨리 애비뉴 **)|펜드록 찰스(미국 매사추세츠주 ***** 서드베리 티플린 록 로드 **)", "10-2013-0129364", "2013.11.28", "10-1906884-0000", "2018.10.04", "ui001-XXXX", 3,"A61B", "5^05", "협의가능", "02-2000-1114");
        addList(list, "10-2013-7025289", "2011.12.07", "알루미늄 규산염, 금속 이온 흡착제 및 이들의 제조 방법(ALUMINUM SILICATE, METAL ION ADSORBENT, AND METHOD FOR PRODUCING SAME)", "가부시끼가이샤 레조낙(일본국 도쿄도 미나토쿠 시바 다이몬 *초메 **반 *고)","미쿠니 히로키(일본 이바라키켄 히타치시 히가시쵸 *쵸메 **반치 *고 히타치가세이가부시끼가이샤내)|가와이 기요시(일본 이바라키켄 히타치나카시 오아자 다라자키 아자 니시하라 ****-* 히타치가세이가부시끼가이샤내)", "10-2014-0014192", "2014.02.05", "10-1907048-0000", "2018.10.04", "ui001-XXXX", 3,"C01B", "33^26", "협의가능", "02-2000-1114");
        addList(list, "10-2013-7018239", "2011.11.21", "반도체 장치(SEMICONDUCTOR DEVICE)", "가부시키가이샤 한도오따이 에네루기 켄큐쇼(일본국 가나가와켄 아쓰기시 하세 ***)","야마자키 슌페이(일본 ***-**** 가나가와켄 아쓰기시 하세 *** 가부시키가이샤 한도오따이 에네루기 켄큐쇼 내)|츠부쿠 마사시(일본 ***-**** 가나가와켄 아쓰기시 하세 *** 가부시키가이샤 한도오따이 에네루기 켄큐쇼 내)|아키모토 겐고(일본 ***-**** 가나가와켄 아쓰기시 하세 *** 가부시키가이샤 한도오따이 에네루기 켄큐쇼 내)|오하라 히로키(일본 ***-**** 가나가와켄 아쓰기시 하세 *** 가부시키가이샤 한도오따이 에네루기 켄큐쇼 내)|혼다 다츠야(일본 ***-**** 가나가와켄 아쓰기시 하세 *** 가부시키가이샤 한도오따이 에네루기 켄큐쇼 내)|오마타 다카츠구(일본 ***-**** 가나가와켄 아쓰기시 하세 *** 가부시키가이샤 한도오따이 에네루기 켄큐쇼 내)|노나카 유스케(일본 ***-**** 가나가와켄 아쓰기시 하세 *** 가부시키가이샤 한도오따이 에네루기 켄큐쇼 내)|다카하시 마사히로(일본 ***-**** 가나가와켄 아쓰기시 하세 *** 가부시키가이샤 한도오따이 에네루기 켄큐쇼 내)|미야나가 아키하루(일본 ***-**** 가나가와켄 아쓰기시 하세 *** 가부시키가이샤 한도오따이 에네루기 켄큐쇼 내)", "10-2013-0118921", "2013.10.30", "10-1457833-0000", "2014.10.28", "ui001-XXXX", 3,"H01L", "29^786", "협의가능", "02-2000-1114");
        addList(list, "10-2013-7008149", "2011.09.02", "문서 분석 시스템 및 방법(Systems and methods for document analysis)", "터니틴, 엘엘씨(미국 캘리포니아 ***** 오클랜드 스위트 **** 웹스터 스트리트 ****)","배리, 존 엠.(미국, 캘리포니아 *****, 버클리, *, **** 프린스 스트리트)|캉, 마이클(미국, 캘리포니아 *****, 샌디에이고, 에이피티. **, **** 아베니다 나비다드)|스톰, 크리스티앙(미국, 캘리포니아 *****, 리치몬드, **** 밴 플리트 에버뉴)|챔버스, 루크(미국, 캘리포니아 *****, 리버모어, **** 사파이어 드라이브)|골릭, 스티븐(미국, 캘리포니아 *****, 오클랜드, **** 사로니 드라이브)|하르트만, 존(미국, 캘리포니아 *****, 오클랜드, **** 엘레버튼 드라이브)", "10-2013-0050381", "2013.05.15", "10-1452664-0000", "2014.10.13", "ui001-XXXX", 3,"G06F", "40^10", "협의가능", "02-2000-1114");
        addList(list, "10-2013-7001179", "2011.01.25", "액정 표시 장치 및 텔레비전 수상기(LIQUID CRYSTAL DISPLAY DEVICE AND TELEVISION RECEIVER)", "파나소닉 액정 디스플레이 주식회사(일본 효고켄 히메지시 시카마쿠 메가히다초 *-*)|가부시키가이샤 재팬 디스프레이(일본국 도쿄토 미나토쿠 니시신바시 *쵸메 *반 *고)","야마자끼, 사찌꼬(일본 ***-**** 효고껭 히메지시 시까마꾸 메가히다쪼 *-* 파나소닉 액정 디스플레이 주식회사 내)|이마조, 이꾸꼬(일본 ***-**** 효고껭 히메지시 시까마꾸 메가히다쪼 *-* 파나소닉 액정 디스플레이 주식회사 내)|바바, 마사시(일본 ***-**** 효고껭 히메지시 시까마꾸 메가히다쪼 *-* 파나소닉 액정 디스플레이 주식회사 내)|오노, 기꾸오(일본 ***-**** 효고껭 히메지시 시까마꾸 메가히다쪼 *-* 파나소닉 액정 디스플레이 주식회사 내)", "10-2013-0030809", "2013.03.27", "10-1437297-0000", "2014.08.27", "ui001-XXXX", 3,"G02F", "1^13357", "협의가능", "02-2000-1114");
        addList(list, "10-2012-7032952", "2011.05.27", "전자기계 액츄에이터의 가동에 필요한 힘을 제어하기 위한 모듈(A MODULE FOR CONTROLLING A FORCE REQUIRED TO ACTUATE AN ELECTROMECHANICAL ACTUATOR)", "레이저 (아시아-퍼시픽) 피티이 엘티디(싱가포르 ****** 싱가포르 #**-** 원 노스 크레센트 * 레이저 씨 에이치큐)","탕, 저스틴(싱가포르, ****** 싱가포르 #**-**, 차이 치 래인 ***)", "10-2013-0086153", "2013.07.31", "10-1450995-0000", "2014.10.07", "ui001-XXXX", 3,"G06F", "3^033", "협의가능", "02-2000-1114");
        addList(list, "10-2012-7031042", "2011.05.18", "가변 병렬성 및 펌웨어 업그레이드 기능을 갖는 유연한 저장 인터페이스 테스터(FLEXIBLE STORAGE INTERFACE TESTER WITH VARIABLE PARALLELISM AND FIRMWARE UPGRADEABILITY)", "주식회사 아도반테스토(일본 도쿄 치요다쿠 마루노우치 *-*-*)","필러 스콧(미국 캘리포니아주 ***** 산타 클라라 데 라 크루즈 불러바드 ****)|볼커린크 헨드릭 잔 (에릭)(미국 캘리포니아주 ***** 팔로 알토 서더랜드 드라이브 ****)|탄타위 아흐메드 사미(미국 캘리포니아주 ***** 산 호세 리틀 브란햄 레인 ****)", "10-2013-0096640", "2013.08.30", "10-1789848-0000", "2017.10.18", "ui001-XXXX", 3,"G06F", "11^22", "협의가능", "02-2000-1114");
        addList(list, "10-2012-7024082", "2011.01.17", "가변 클래스 특성 증폭기(VARIABLE CLASS CHARACTERISTIC AMPLIFIER)", "엠케이에스 인스트루먼츠, 인코포레이티드(미합중국 매사추세츠주 *****, 앤도버, 스위트 ***, 테크 드라이브 *)","오웬, 크리스토퍼 마이클(미합중국, ***** 뉴욕, 피츠포드, 와일드 베리 레인 **)|챠우라, 요겐드라 케이.(미합중국, ***** 뉴욕, 페어포트, 캘러웨이 리지 *)", "10-2013-0004293", "2013.01.09", "10-1452841-0000", "2014.10.14", "ui001-XXXX", 3,"H03F", "3^217", "협의가능", "02-2000-1114");
        addList(list, "10-2012-7022022", "2011.02.17", "옥소 알콜계 회합 단량체, 이 단량체를 함유하는 아크릴 중합체, 수성 제제에서 증점제로서 상기 중합체의 용도, 및 얻어진 제제(ASSOCIATIVE MONOMER BASED ON OXO ALCOHOLS, ACRYLIC POLYMER CONTAINING THIS MONOMER, USE OF SAID POLYMER AS THICKENER IN AN AQUEOUS FORMULATION, AND FORMULATION OBTAINED)", "코아텍스(프랑스 제나이 에프-***** 뤼 앙페르 **)","수아우, 장-마르크(프랑스, 뤼스네 에프-*****, 슈민 페롤트 **)|루흘만, 데니스(프랑스, 제나이 에프-*****, 르 끌로스 데스 셰리시에르스, 임빠세 데스 그리오떼스 ***)", "10-2012-0107523", "2012.10.02", "10-1565530-0000", "2015.10.28", "ui001-XXXX", 3,"C07C", "69^54", "협의가능", "02-2000-1114");


        return ResponseEntity.ok().body(list);
    }


    public void addList(List<Map<String, Object>> list, int parent, String parentTile, int code, String title, String url){
        Map<String, Object> map = new HashMap<>();
        map.put("parent", parent);
        map.put("parentTitle", parentTile);
        map.put("code", code);
        map.put("title", title);
        map.put("url", url+code);
        list.add(map);

    }

    public void addList(List<Map<String, Object>> list, int code, String title){
        Map<String, Object> map = new HashMap<>();
        map.put("code", code);
        map.put("title", title);
        list.add(map);

    }

    public void addList(List<Map<String, Object>> list, String number, String date
            , String title, String name, String name2, String pubNum, String pubDate, String regNum
            , String regDate, String id, int compCode, String ipc, String ipc2, String price, String phone){
        Map<String, Object> map = new HashMap<>();
        map.put("number", number);
        map.put("date", date);
        map.put("title", title);
        map.put("name", name);
        map.put("name2", name2);
        map.put("pubNum", pubNum);
        map.put("pubDate", pubDate);
        map.put("regNum", regNum);
        map.put("regDate", regDate);
        map.put("id", id);
        map.put("compCode", compCode);
        map.put("ipc", ipc);
        map.put("ipc2", ipc2);
        map.put("price", price);
        map.put("phone", phone);

        list.add(map);

    }

}
