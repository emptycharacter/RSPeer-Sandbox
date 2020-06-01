package Script;
import Script.Tasks.Banking;
import Script.Tasks.Drop;
import Script.Tasks.Traverse;
import Script.Tasks.Woodcut;
import Script.UI.GUI;
import org.rspeer.runetek.api.movement.position.Area;
import org.rspeer.script.ScriptMeta;
import org.rspeer.script.task.TaskScript;
import org.rspeer.ui.Log;

@ScriptMeta(name = "Script Name", desc = "Script Description", developer = "Developer Name")
public class FirstScript extends TaskScript {

    //Booleans
    public static boolean PowerCutting = false;

    //Predicates
    public static final String REGULAR_LOG_NAME = new String("Logs");


    @Override
    public void onStart() {
        submit(new GUI(),
                new Banking(),
                new Drop(),
                new Traverse(),
                new Woodcut());
    }



    @Override
    public void onStop() {
        Log.severe("Script Stopped");
    }

}
