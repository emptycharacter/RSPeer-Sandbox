package Script.Tasks;

import org.rspeer.runetek.api.movement.Movement;
import org.rspeer.runetek.api.movement.position.Area;
import org.rspeer.runetek.api.scene.Players;
import org.rspeer.script.task.Task;

public class Traverse extends Task {

    public static final Area TREE_AREA = Area.rectangular(3187, 3221, 3197, 3212);

    @Override
    public boolean validate() {
        return !TREE_AREA.contains(Players.getLocal());
    }

    @Override
    public int execute() {
        Movement.walkTo(TREE_AREA.getCenter());
        return 1000;
    }
}
