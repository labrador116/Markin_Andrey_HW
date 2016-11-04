import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;



/**
 * Created by Andrey_pers on 03.11.2016.
 */
public class delThing extends JFrame  {
    private JComboBox nameWarehouse;
    private JComboBox nameThing;
    private JButton delButton;
    private JPanel mainPanel;
    private JComboBox nameModel;
    String item;
    String selectedItem;
    List<String> models;


    public delThing() {
        setContentPane(mainPanel);
        setVisible(true);
        setSize(1000, 100);
        List<String> warehouses = ExecutableClass.getWarehouses();

        for (String wh : warehouses) {
            nameWarehouse.addItem(wh);
        }
        nameWarehouse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                item=(String) nameWarehouse.getSelectedItem();
                List<String> things=ExecutableClass.getThings(item);
                nameThing.removeAllItems();

                for (String thing : things) {
                    nameThing.addItem(thing);


                }
            }
        });

        nameThing.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedItem=(String)nameThing.getSelectedItem();

                models= ExecutableClass.getModels(item,selectedItem);
                nameModel.removeAllItems();

                for (String mod : models) {
                    nameModel.addItem(mod);
                }

            }
        });

        delButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if((item==null)||(selectedItem==null)||(models==null)){
                    JOptionPane.showMessageDialog(null, "Выберите данные для удаления.");
                }else{
                    ExecutableClass.delThing(item,selectedItem,(String)nameModel.getSelectedItem());
                }
                setVisible(false);
                dispose();
            }
        });
    }



    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
