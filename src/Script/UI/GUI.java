package Script.UI;

import Script.Data.Location;
import Script.Data.Tree;
import net.miginfocom.swing.MigLayout;
import org.rspeer.runetek.api.Game;
import org.rspeer.script.task.Task;

import javax.swing.*;
import java.awt.*;

public class GUI extends Task {

    private boolean validate;

    private JComboBox treesComboBox;
    private JComboBox locationsComboBox;
    private JButton startBtn;

    private JFrame frame;


    public GUI(){
        frame = new JFrame("Sandbox v1.0");
        frame.setLayout(new MigLayout());
        frame.setPreferredSize(new Dimension(200, 200));

        treesComboBox = new JComboBox(Tree.values());
        locationsComboBox = new JComboBox(Location.values());
        startBtn = new JButton("Start");

        frame.add(treesComboBox, "wrap, growx");
        frame.add(locationsComboBox, "wrap, growx");
        frame.add(startBtn, "growx");

        startBtn.addActionListener(x -> startBtnHandler());

        frame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        frame.setLocationRelativeTo(Game.getCanvas());
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
