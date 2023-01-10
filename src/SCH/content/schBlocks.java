package SCH.content;

import arc.graphics.*;
import arc.math.*;
import arc.struct.*;
import mindustry.*;
import mindustry.content.*;
import mindustry.entities.*;
import mindustry.entities.abilities.*;
import mindustry.entities.bullet.*;
import mindustry.entities.effect.*;
import mindustry.entities.part.DrawPart.*;
import mindustry.entities.part.*;
import mindustry.entities.pattern.*;
import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.type.*;
import mindustry.type.unit.*;
import mindustry.world.*;
import mindustry.world.blocks.*;
import mindustry.world.blocks.campaign.*;
import mindustry.world.blocks.defense.*;
import mindustry.world.blocks.defense.turrets.*;
import mindustry.world.blocks.distribution.*;
import mindustry.world.blocks.environment.*;
import mindustry.world.blocks.heat.*;
import mindustry.world.blocks.legacy.*;
import mindustry.world.blocks.liquid.*;
import mindustry.world.blocks.logic.*;
import mindustry.world.blocks.payloads.*;
import mindustry.world.blocks.power.*;
import mindustry.world.blocks.production.*;
import mindustry.world.blocks.sandbox.*;
import mindustry.world.blocks.storage.*;
import mindustry.world.blocks.units.*;
import mindustry.world.consumers.*;
import mindustry.world.draw.*;
import mindustry.world.meta.*;

import static mindustry.Vars.*;
import static mindustry.type.ItemStack.*;

public class schBlocks {

    public static Block 
    /* Flags */
    flagSCH, flagDEU, flagPOL,

    /* SCH Turrets */
    KavtashkaMKI, KavtashkaMKII, KavtashkaMKIII, KavtashkaMKIV,
    Satan,
    GoryMKI, GoryMKII,
    Kalinka, Katyusha, KatyushaCHEAT
    ;

    public static void load() {
        /* Flags */
        flagSCH = new Wall("Schmitrovland") {{
            requirements(Category.defense, ItemStack.with(Items.copper, 1), true);
            health = 16;
            size = 3;
            placeSound = Vars.tree.loadSound("Anthems/SDFE");
            placePitchChange = false;
        }};
        flagDEU = new Wall("Deutschland") {{
            requirements(Category.defense, ItemStack.with(Items.copper, 1), true);
            health = 16;
            size = 3;
            placeSound = Vars.tree.loadSound("Anthems/Deutschlandlied");
            placePitchChange = false;
        }};
        flagPOL = new Wall("Polska") {{
            requirements(Category.defense, ItemStack.with(Items.copper, 1), true);
            health = 16;
            size = 3;
            placeSound = Vars.tree.loadSound("Anthems/Polska");
            placePitchChange = false;
        }};

        /* SCH Turrets */
        KavtashkaMKI = new ItemTurret("KavtashkaMKI"){{
            requirements(Category.turret, ItemStack.with(Items.copper, 35, Items.lead, 5));
            ammo(
                Items.copper,  new BasicBulletType(8f, 10){{
                    width = 4f;
                    height = 9f;
                    shootEffect = Fx.shootSmall;
                    smokeEffect = Fx.shootSmallSmoke;
                    lifetime = 60f;
                    ammoMultiplier = 2;
                }},
                Items.lead, new BasicBulletType(8f, 12){{
                    width = 9f;
                    height = 12f;
                    ammoMultiplier = 4;
                    lifetime = 60f;
                }},
                Items.graphite, new BasicBulletType(8f, 18){{
                    width = 7f;
                    height = 9f;
                    ammoMultiplier = 5;
                    lifetime = 60f;
                }}
            );

            shoot = new ShootAlternate(0f);

            size = 2;
            shootY = 6f;
            reload = 10f;
            range = 172;
            shootCone = 5f;
            ammoUseEffect = Fx.casing1;
            health = 300;
            inaccuracy = 2f;
            rotateSpeed = 10f;
            coolant = consumeCoolant(0.1f);
            shootSound = Vars.tree.loadSound("Turrets/KavtashkaMKI");

            limitRange();
        }};
        KavtashkaMKII = new ItemTurret("KavtashkaMKII"){{
            requirements(Category.turret, ItemStack.with(Items.copper, 45, Items.lead, 5));
            ammo(
                Items.copper,  new BasicBulletType(8f, 10){{
                    width = 4f;
                    height = 9f;
                    shootEffect = Fx.shootSmall;
                    smokeEffect = Fx.shootSmallSmoke;
                    lifetime = 60f;
                    ammoMultiplier = 4;
                }},
                Items.lead, new BasicBulletType(8f, 12){{
                    width = 9f;
                    height = 12f;
                    ammoMultiplier = 4;
                    lifetime = 60f;
                }},
                Items.graphite, new BasicBulletType(8f, 18){{
                    width = 7f;
                    height = 9f;
                    ammoMultiplier = 5;
                    lifetime = 60f;
                }}
            );

            shoot = new ShootAlternate(0f);

            size = 2;
            shootY = 6f;
            reload = 6f;
            range = 180;
            shootCone = 5f;
            ammoUseEffect = Fx.casing1;
            health = 336;
            inaccuracy = 3f;
            rotateSpeed = 10f;
            coolant = consumeCoolant(0.1f);
            shootSound = Vars.tree.loadSound("Turrets/KavtashkaMKII");

            limitRange();
        }};
        KavtashkaMKIII = new ItemTurret("KavtashkaMKIII"){{
            requirements(Category.turret, ItemStack.with(Items.copper, 45, Items.lead, 15, Items.graphite, 5));
            ammo(
                Items.copper,  new BasicBulletType(8f, 10){{
                    width = 4f;
                    height = 9f;
                    shootEffect = Fx.shootSmall;
                    smokeEffect = Fx.shootSmallSmoke;
                    lifetime = 60f;
                    ammoMultiplier = 15;
                }},
                Items.lead, new BasicBulletType(8f, 12){{
                    width = 9f;
                    height = 12f;
                    ammoMultiplier = 15;
                    lifetime = 60f;
                }},
                Items.graphite, new BasicBulletType(8f, 18){{
                    width = 7f;
                    height = 9f;
                    ammoMultiplier = 20;
                    lifetime = 60f;
                }}
            );

            shoot = new ShootAlternate(0f);

            size = 2;
            shootY = 6f;
            reload = 3f;
            range = 192;
            shootCone = 5f;
            ammoUseEffect = Fx.casing1;
            health = 336;
            inaccuracy = 1f;
            rotateSpeed = 10f;
            coolant = consumeCoolant(0.1f);
            shootSound = Vars.tree.loadSound("Turrets/KavtashkaMKIII");

            limitRange();
        }};
    };
}; 