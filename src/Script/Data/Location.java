package Script.Data;

import org.rspeer.runetek.api.movement.position.Area;

public enum Location {
    LUMBRIDGE_TREE_AREA(Area.rectangular(3180, 3255, 3172, 3247), Tree.TREE),
    LUMBRIDGE_OAK_AREA(Area.rectangular(3199, 3246, 3205, 3238), Tree.OAK, Tree.TREE),
    DRAYNOR_WILLOW_AREA(Area.rectangular(3081, 3238, 3090, 3224), Tree.WILLOW);

    private Area treeArea;
    private Tree[] trees;

    Location(Area treeArea, Tree... trees) {
        this.treeArea = treeArea;
        this.trees = trees;
    }

    public Area getTreeArea() {
        return treeArea;
    }

    public Tree[] getTrees() {
        return trees;
    }
}
