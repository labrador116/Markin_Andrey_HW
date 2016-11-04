import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Created by Andrey_pers on 04.11.2016.
 */
public class findThing extends JFrame {
    private JTextField nameThing;
    private JButton findButton;
    private JPanel mainPanel;
    private JTextArea workSpace;
    List<String>foundThinks;

    public findThing() {
        setContentPane(mainPanel);
        setVisible(true);
        setSize(400, 100);
        workSpace.setVisible(false);
        findButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(nameThing.getText()==null){
                    JOptionPane.showMessageDialog(null, "Введите имя товара");
                }else {
                    foundThinks= ExecutableClass.findThings(nameThing.getText());
                    workSpace.setText(null);

                    for (String foundThink : foundThinks) {
                        workSpace.append(foundThink +"\n");
                    }
                    setSize(500,100);
                    workSpace.setSize(100,50);
                   workSpace.setVisible(true);
                }
            }
        });
    }

    public List<String> returnFound(){
        return foundThinks;
    }
}