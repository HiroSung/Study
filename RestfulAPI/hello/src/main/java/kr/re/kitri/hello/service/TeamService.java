package kr.re.kitri.hello.service;

import kr.re.kitri.hello.dao.TeamDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class TeamService {

    @Autowired
    private TeamDao teamDao;

    // 팀 전체 조회
    public String viewAllTeams() {
        // DB에 접속해서 데이터를 조회함
        return teamDao.selectAllTeams();
    }

}
