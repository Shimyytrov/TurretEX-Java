package SCH.content;

import mindustry.content.Items;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.Block;
import mindustry.world.blocks.defense.Wall;
public class schBlocks {

    /** Flags */
    public static Block flagSCH, flagDEU, flagPOL;

    public static void load() {
        flagSCH = new Wall("Schmitrovland") {{
            requirements(Category.defense, ItemStack.with(Items.copper, 1), false);
            health = 16;
            size = 3;
        }};
    };
}; 