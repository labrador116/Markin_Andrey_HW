/**
 * Created by Andrey_pers on 19.10.2016.
 */
public class Warehouse {

    private Product[] products;

   private int counter =0;

    public void Keep(Product prod)
    {
        counter++;
        Product[] buffer = new Product[counter];

        if (products!=null)
        for (int i=0;i<products.length;i++)
            buffer[i]=products[i];
        else
        buffer[0]=prod;
        buffer[counter-1]=prod;
        products=buffer;
    }

    public void GetList()
    {
        for(int i=0; i<products.length; i++)
        {
            System.out.print(products[i].GetName()+" "+products[i].GetColour()+" "+products[i].GetWeight()+" "+products[i].GetPrice());
            System.out.print("\n");
        }
    }

    public int SumProducts()
    {
        return products.length;
    }

    public float AverageWeight()
    {
        int sum_weight=0;

        for(int i=0;i<products.length;i++)
        {
            sum_weight+=products[i].GetWeight();
        }

        sum_weight/= products.length;
        return sum_weight;
    }

    public void ColourStat()
    {
        int counter=0;
        String array[][]=new String[1][2];

        for(int i=0;i<products.length;i++)
        {
            if (i>=products.length)
            break;

            if (i==0)
            {
                array[0][0]=products[i].GetColour();
                array[0][1]= Integer.toString(counter+1);
            }
            else
            {
                for(int j=0;j<array.length;j++)
                {
                    if(products[i].GetColour()==array[j][0]  & i!=j)
                    {
                        Integer intg=new Integer(array[j][1]);
                        intg++;
                        array[j][1]=Integer.toString(intg);

                    }
                    else
                        if (j== array.length-1)
                        {
                            String[][]buffer=new String[array.length+1][2];

                            for(int k=0;k<array.length;k++)
                            {
                                buffer[k][0]=array[k][0];
                                buffer[k][1]=array[k][1];
                            }

                            buffer[array.length][0]=products[i].GetColour();
                            buffer[array.length][1]=Integer.toString(1);

                            array=buffer;

                            if (i< products.length)
                            i++;

                            if (i>=products.length)
                                break;
                        }
                }
            }
        }


        for(int i=0;i<array.length;i++)
        {
            System.out.print(array[i][0]+ " кол-во " + array[i][1]);
            System.out.print("\n");
        }
    }
}
