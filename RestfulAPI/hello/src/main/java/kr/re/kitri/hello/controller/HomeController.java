package kr.re.kitri.hello.controller;

import kr.re.kitri.hello.domain.Stock;
import kr.re.kitri.hello.service.SecurityService;
import kr.re.kitri.hello.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HomeController {

    @Autowired
    private TeamService teamService;

    @Autowired
    private SecurityService securityService;

    @PostMapping("/stocks")
    public Stock registStock(@RequestBody Stock stock) {
        System.out.print(stock);
        return stock;
    }

    @GetMapping("/hello")
    public String Hello() {
        return "Hello World";
    }

    @GetMapping("/h2")
    public String Hello2() {
        return "안녕. Marvel";
    }

//    @GetMapping("/teams")
//    public String getAllTeams() {
//        // 프리젠테이션 영역 - 파라미터. 인증 정보 처리.
//        // 비지니스 영역 (service) - 기능 수행
//        // 데이터 영역 - 데이터 조회
//        return teamService.viewAllTeams();
//    }

    // URI Template
    @GetMapping("/investors/{investorId}/stocks/{stockId}")
    public String investorDetail(@PathVariable String investorId,
                                 @PathVariable String stockId) {
    // public String investorDetail(@PathVariable("investorId") String id) {
        return investorId + "번 고객의 " +  stockId + " 정보입니다.";
    }

    // Pagination
    @GetMapping(value="/teams",
            produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public String getAllTeams(
            @RequestParam(name="page", defaultValue = "1") int page,
            @RequestParam(name="limit", defaultValue = "5") int limit) {
        System.out.println("page : " + page + " / limit : " + limit);
        return teamService.viewAllTeams();
    }


    @GetMapping("/security/generate/token")
    public Map<String, Object> generateToken(@RequestParam String subject) {
        String token = securityService.createToken(subject, 1000 * 60 * 60 * 24L); // 1일
        Map<String, Object> map = new HashMap<>();
        map.put("userid", subject);
        map.put("token", token);
        System.out.println("TOKEN : " + map.toString());
        return map;
    }


}
