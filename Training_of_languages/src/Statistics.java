import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Andrey_pers on 22.10.2016.
 */
public class Statistics {

    private int correctly;
    private int mistake;


    public void Correctly() {
        correctly++;
    }

    public void Mistake() {
        mistake++;
    }

    public void Check()
    {
        System.out.println("Верных ответов: "+correctly);
        System.out.println("Допущено ошибок: "+mistake);


        System.out.print("Введите путь для сохранения статистики -> ");
        try {

            FileOutputStream fout = new FileOutputStream(new Scanner(System.in).nextLine()+"/Statistics.txt");
            String str = "Верных ответов: "+correctly+"\t"+"Допущено ошибок: "+mistake;

            byte[] bytes = str.getBytes();
            fout.write(bytes,0,bytes.length);
            fout.close();

        } catch(IOException e) {
            System.out.println("Ошибка сохранения, проерьте путь");
    }

    }
    }
