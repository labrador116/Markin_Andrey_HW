/**
 * Created by Andrey_pers on 31.10.2016.
 */
public class MainClass {

    public static void main(String[] args) {

        MyList <Integer> MyLinkList = new MyLinkList<Integer>(0,null);

        MyLinkList.add(3);
        MyLinkList.add(7);
        MyLinkList.add(2);
        MyLinkList.add(5);
        MyLinkList.show();
        MyLinkList.removeValue(5);
        System.out.println();
        MyLinkList.show();

        MyList<Integer> newList=new MyArrayList<Integer>();

        for (int i=0;i<10;i++){
            newList.add(i);
        }
        System.out.println();
        newList.show();
        newList.removeValue(5);
        System.out.println();
        newList.show();

        MyArrayList<Integer> arrayList = new MyArrayList<Integer>();
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);
        arrayList.add(6);
        System.out.println();
        arrayList.show();
        arrayList.removeIterator(1);
        System.out.println();
        arrayList.show();






    }
}
