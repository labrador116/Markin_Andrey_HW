/**
 * Created by Andrey_pers on 31.10.2016.
 */
public class MyLinkList <T> implements MyList<T>{

    private T data;
    private MyLinkList next;


    public MyLinkList(T value, Object o) {
        this.data = value;
        this.next = null;
    }

    @Override
   synchronized public void add(T value)
    {
        MyLinkList<T> BUFF=this;
        MyLinkList <T> newList = new MyLinkList(value,null);

        if (BUFF.next != null) {
            while (BUFF.next!=null){
                BUFF=BUFF.next;
            }
            BUFF.next=newList;
        }else{
            BUFF.next=newList;
        }
    }
    @Override
    synchronized public void show()
    {
        MyLinkList<T> BUFF=this;

        if (BUFF.next==null){
            System.out.println("There aren't objects");
        }else {
            while(BUFF.next!=null){
                System.out.println(BUFF.next.data);
                BUFF=BUFF.next;
            }
        }

    }
    @Override
    synchronized public void removeValue(T value)
    {
        MyLinkList<T> BUFF=this;

        while (BUFF.next!=null){
                if(BUFF.next.data==value){
                    BUFF.next=BUFF.next.next;
                    return;
                }
                BUFF=BUFF.next;
            }
    }
}


