package Script.Tasks;

import Script.FirstScript;
import org.rspeer.runetek.adapter.component.Item;
import org.rspeer.runetek.api.commons.Time;
import org.rspeer.runetek.api.component.tab.Inventory;
import org.rspeer.script.task.Task;

public class Drop extends Task {

    private static final String DROP_ACTION = "Drop";

    @Override
    public boolean validate() {
        return Inventory.isFull() && FirstScript.PowerCutting;
    }

    @Override
    public int execute() {
        for(Item item : Inventory.getItems(x -> !x.getName().equals(FirstScript.tree.getLogName()))){
            item.interact(DROP_ACTION);
            Time.sleep(150, 250);

        }

        return 600;

    }
}
