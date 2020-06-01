package Script.UI;

import Script.Data.Location;
import Script.Data.Tree;
import org.rspeer.script.task.Task;

import javax.swing.*;

public class GUI extends Task {

    private boolean validate;

    private JComboBox treesComboBox;
    private JComboBox locationsComboBox;
    private JButton startBtn;

    private JFrame frame;


    public GUI(){
        frame = new JFrame("Sandbox v1.0");

        treesComboBox = new JComboBox(Tree.values());
        locationsComboBox = new JComboBox(Location.values());
        startBtn = new JButton("Start");

        frame.add(treesComboBox);
        frame.add(locationsComboBox);
        frame.add(startBtn);

        startBtn.addActionListener(x -> startBtnHandler());

        frame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        frame.pack();

        frame.setVisible(true);
    }


    @Override
    public boolean validate() {
        return validate;
    }

    @Override
    public int execute() {
        return 1000;
    }

    private void startBtnHandler(){
        validate = false;
    }

}
