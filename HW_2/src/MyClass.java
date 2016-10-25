import java.util.Scanner;
import java.util.Random;

/**
 * Created by Andrey_pers on 18.10.2016.
 */
public class MyClass {

    public static void InitializeMatrix(int [][]array)
    {

        Random rand=new Random();
        Scanner scan = new Scanner(System.in);


        for (int i=0;i< array.length;i++) {
            for (int j = 0; j < array[0].length; j++) {
                array[i][j] =scan.nextInt();

            }
            System.out.print("\n");
        }

            MatrixShow(array);
    }
    public static void MatrixShow(int [][]array)
    {
        for (int i=0;i< array.length;i++)
        {
            for(int j=0;j< array[0].length;j++)
            {
                System.out.print(array[i][j]+ " ");
            }
            System.out.print("\n");
        }

    }

    public static  void MultMatrix(int [][]array1,int[][]array2)
    {

        if(array1[0].length==array2.length) {

            int [][]sum_array=new int[array1.length][array2[0].length];

            for (int i=0;i< array1.length;i++)
            {
                for (int j=0;j<array2[0].length;j++)
                {
                    for (int k=0;k<array2.length;k++)
                    {
                        sum_array[i][j]+=array1[i][k]*array2[k][j];
                    }
                }
            }
            MatrixShow(sum_array);
        }
    }


public static void main (String [] args) {

    int[][] matrix_1=new int[2][2];
    int [][]matrix_2=new int[2][2];

    InitializeMatrix(matrix_1);
    InitializeMatrix(matrix_2);
    System.out.print("\n");
    MultMatrix(matrix_1,matrix_2);


}
}
