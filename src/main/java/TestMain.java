import org.example.Services.DataHandler;
import org.example.controller.LoggingController;

import java.io.FileNotFoundException;

public class TestMain {

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println(DataHandler.stringFromFile("src/main/resources/menuLogo.txt"));

        String stringToPrint = DataHandler.stringFromFile("src/main/resources/menuLogo.txt");

        //        LoggingController logging = new LoggingController();
//        logging.init();
    }
}
