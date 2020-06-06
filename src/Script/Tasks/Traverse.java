package Script.Tasks;

import Script.FirstScript;
import org.rspeer.runetek.api.movement.Movement;
import org.rspeer.runetek.api.movement.position.Area;
import org.rspeer.runetek.api.scene.Players;
import org.rspeer.script.task.Task;

public class Traverse extends Task {


    @Override
    public boolean validate() {
        boolean some = !FirstScript.location.getTreeArea().contains(Players.getLocal());
        return some;
    }

    @Override
    public int execute() {
        Movement.walkTo(FirstScript.location.getTreeArea().getCenter());
        return 1000;
    }
}
