package org.empty;

import org.rspeer.runetek.adapter.component.Item;
import org.rspeer.runetek.adapter.scene.Player;
import org.rspeer.runetek.adapter.scene.SceneObject;

import org.rspeer.runetek.api.commons.Time;
import org.rspeer.runetek.api.component.Bank;
import org.rspeer.runetek.api.component.tab.Inventory;
import org.rspeer.runetek.api.movement.Movement;
import org.rspeer.runetek.api.movement.position.Area;
import org.rspeer.runetek.api.scene.Players;
import org.rspeer.runetek.api.scene.SceneObjects;
import org.rspeer.script.Script;
import org.rspeer.script.ScriptMeta;
import org.rspeer.script.task.TaskScript;
import org.rspeer.ui.Log;

import javax.swing.*;


@ScriptMeta(name = "Script Name", desc = "Script Description", developer = "Developer Name")
public class FirstScript extends Script {

    private boolean dropLogs = false;

    //Etc

    private static final String REGULAR_TREE_NAME = new String("Tree");

    //Predicates
    private static final String AXE_PREDICATE = new String("Axe");
    private static final String REGULAR_LOG_NAME = new String("Logs");

    //Actions
    private static final String DROP_Action = new String("Drop");
    private static final String CUT_ACTION = new String("Chop down");

    //Areas

    private static final Area BANK_AREA = Area.rectangular(null, null);
    private static final Area TREE_AREA = Area.rectangular(3187, 3221, 3197, 3212);




    @Override
    public void onStart() {
        //When the script is first started the segment of code in this method will be ran once.
    }

    @Override
    public int loop() {

        Player local = Players.getLocal();
        if(!local.isMoving() && !local.isAnimating()){
            if(Inventory.isFull()){
                //Bank logs
                    if(!Bank.isOpen()){
                        Log.info("Opening Bank");
                        Bank.open();
                        return 1000;
                    }

                    if(Bank.depositAll(REGULAR_LOG_NAME)){
                        Log.info("Depositing Logs");
                        return 1000;
                    }
                }
            }else{
                if(TREE_AREA.contains(local)){
                    //Cut trees
                    final SceneObject tree = SceneObjects.getNearest(x -> x
                            .getName().equals(REGULAR_TREE_NAME) && TREE_AREA.contains(x));
                    if(tree != null){
                        Log.info("Chopping down tree");
                        tree.interact(CUT_ACTION);
                    }
                }else{
                    //Walk to trees
                    Log.info("Walking to tree");
                    Movement.walkTo(TREE_AREA.getCenter());
                    return 1000;
                }
            }
        return 600;
        }





    @Override
    public void onStop() {
        //When the script is stopped the segment of code in this method will be ran once.
    }

}
