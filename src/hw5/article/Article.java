package hw5.article;

import java.sql.Date;

public class Article {
    private int id;
    private String title;
    private String breif;
    private String content;
    private java.sql.Date creatDate;
    private int use_id;

    public Article(int id, String title, String breif, String content, Date creatDate, int use_id) {
        this.id = id;
        this.title = title;
        this.breif = breif;
        this.content = content;
        this.creatDate = creatDate;
        this.use_id = use_id;
     //   this.isPublished = isPublishe;
    }

    public Article() {
    }
//    public boolean isPublished() {
//        return isPublished;
//    }

    public int getUse_id() {
        return use_id;
    }

    private boolean isPublished;
    private int user_id;
    public int getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getBreif() {
        return breif;
    }
    public String getContent() {
        return content;
    }
    public java.sql.Date getCreatDate() {
        return creatDate;
    }
    public int getUser_id() {
        return user_id;
    }
    public Article(String breif, String content) {
        this.breif = breif;
        this.content = content;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", breif='" + breif + '\'' +
                ", content='" + content + '\'' +
                ", creatDate=" + creatDate +
                ", isPublished=" + isPublished +
                ", user_id=" + user_id +
                '}';
    }
}
