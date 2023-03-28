package SCH;

import SCH.content.schUnitTypes;

import java.util.Locale;

import SCH.content.schBlocks;
import SCH.content.schTechTree;
import mindustry.ui.dialogs.LanguageDialog;
import arc.*;
import arc.struct.*;
import mindustry.Vars;
import mindustry.game.EventType.*;
import mindustry.mod.Mod;

public class TurretExJava extends Mod{
    public TurretExJava(){
        if(!Vars.headless){
            Events.on(ContentInitEvent.class, e -> {
              Vars.locales = Seq.with(Vars.locales).add(new Locale("sch")).toArray(Locale.class);
              LanguageDialog.displayNames.put("sch", "sch");
            });
          }
    }

    @Override
    public void loadContent(){
        schUnitTypes.load();
        schBlocks.load();
        schTechTree.load();
    }
}
