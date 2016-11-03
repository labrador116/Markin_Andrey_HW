import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Created by Andrey_pers on 03.11.2016.
 */
public class addThing extends JFrame {
    private JPanel mainPanel;
    private JTextField nameThing;
    private JButton addButton;
    private JTextField model;
    private JComboBox nameWarehouse;
    String item;


    public addThing() {
        setContentPane(mainPanel);
        setVisible(true);
        setSize(1000, 100);
        List<String> warehouses=ExecutableClass.getWarehouses();

        for (String wh : warehouses) {
            nameWarehouse.addItem(wh);
        }

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if ((item == null) || (nameThing.getText() == null) || (model.getText() == null)) {
                    JOptionPane.showMessageDialog(null, "Заполните все поля!!");
                } else {
                    ExecutableClass.addThing(item, nameThing.getText(), model.getText());
                }
                setVisible(false);
                dispose();
            }
        });
        nameWarehouse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                item = (String)nameWarehouse.getSelectedItem();
            }
        });
    }
}