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
