package co.com.automation.screenplay.web.utils.constants;

import java.io.File;
import java.util.Scanner;

import static co.com.automation.screenplay.web.exceptions.ExceptionsAutomation.ASSERT_READ_FILE;


public class ReadFile {


    public ReadFile() {
        throw new IllegalStateException("Utility class");
    }

    public static String returnFile(String route){
        String line = "";
        try{
            Scanner input = new Scanner(new File(route));
            while (input.hasNextLine()){
                line = line + input.nextLine();
            }
        }catch (Exception e){
            System.out.println(ASSERT_READ_FILE +  e);
        }
        return line;
    }
}
