package kr.re.kitri.hello.dao;

import org.springframework.stereotype.Repository;

@Repository
public class TeamDao {
    // teams 테이블에 접근해서 select
    public String selectAllTeams() {
        return "전체 팀을 조회해서 리턴합니다.";
    }
}
