package Script.Tasks;

import Script.FirstScript;
import org.rspeer.runetek.api.component.Bank;
import org.rspeer.runetek.api.component.tab.Inventory;
import org.rspeer.script.task.Task;

public class Banking extends Task {
    @Override
    public boolean validate() {
        return Inventory.isFull() && !FirstScript.PowerCutting;
    }

    @Override
    public int execute() {
        if(!Bank.isOpen()){
            Bank.open();
            return 1000;
        }

        Bank.depositAll(FirstScript.REGULAR_LOG_NAME);
        return 1000;
    }
}
