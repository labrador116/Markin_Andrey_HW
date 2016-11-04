package logics;

import org.postgresql.util.PSQLException;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andrey_pers on 01.11.2016.
 */
public class Requests implements IRequests{

    private Connection connection = null;

    public Requests(Connection connection) {
        this.connection = connection;
    }

    public void addWarehouse(String warehouseName) {
        try {
            Statement statement = connection.createStatement();
            statement.execute("CREATE TABLE " + warehouseName + " (id SERIAL PRIMARY KEY NOT NULL, thing_name VARCHAR(30) NOT NULL, model VARCHAR(30) NOT NULL)");

        }
        catch (PSQLException e){
            JOptionPane.showMessageDialog(null, "Некорректное имя!");
        }

        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void dropWarehouse (String warehouseName){
        try {
            Statement statement = connection.createStatement();
            statement.execute( "DROP TABLE " + warehouseName+";");

        }
        catch (PSQLException e){
            JOptionPane.showMessageDialog(null, "Некорректное имя!");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addThing(String warehouseName, String thingName, String thingModel)
    {
        try {
            Statement statement = connection.createStatement();
            statement.execute( "INSERT INTO " +warehouseName+" (thing_name, model) VALUES (" +"'"+thingName+"'"+"," + "'"+thingModel+"'"+") ");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteThing (String warehouseName, String thingName, String thingModel){
        try {
            Statement statement = connection.createStatement();
            statement.execute( "DELETE FROM " +warehouseName+" WHERE (thing_name= " +"'"+thingName+"'"+"AND " + "model= '"+thingModel+"'"+") ");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public List<String> getWarehouses(){
        try {
            Statement statement = connection.createStatement();
            DatabaseMetaData meta= connection.getMetaData();
            ResultSet resultSet = meta.getTables(null, "public", null, null);
            resultSet.last();
            String[] tablesName= new String[resultSet.getRow()];

            resultSet.beforeFirst();

            int counter = 0;
            while (resultSet.next()) {
                tablesName[counter]=resultSet.getString("TABLE_NAME");
                counter++;
            }

            List<String> checkedNames = checkTable(tablesName);

            return checkedNames;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<String> getThings (){

        List<String> finalResult = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();

            DatabaseMetaData meta= connection.getMetaData();
            ResultSet resultSet = meta.getTables(null, "public", null, null);
            resultSet.last();
            String[] tablesName= new String[resultSet.getRow()];
            resultSet.beforeFirst();

            int counter = 0;
            while (resultSet.next()) {
                tablesName[counter]=resultSet.getString("TABLE_NAME");
                counter++;
            }

            List<String> checkedNames = checkTable(tablesName);

            for(int i=0;i<checkedNames.size();i++){
                ResultSet result = statement.executeQuery("SELECT * FROM "+checkedNames.get(i));


                while (result.next()){
                    finalResult.add("Номер: " +result.getRow() +"\t"
                            +"Товар: "+result.getString("thing_name") +"\t"
                            +"Модель: "+result.getString("model")
                    );
                }
            }
            return finalResult;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<String> getThings (String nameWarehouse){
        try {
            List<String> finalResult = new ArrayList<>();
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM "+nameWarehouse);

            while (result.next()){
                finalResult.add(result.getString("thing_name"));
            }

            return finalResult;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<String> getModel(String nameWarehouse, String nameThing){
        List<String> finalResult = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT model FROM "+nameWarehouse +" WHERE ("+"thing_name"+" ='"+nameThing+"' )");

            while (result.next()){
                finalResult.add(result.getString("model"));
            }

            return finalResult;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    public List<String> findThing(String nameThing){
        List<String> finalResult = new ArrayList<String>();
        try {
            Statement statement = connection.createStatement();

            DatabaseMetaData meta= connection.getMetaData();
            ResultSet resultSet = meta.getTables(null, "public", null, null);
            resultSet.last();
            String[] tablesName= new String[resultSet.getRow()];
            resultSet.beforeFirst();

            int counter = 0;
            while (resultSet.next()) {
                tablesName[counter]=resultSet.getString("TABLE_NAME");
                counter++;
            }




            List<String> checkedNames = checkTable(tablesName);

            for(int i=0;i<checkedNames.size();i++) {
                resultSet = statement.executeQuery("SELECT * FROM " + checkedNames.get(i) + " WHERE ( thing_name = '" + nameThing + "' )");

                while (resultSet.next()) {
                    finalResult.add("Товар: " + resultSet.getString("thing_name") + "\t"
                            + "Модель " + resultSet.getString("model")
                    );
                }
            }
            return finalResult;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    private List<String> checkTable(String[] tablesNames){
        List<String> checked = new ArrayList<String>();
        for(int i=0;i<tablesNames.length;i++) {
            try {
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM " + tablesNames[i] + " WHERE id>0");
                if (resultSet != null) {
                    checked.add(tablesNames[i]);
                }

            } catch (SQLException e) {
            }
        }
        return checked;
    }
}
