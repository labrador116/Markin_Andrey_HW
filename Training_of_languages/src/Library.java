/**
 * Created by Andrey_pers on 21.10.2016.
 */

import java.io.*;
import java.util.*;


public class Library {

    private String language;

    public Library(String language)  {
        this.language = language;
        findLibLang(language);
    }

    private void findLibLang(String language)  {

        FileInputStream filestream=null;
        Properties property = new Properties();

        try{

            filestream=new FileInputStream("src/Lib/" + language+".properties");
            property.load(filestream);
            filestream.close();

        } catch(IOException e) {
            System.out.println("Библиотека с данным языком отсутсвует");
            return;
    }

        System.out.println("Начинаем тренировку языка: " + language);
        training(property);
    }

    private void training(Properties property)  {

        List <String> keys = new ArrayList<>();
        keys.addAll(property.stringPropertyNames());

        Statistics stat=new Statistics();

        while (!keys.isEmpty()) {

            int num = (new Random().nextInt(keys.size()));
            String word = keys.get(num);
            keys.remove(num);

            System.out.print("Слово в "+ language + " -> ");
            System.out.println(word);
            System.out.print("По русски: ");

            String s1 =property.getProperty(word);
            String s2 =new Scanner(System.in).nextLine();


            if(s2.equals("exit")) {
                stat.Check();
                return;
            } else
                if (s1.equals(s2)) {
                    System.out.println("ВЕРНО!");
                    stat.Correctly();
                } else {
                    System.out.print("ОШИБКА!!!");
                    System.out.println(" Правильное слово -> " + new String(property.getProperty(word)));
                    stat.Mistake();
                }
        }
        stat.Check();
    }
}

