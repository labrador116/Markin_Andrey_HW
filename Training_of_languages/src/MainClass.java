import java.io.UnsupportedEncodingException;
import java.util.Scanner;

/**
 * Created by Andrey_pers on 21.10.2016.
 */
public class MainClass {

    public static void main(String[] args) {
        System.out.print("Enter the name of language: ");
        Scanner scan = new Scanner (System.in);
        Library lib = new Library(new String(scan.nextLine()));
    }
}
