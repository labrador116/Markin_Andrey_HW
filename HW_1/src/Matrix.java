import java.util.Random;

/**
 * Created by Andrey_pers on 18.10.2016.
 */
public class Matrix {


    public static int[][] Transp(int[][]array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length; j++) {
                int buf = array[i][j];
                array[i][j] = array[j][i];
                array[j][i] = buf;
            }
        }

        for (int i = 0; i < array.length; i++)
        {
            for (int j = 0; j < array.length; j++)
            {
                System.out.print(array[i][j] + " ");
            }
            System.out.print("\n");
        }
        return array;
    }

    public static void InitializeArray(int[][] array)
    {
        Random rand = new Random();

        for (int i=0;i<array.length;i++)
        {
            for (int j=0;j<array.length;j++)
            {
                array[i][j]= rand.nextInt(100);
                System.out.print(array[i][j]+" ");
            }
            System.out.print("\n");
        }
    }


    public static void main(String[] args)
    {
        int [][]MyArray=new int[10][10];
        InitializeArray(MyArray);
        System.out.print("\n");
        Transp(MyArray);

    }

}
