package kr.re.kitri.hello.dao;

import kr.re.kitri.hello.domain.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserDao {

    public static List<User> users;

    static {
        users = new ArrayList<>();
        users.add(new User(100, "kim", "010-1234-5788"));
        users.add(new User(200, "lee", "012-3333-4444"));
        users.add(new User(300, "choi", "013-3222-3333"));
        users.add(new User(400, "park", "014-5555-6666"));
        users.add(new User(500, "kwon", "015-0000-2222"));
        users.add(new User(600, "hwang", "017-3333-3333"));

        System.out.println(users);
    }

    public Map<String, String> getMessage() {
        Map<String, String> res = new HashMap<>();
        res.put("greet", "Hello world");

        return res;
    }

    // 사용자 전체보기
    public List<User> getAllUsers() {
        System.out.println("사용자 전체보기::repository..");
        //return new ArrayList<>();
        return users;
    }

    // 사용자 상세보기
    public User getUserById(Integer userid) {
        System.out.println("사용자 상세보기::repository.." + userid);

        return users.stream()
                .filter(user -> user.getUserId().equals(userid))
                .findFirst()
                .orElse(new User(0, "no user", "no telNo"));
    }

    // 사용자 등록
    public User insertUser(User user) {
        System.out.println("사용자 등록::repository..");
        users.add(user);
        return user;
    }

    // 사용자 수정
    public boolean updateUser(User user) {

        System.out.println("사용자 수정::repository..");
        System.out.println(user);

        users.stream()
                .filter(item -> item.getUserId().equals(user.getUserId()))
                .findAny()
                .orElse(new User(0, "no user", "no telno"))
                .setUserName(user.getUserName());

        System.out.println("\t# " + getUserById(user.getUserId()));

        return true;
    }

    // 사용자 삭제
    public boolean deleteUser(Integer userid) {
        System.out.println("사용자 삭제::repository.. [" + userid + "]");

        users.removeIf(user -> user.getUserId().equals(userid));
        System.out.println(users);

        return true;
    }


}
