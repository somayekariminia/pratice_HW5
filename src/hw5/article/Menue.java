package hw5.article;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Menue {
    private String exite;
    private UserWork userWork = new UserWork();
    User user = new User();
    private Scanner scanner = new Scanner(System.in);
    private List<Article> articleList, articleList1;
    private WorkArticle workArticle = new WorkArticle();
    private Article article = new Article();
    void runMenue() throws SQLException {
        exite = "yes";
        printHeader();
        while (exite.equals("yes")) {
            printMenue();
            System.out.println("please enter your choise: ");
            int choise = scanner.nextInt();
            performACtion(choise);
            System.out.println(" if are you continue enter yes else  enter no ");
            exite = "yes";

        }
    }
    private void performACtion(int choise) throws SQLException {
        switch (choise) {
            case 1: {
                System.out.println(" 1--- enter ");
                System.out.println("please enter your id: ");
                int id = scanner.nextInt();
                if (userWork.isRegister(id))
                    userRigester();
                else
                    System.out.println(" you can  registre");
                break;
            }
            case 2:
                newUser();
                break;
            case 3: {
                System.out.println("view all article");
                vierwallArticle();
                break;
            }
            default:
                break;
        }
    }
    private void vierwallArticle() throws SQLException {
        articleList = workArticle.view();
        int i = 0;
        for (Article article : articleList) {
            System.out.println(articleList.get(i).toString());
        }
    }
    private void userRigester() throws SQLException {
        System.out.println("you are entering ");
        System.out.println(" if are you change password please yes ");
        String answer = scanner.next();
        if (answer.equals("yes")) {
            System.out.println("enter  new password");
            String newpassword = scanner.next();
            userWork.change_password(user.getId(), newpassword);
        } else {
            System.out.println(" view article");
            menueArticle();
        }
        menueArticle();
    }
    private void newUser() throws SQLException {
        System.out.println("register");
        System.out.println("please enter your  information ");
        System.out.println("enter id:");
        int id = scanner.nextInt();
        System.out.println("enter user_name");
        String user_name = scanner.next();
        System.out.println(" enter nationalCode");
        int nationalCode = scanner.nextInt();
        System.out.println("enter natinalCode as password ");
        String password1 = scanner.next();
        Date date = new java.sql.Date(2000, 12, 01);
        User user = new User(id, user_name, nationalCode, password1, date);
        userWork.register_user(user);
    }

    void printHeader() {
        System.out.println(" ------------------------------------");
        System.out.println("|            welcome to out         |");
        System.out.println("|            menue Application      |");
        System.out.println(" -------------------------------------");
    }
    void printMenue() {
        System.out.println(" please  make a select");
        System.out.println("1 -> enter  ");
        System.out.println("2 -> registri ");
        System.out.println("3 ->  view article ");
    }
    public void printMenueArticle() {
        System.out.println("-----------------------------------");
        System.out.println("|        1- View articles          |");
        System.out.println("|        2- Edite article          |");
        System.out.println("|        3- Enter new article      |");
        System.out.println("------------------------------------");
    }
    public void menueArticle() throws SQLException {
        int choise;
        exite = "yes";
        while (exite.equals("yes")) {
            printMenueArticle();
            System.out.println(" enter your choise:");
            choise = scanner.nextInt();
            performArticle(choise);
            System.out.println(" if are you continue please enter yes else no");
            exite = scanner.next();
        }
    }
    public void performArticle(int choise) throws SQLException {
        switch (choise) {
            case 1: {
                System.out.println("you are View your articles");
                viewArticle();
            }
            //this.articleList = workArticle.view();
            break;
            case 2:
                System.out.println("Edite your Article by new information");
                Article article2 = newArticle();
                workArticle.editeArticle(article2);
                break;
            case 3:
                System.out.println(" Insert new your Article");
                Article newArticle = newArticle();
                workArticle.insertTable(newArticle);
                break;
            default:
                break;

        }
    }
    private void viewArticle() throws SQLException {
        System.out.println("please enter content article");
        String content = scanner.next();
        articleList1 = workArticle.completView(content);
        int i = 0;
        for (int j = 0; j < articleList1.size() - 1; j++) {
            System.out.println(articleList1.get(j).toString());

        }
    }
    private Article newArticle() {
        System.out.println("please enter title your article:");
        String title = scanner.nextLine();
        System.out.println("please rnter content your article:");
        String content = scanner.nextLine();
        System.out.println(" enter user_id article");
        int user_id = scanner.nextInt();
        System.out.println(" enter brief article");
        String brief = scanner.nextLine();
        System.out.println("enter id your article");
        int id = scanner.nextInt();
        Date date = new Date(2000, 11, 01);
        Article article1 = new Article(id, title, brief, content, date, user_id);
        return article1;
    }
    public static void main(String[] args) throws SQLException {
        Menue menue = new Menue();
        menue.runMenue();

    }
}
