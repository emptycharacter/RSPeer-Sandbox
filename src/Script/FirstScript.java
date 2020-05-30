package Script;
import Script.Tasks.Banking;
import Script.Tasks.Drop;
import Script.Tasks.Traverse;
import Script.Tasks.Woodcut;
import org.rspeer.runetek.api.movement.position.Area;
import org.rspeer.script.ScriptMeta;
import org.rspeer.script.task.TaskScript;
import org.rspeer.ui.Log;

@ScriptMeta(name = "Script Name", desc = "Script Description", developer = "Developer Name")
public class FirstScript extends TaskScript {

    //Booleans
    private boolean dropLogs = false;
    public static boolean PowerCutting = false;

    //Predicates

    private static final String AXE_PREDICATE = new String("Axe");
    public static final String REGULAR_LOG_NAME = new String("Logs");

    //Actions



    //Areas

    private static final Area BANK_AREA = Area.rectangular(null, null);



    @Override
    public void onStart() {
        submit(new Banking(),
                new Drop(),
                new Traverse(),
                new Woodcut());
    }



    @Override
    public void onStop() {
        Log.severe("Script Stopped");
    }

}
