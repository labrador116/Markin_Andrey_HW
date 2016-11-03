import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Andrey_pers on 03.11.2016.
 */
public class delWarehouse extends JFrame {
    private JTextField delName;
    private JPanel mainPanel;
    private JButton delButton;


    public delWarehouse(){
        setContentPane(mainPanel);
        setVisible(true);
        setSize(330,100);

        delButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(delName.getText()==null){
                    JOptionPane.showMessageDialog(null, "Введи имя!");
                }else{
                    ExecutableClass.delWarehouse(delName.getText());
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
