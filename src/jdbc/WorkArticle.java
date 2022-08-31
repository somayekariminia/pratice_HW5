package jdbc;

import hw5.article.Article;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WorkArticle {
    private Article article;

    public void creatTableArticle() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/maktab", "postgres", "12345");
        PreparedStatement preparedStatement = connection.prepareStatement("create table article " +
                "(id int primary key," +
                "title varchar(250)," +
                "brief varchar(250)," +
                "content varchar(250)," +
                // "ispublish bit,"+
                "creatData DATE," +
                "user_id int )");
        preparedStatement.executeUpdate();
    }

    public void insertTable(Article article) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/maktab", "postgres", "12345");
        PreparedStatement preparedStatement = connection.prepareStatement("insert into public.article values(?,?,?,?,?,?)");
        preparedStatement.setInt(1, article.getId());
        preparedStatement.setString(2, article.getTitle());
        preparedStatement.setString(3, article.getBreif());
        preparedStatement.setString(4, article.getContent());
        //  preparedStatement.setBoolean(5, article.isPublished());
        preparedStatement.setDate(5, article.getCreatDate());
        preparedStatement.setInt(6, article.getUser_id());
        preparedStatement.executeUpdate();
    }

    //
    public void editeArticle(Article article) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/maktab", "postgres", "12345");
        PreparedStatement preparedStatement = connection.prepareStatement("UPDATE article " +
                " set title=?,brief=?,content=?" +
                "where user_id= ?");
        preparedStatement.setString(1, article.getTitle());
        preparedStatement.setString(2, article.getBreif());
        preparedStatement.setString(3, article.getContent());
        // preparedStatement.setBoolean(4, article.isPublished());
        preparedStatement.setInt(4, article.getUser_id());
        preparedStatement.executeUpdate();
    }

    //
    public List<Article> view() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/maktab", "postgres", "12345");

        List<Article> articleList = new ArrayList<>();
        PreparedStatement statement = connection.prepareStatement("select * from public.article");
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Article article = new Article(resultSet.getString("content"),
                    resultSet.getString("brief"));
            articleList.add(article);
        }
        return articleList;
    }

    public List<Article> completView(String content) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/maktab", "postgres", "12345");
        PreparedStatement statement = connection.prepareStatement("select * from public.article where content=?");
        statement.setString(1, content);
        ResultSet resultSet = statement.executeQuery();
        List<Article> list = new ArrayList<>();
        while (resultSet.next()) {
            Article article = new Article(
                    resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getDate(5),
                    // resultSet.getBoolean(6),
                    resultSet.getInt(6));
            list.add(article);
        }
        return list;
    }
}
