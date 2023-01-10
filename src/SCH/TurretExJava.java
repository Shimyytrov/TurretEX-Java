package SCH;

import SCH.content.schBlocks;
import SCH.content.schTechTree;
import mindustry.mod.Mod;

public class TurretExJava extends Mod{
    public TurretExJava(){
    }

    @Override
    public void loadContent(){
        schBlocks.load();
        schTechTree.load();
    }
}
