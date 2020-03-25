import org.example.menu.LoginMenu;
import org.example.model.user.SqlConnector;

public class Main {

    public static void main(String[] args) throws Exception {

        SqlConnector sqlConnector = new SqlConnector();
        sqlConnector.connectToDatabase();

        LoginMenu loginMenu = new LoginMenu();
        loginMenu.loginMenu();




    }
}