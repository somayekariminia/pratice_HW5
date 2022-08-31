package hw5.article;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;

public class Main {
    public static void main(String[] args) throws SQLException {
        List<Article>list=new ArrayList<>();
        List<Article>list2=new ArrayList<>();
UserWork userWork=new UserWork();
WorkArticle workArticle=new WorkArticle();
workArticle.creatTableArticle();
Date date=new Date(2000,12,01);
Article article=new Article(1,"water","little water","water in iran",date,1);
Article article2=new Article(2,"water","little water","water in iran", date,1);
workArticle.insertTable(article);
workArticle.insertTable(article2);
        list=workArticle.view();
        System.out.println(list.get(0).toString());
        workArticle.completView("water in iran");
        System.out.println(list2.toString());



    }
}
