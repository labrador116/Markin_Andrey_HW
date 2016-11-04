import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Created by Andrey_pers on 01.11.2016.
 */
public class MyForm extends JFrame {
    private JButton addWarehouse;
    private JButton delWarehouse;
    private JButton addThing;
    private JButton delThing;
    private JButton getListThings;
    private JButton findThings;
    private JTextArea workSpace;
    private JPanel myPanel;

    public MyForm(){
        setContentPane(myPanel);
        setVisible(true);
        setSize(500,500);


        addWarehouse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddWarehouse newAdd=new AddWarehouse();
            }
        });

        delWarehouse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                delWarehouse newDel = new delWarehouse();
            }
        });

        addThing.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addThing newAdd=new addThing();
            }
        });

        delThing.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                delThing newDel = new delThing();
            }
        });

        getListThings.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               List<String> things= ExecutableClass.getThings();
                workSpace.setText(null);

                for (String thing : things) {
                    workSpace.append(thing +"\n");
                }
            }
        });

        findThings.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                findThing findtForm = new findThing();
            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
