package Script.Tasks;

import Script.FirstScript;
import org.rspeer.runetek.api.movement.Movement;
import org.rspeer.runetek.api.movement.position.Area;
import org.rspeer.runetek.api.scene.Players;
import org.rspeer.script.task.Task;

public class Traverse extends Task {

    public static final Area TREE_AREA = Area.rectangular(3187, 3221, 3197, 3212);

    @Override
    public boolean validate() {
        return !FirstScript.location.getTreeArea().contains(Players.getLocal());
    }

    @Override
    public int execute() {
        Movement.walkTo(FirstScript.location.getTreeArea().getCenter());
        return 1000;
    }
}
