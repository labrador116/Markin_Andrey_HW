package logics;

import java.sql.Connection;
import java.util.List;

/**
 * Created by Andrey_pers on 03.11.2016.
 */
public interface IRequests {
    public void addWarehouse(String warehouseName);
    public void dropWarehouse (String warehouseName);
    public void addThing(String warehouseName, String thingName, String thingModel);
    public void deleteThing (String warehouseName, String thingName, String thingModel);
    List<String> getWarehouses();
    public List<String> getThings ();
    public List<String> getThings (String nameWarehouse);
    public List<String> getModel(String nameWarehouse, String nameThing);
    public List<String> findThing(String nameThing);
}
