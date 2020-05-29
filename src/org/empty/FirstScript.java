package org.empty;

import org.rspeer.runetek.adapter.scene.Player;
import org.rspeer.runetek.api.component.tab.Inventory;
import org.rspeer.runetek.api.movement.position.Area;
import org.rspeer.runetek.api.scene.Players;
import org.rspeer.script.Script;
import org.rspeer.script.ScriptMeta;


@ScriptMeta(name = "Script Name", desc = "Script Description", developer = "Developer Name")
public class FirstScript extends Script {

    private boolean dropLogs = false;

    private static final Area BANK_AREA = Area.rectangular(null, null);
    private static final Area TREE_AREA = Area.rectangular(null, null);

    @Override
    public void onStart() {
        //When the script is first started the segment of code in this method will be ran once.
    }

    @Override
    public int loop() {
        Player local = Players.getLocal();
        if (!local.isMoving() && !local.isAnimating()) {
            if (Inventory.isFull()) {
                if(dropLogs){
                    //Drop logs
                }
            } else {
                if (BANK_AREA.contains(local)) {
                    //Bank logs
                } else {
                    //Walk to bank
                }
            }
        } else {
            if (TREE_AREA.contains(local)) {
                //Cut trees
            } else {
                //Walk to trees
            }
        }


        return 0;
    }

    @Override
    public void onStop() {
        //When the script is stopped the segment of code in this method will be ran once.
    }

}
