package Script.UI;

import Script.Data.Location;
import Script.Data.Tree;
import Script.FirstScript;
import net.miginfocom.swing.MigLayout;
import org.rspeer.runetek.api.Game;
import org.rspeer.script.task.Task;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;

import static javax.swing.WindowConstants.HIDE_ON_CLOSE;

public class GUI extends Task {

    private boolean validate;

    private JCheckBox powercutCheckbox;
    private JComboBox treesComboBox;
    private JComboBox locationsComboBox;
    private JButton startBtn;

    private JFrame frame;


    public GUI(){
        frame = new JFrame("Sandbox v1.0");
        frame.setLayout(new MigLayout());
        frame.setPreferredSize(new Dimension(200, 200));

        powercutCheckbox = new JCheckBox("Powercutting?");
        treesComboBox = new JComboBox(Tree.values());
        locationsComboBox = new JComboBox(Location.values());
        startBtn = new JButton("Start");

        frame.add(powercutCheckbox, "wrap, growx");
        frame.add(treesComboBox, "wrap, growx");
        frame.add(locationsComboBox, "wrap, growx");
        frame.add(startBtn, "growx");

        locationsComboBox.addItemListener(this::locationsSelectionHandler);
        startBtn.addActionListener(x -> startBtnHandler());

        frame.setDefaultCloseOperation(HIDE_ON_CLOSE);
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

    private void locationsSelectionHandler(ItemEvent e){
        Location selection = (Location) e.getItem();
        treesComboBox.setModel(new DefaultComboBoxModel(selection.getTrees()));

    }

    private void startBtnHandler(){
        FirstScript.PowerCutting = powercutCheckbox.isSelected();
        FirstScript.tree = (Tree) treesComboBox.getSelectedItem();
        FirstScript.location = (Location) locationsComboBox.getSelectedItem();
        validate = false;
        frame.setVisible(false);
    }

}
