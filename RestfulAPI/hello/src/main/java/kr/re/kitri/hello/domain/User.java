package kr.re.kitri.hello.domain;

public class User {
    private Integer userId;
    private String userName;
    private String telNo;

    public User(Integer id, String name, String telNo) {
        this.userId = id;
        this.userName = name;
        this.telNo = telNo;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setTelNo(String telNo) {
        this.telNo = telNo;
    }

    public String getTelNo() {
        return this.telNo;
    }

    @Override
    public String toString() {
        return "User{" +
                "Id='" + this.userId + '\'' +
                ", Name='" + this.userName + '\'' +
                ", telNo='" + this.telNo + '\'' +
                '}';
    }
}
