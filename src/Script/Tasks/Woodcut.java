package Script.Tasks;

import org.rspeer.runetek.adapter.scene.SceneObject;
import org.rspeer.runetek.api.scene.Players;
import org.rspeer.runetek.api.scene.SceneObjects;
import org.rspeer.script.task.Task;

public class Woodcut extends Task {

    private static final String CUT_ACTION = new String("Chop down");
    private static final String REGULAR_TREE_NAME = new String("Tree");


    @Override
    public boolean validate() {
        return !Players.getLocal().isAnimating() && !Players.getLocal().isMoving();
    }

    @Override
    public int execute() {
        SceneObject tree = SceneObjects.getNearest(x -> x.getName()
                .equals(REGULAR_TREE_NAME) && Traverse.TREE_AREA.contains(x));
        if(tree != null){
            tree.interact(CUT_ACTION);

        }
        return 1100;
    }
}
