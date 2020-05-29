package org.empty;

import org.rspeer.runetek.adapter.component.Item;
import org.rspeer.runetek.adapter.scene.Player;
import org.rspeer.runetek.adapter.scene.SceneObject;
import org.rspeer.runetek.api.commons.Time;
import org.rspeer.runetek.api.component.Bank;
import org.rspeer.runetek.api.component.tab.Inventory;
import org.rspeer.runetek.api.movement.position.Area;
import org.rspeer.runetek.api.scene.Players;
import org.rspeer.runetek.api.scene.SceneObjects;
import org.rspeer.script.Script;
import org.rspeer.script.ScriptMeta;

import javax.swing.*;


@ScriptMeta(name = "Script Name", desc = "Script Description", developer = "Developer Name")
public class FirstScript extends Script {

    private boolean dropLogs = false;
    private static final String DROP_Action = new String("Drop");
    private static final String logName = new String("Oak Logs");
    private static final String AXE_PREDICATE = new String("Axe");
    private static final String treeName = new String("Tree");
    private static final String CUT_ACTION = new String("Chop Down");

    private static final Area BANK_AREA = Area.rectangular(null, null);
    private static final Area TREE_AREA = Area.rectangular(null, null);

    @Override
    public void onStart() {
        //When the script is first started the segment of code in this method will be ran once.
    }

    @Override
    public int loop() {
        Player local = Players.getLocal();
        if(!local.isMoving() && !local.isAnimating()){
            if(Inventory.isFull()){
                if(dropLogs){
                    //Drop logs
                    for(Item log : Inventory.getItems(item -> item.getName().equals(logName))){
                        log.interact(DROP_Action);
                        Time.sleep(300);
                    }
                }else{
                    if(BANK_AREA.contains(local)){
                        if(Bank.isOpen())
                        {
                            Bank.depositAllExcept(AXE_PREDICATE);
                        }else{
                            //Open Bank
                        }
                    }else{
                        //Walk to bank
                    }
                }
            }else{
                if(TREE_AREA.contains(local)){
                    //Cut trees
                    final SceneObject tree = SceneObjects.getNearest(treeName);
                    if(tree != null){
                        tree.interact(CUT_ACTION);
                    }
                }else{
                    //Walk to trees
                }
            }
        }
        return 0;
    }


    @Override
    public void onStop() {
        //When the script is stopped the segment of code in this method will be ran once.
    }

}
