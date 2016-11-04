/**
 * Created by Andrey_pers on 01.11.2016.
 */
import logics.*;
import java.util.List;

public class ExecutableClass {


    public static void addWarehouse(String nameWarehouse){
        IConnect connect=new Connect();
        IRequests requests = new Requests(connect.ConnectBD());
        requests.addWarehouse(nameWarehouse);
    }

    public static void delWarehouse(String nameWarehouse){
        IConnect connect=new Connect();
        IRequests requests = new Requests(connect.ConnectBD());
        requests.dropWarehouse(nameWarehouse);
    }

    public static void addThing(String warehouseName, String thingName, String thingModel){
        IConnect connect=new Connect();
        IRequests requests = new Requests(connect.ConnectBD());
        requests.addThing(warehouseName, thingName, thingModel);
    }

    public static List<String> getWarehouses(){
        IConnect connect=new Connect();
        IRequests requests = new Requests(connect.ConnectBD());
        return requests.getWarehouses();
    }

    public static List<String> getThings(String nameWarehouse){
        IConnect connect=new Connect();
        IRequests requests = new Requests(connect.ConnectBD());
        return requests.getThings(nameWarehouse);
    }

    public static List<String> getModels(String nameWarehouse, String nameThing){
        IConnect connect=new Connect();
        IRequests requests = new Requests(connect.ConnectBD());
        return requests.getModel(nameWarehouse,nameThing);
    }

    public static void delThing(String nameWarehouse, String nameThing, String nameModel){
        IConnect connect=new Connect();
        IRequests requests = new Requests(connect.ConnectBD());
        requests.deleteThing(nameWarehouse, nameThing, nameModel);
    }

    public static List<String> getThings()
    {
        IConnect connect=new Connect();
        IRequests requests = new Requests(connect.ConnectBD());
        return requests.getThings();
    }

    public static List<String> findThings(String nameThing)
    {
        IConnect connect=new Connect();
        IRequests requests = new Requests(connect.ConnectBD());
        return requests.findThing(nameThing);
    }


    public static void main(String[] args) {
        MyForm form =new MyForm();

       // Requests requests = new Requests(connect.ConnectBD());
        //requests.addWarehouse("testWr");
        //requests.dropWarehouse("testWr");
        //requests.addThing("first_warehouse","fridge","red");
        //requests.deleteThing("first_warehouse","fridge","red");
        //requests.getThings();
        //requests.findThing("fridge","first_warehouse");
    }
}
