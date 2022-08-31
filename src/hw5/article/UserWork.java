package hw5.article;

import java.sql.*;

public class UserWork {
    void creatTableUser() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/maktab", "postgres", "12345");
        PreparedStatement preparedStatement = connection.prepareStatement("create table user_table" +
                "(id int primary key," +
                "user_name varchar(250)," +
                "natinalcod int ," +
                "password varchar(50)," +
                "birthday  DATE )");

        preparedStatement.executeUpdate();
    }

    void register_user(User user) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/maktab", "postgres", "12345");
        PreparedStatement preparedStatement = connection.prepareStatement(" INSERT INTO user_table VALUES (?,?,?,?,?) ");

        preparedStatement.setInt(1, user.getId());
        preparedStatement.setString(2, user.getUser_name());
        preparedStatement.setInt(3, user.getNationalCode());
        preparedStatement.setString(4, user.getPassword());
        preparedStatement.setDate(5, (Date) user.getBirthday());
        preparedStatement.executeUpdate();
    }

    void change_password(int id, String password) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/maktab", "postgres", "12345");
        PreparedStatement preparedStatement = connection.prepareStatement("update user_table" + " set password=?" + " where id = ?");
        preparedStatement.setString(1, password);
        preparedStatement.setInt(2, id);
        preparedStatement.executeUpdate();
    }

    public boolean isRegister(int id) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/maktab", "postgres", "12345");
        PreparedStatement preparedStatement = connection.prepareStatement("select * from user_table where id= ?");
        preparedStatement.setInt(1,id);
        ResultSet resultSet = preparedStatement.executeQuery();
        boolean flage=false;
        while(resultSet.next()){
        if (!resultSet.getString("password").equals(null)) {
            flage=true;
        }
        }
        return flage;
    }
}
