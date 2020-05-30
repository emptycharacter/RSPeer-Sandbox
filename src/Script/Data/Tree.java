package Script.Data;

import org.rspeer.runetek.api.movement.position.Area;

public enum Tree {

    TREE(),
    OAK(),
    WILLOW(),
    MAPLE(),
    YEW(),
    ;

    private int Level;
    private Area treeArea;
    private String treeName;
    private String logName;

    Tree(int level, Area treeArea, String treeName, String logName) {
        Level = level;
        this.treeArea = treeArea;
        this.treeName = treeName;
        this.logName = logName;
    }

    public int getLevel() {
        return Level;
    }

    public void setLevel(int level) {
        Level = level;
    }

    public Area getTreeArea() {
        return treeArea;
    }

    public void setTreeArea(Area treeArea) {
        this.treeArea = treeArea;
    }

    public String getTreeName() {
        return treeName;
    }

    public void setTreeName(String treeName) {
        this.treeName = treeName;
    }

    public String getLogName() {
        return logName;
    }

    public void setLogName(String logName) {
        this.logName = logName;
    }
}
