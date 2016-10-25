/**
 * Created by Andrey_pers on 19.10.2016.
 */
public class Shop {

    public static void main (String[] args)
    {
        Fridges fr1 = new Fridges("Урал", "Синий", 40, 5000);
        Fridges fr2 = new Fridges("Свияга", "зеленый", 37, 5900);
        Fridges fr3 = new Fridges("Toshiba", "Black", 25, 15000);

        Phones ph1 = new Phones ("Siemens C-65", "Blue", 0.3f, 7500);
        Phones ph2 = new Phones ("Nokia 6670", "Blue", 0.78f, 25000);
        Phones ph3 = new Phones ("IPhone 4", "Gold", 0.43f, 40000);

        Product tv1 = new TV("Зенит", "Черный", 10, 300);
        Product tv2 = new TV("LG", "White", 5.6f, 3000);
        Product tv3 = new TV("Sony", "Pink", 3.2f, 50000);

        Warehouse wh=new Warehouse();
        wh.Keep(fr1);
        wh.Keep(fr2);
        wh.Keep(fr3);


        wh.Keep(ph1);
        wh.Keep(ph2);
        wh.Keep(ph3);

        wh.Keep(tv1);
        wh.Keep(tv2);
        wh.Keep(tv3);

        wh.GetList();

        System.out.print("\n");
        System.out.println("Всего товара: " +wh.SumProducts());

        System.out.print("\n");
        System.out.println("Средний вес: " +wh.AverageWeight());

        System.out.print("\n");
        wh.ColourStat();;
    }


}
