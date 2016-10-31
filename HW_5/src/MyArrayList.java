/**
 * Created by Andrey_pers on 31.10.2016.
 */
public class MyArrayList<T> implements MyList<T> {
    private T[] array;
    private int iterator=0;

    public MyArrayList()
    {
        array =  (T[])(new Object[1]);
    }

    @Override
   synchronized public void add(T value) {

      /*
      Буффер +1

      if (array[iterator] == null) {
            array[iterator] = value;
            iterator++;
            T[] newArray = (T[]) (new Object[iterator+1]);
            for(int i=0;i< array.length;i++)
            {
                newArray[i]=array[i];
            }
            array=newArray;
        } */

      if(array[0]==null){
          array[0]=value;
          iterator++;
      }else {
          T[] newArray = (T[]) (new Object[iterator+1]);

          for(int i=0;i<array.length;i++){
              newArray[i]=array[i];
          }
          newArray[iterator]=value;
          array=newArray;
          iterator++;
      }

    }

    @Override
    synchronized public void show() {
        for (T t : array) {
            System.out.println(t);
        }
    }

    @Override
    synchronized public void removeValue(T value) {

        for (int i =0; i<array.length-1;i++)
        {
            if (array[i].equals(value))
            {
                T[] newArray = (T[]) (new Object[iterator-1]);
                for(int k=0;k<i;k++){
                    newArray[k]=array[k];
                }

                for(int j=i;j<newArray.length;j++){
                       newArray[j] = array[j+1];
                }
                array=newArray;
                iterator--;
            }
        }

    }
    synchronized public void removeIterator(int iter) {

        T[] newArray = (T[]) (new Object[iterator-1]);

        for (int i=0;i<iter;i++){
            newArray[i]=array[i];
        }

        for(int j=iter;j<newArray.length;j++){
            newArray[j]=array[j+1];
        }
        array=newArray;
        iterator--;

    }
}

