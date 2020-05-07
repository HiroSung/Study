package kr.re.kitri.hello.controller;

import kr.re.kitri.hello.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @Autowired
    private TeamService teamService;

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

}
