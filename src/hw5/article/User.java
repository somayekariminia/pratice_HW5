package hw5.article;

import java.util.Date;

public class User {
    private int id;
    private String user_name;
    private int nationalCode;
    private String password;
    private java.sql.Date birthday;
    private  boolean ispublish;

    public boolean isIspublish() {
        return ispublish;
    }

    public int getId() {
        return id;
    }
    public String getUser_name() {
        return user_name;
    }
    public User(int id, String user_name, int nationalCode, String password, java.sql.Date birthday) {
        this.id = id;
        this.user_name = user_name;
        this.nationalCode = nationalCode;
        this.password = password;
        this.birthday = birthday;
    }

    public User() {
    }

    public int getNationalCode() {
        return nationalCode;
    }

    public String getPassword() {
        return password;
    }

    public Date getBirthday() {
        return birthday;
    }

}
