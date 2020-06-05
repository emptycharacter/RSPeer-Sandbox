package Script;
import Script.Data.Location;
import Script.Data.Tree;
import Script.Tasks.*;
import Script.UI.GUI;
import org.rspeer.runetek.api.commons.StopWatch;
import org.rspeer.runetek.api.component.tab.Skill;
import org.rspeer.runetek.api.component.tab.Skills;
import org.rspeer.runetek.api.movement.position.Area;
import org.rspeer.runetek.event.listeners.RenderListener;
import org.rspeer.runetek.event.types.RenderEvent;
import org.rspeer.script.ScriptMeta;
import org.rspeer.script.task.TaskScript;
import org.rspeer.ui.Log;

import java.awt.*;

@ScriptMeta(name = "Script Name", desc = "Script Description", developer = "Developer Name")
public class FirstScript extends TaskScript implements RenderListener {

    //Booleans
    public static boolean PowerCutting = false;
    public static Tree tree;
    public static Location location;
    private StopWatch runtime;
    private int startXP;


    @Override
    public void onStart() {
        Log.fine("Script Started");
        runtime = StopWatch.start();
        startXP = Skills.getExperience(Skill.WOODCUTTING);

        submit(new GUI(),
                new ToggleRun(),
                new Banking(),
                new Drop(),
                new Traverse(),
                new Woodcut());
    }



    @Override
    public void onStop() {
        Log.severe("Script Stopped");
    }

    @Override
    public void notify(RenderEvent renderEvent) {
        Graphics g = renderEvent.getSource();

        int gainedXP = (Skills.getExperience(Skill.WOODCUTTING) - startXP);

        g.drawString("Runtime: " + runtime.toElapsedString(), 20, 20);
        g.drawString("XP Gained: " + gainedXP, 20, 40);
        g.drawString("XP Per Hour: " + runtime.getHourlyRate(gainedXP), 20, 60);

    }
}
