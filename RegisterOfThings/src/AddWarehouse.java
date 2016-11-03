import logics.IRequests;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Created by Andrey_pers on 03.11.2016.
 */
public class AddWarehouse extends JFrame  {
    private JTextField nameNew;
    private JPanel mainPanel;
    private JButton addButton;
    private boolean result;

    public boolean isResult() {
        return result;
    }

    public AddWarehouse(){
        setContentPane(mainPanel);
        setVisible(true);
        setSize(280,100);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(nameNew.getText()==null){
                    JOptionPane.showMessageDialog(null, "Введи имя!");
                }else{
                     ExecutableClass.addWarehouse(nameNew.getText());
                }
                setVisible(false);
                dispose();
            }
        });
    }


}
