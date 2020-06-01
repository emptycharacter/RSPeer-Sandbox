package Script.Tasks;

import Script.FirstScript;
import org.rspeer.runetek.adapter.scene.SceneObject;
import org.rspeer.runetek.api.scene.Players;
import org.rspeer.runetek.api.scene.SceneObjects;
import org.rspeer.script.task.Task;

public class Woodcut extends Task {

    private static final String CUT_ACTION = new String("Chop down");



    @Override
    public boolean validate() {
        return !Players.getLocal().isAnimating() && !Players.getLocal().isMoving();
    }

    @Override
    public int execute() {
        SceneObject tree = SceneObjects.getNearest(x -> x.getName()
                .equals(FirstScript.tree.getTreeName()) && FirstScript.location.getTreeArea().contains(x));
        if(tree != null){
            tree.interact(CUT_ACTION);

        }
        return 1100;
    }
}
