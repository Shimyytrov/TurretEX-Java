package SCH.content;

import mindustry.content.*;
import mindustry.entities.bullet.*;
import mindustry.entities.pattern.ShootAlternate;
import mindustry.type.*;
import mindustry.world.*;
import mindustry.world.blocks.defense.*;
import mindustry.world.blocks.defense.turrets.*;
import mindustry.Vars;

public class schBlocks {

    /* Flags */
    public static Block flagSCH, flagDEU, flagPOL;

    /* SCH Turrets */
    public static Block KavtashkaMKI, KavtashkaMKII, KavtashkaMKIII, KavtashkaMKIV;
    public static Block Satan;
    public static Block GoryMKI, GoryMKII;
    public static Block Kalinka, Katyusha, KatyushaCHEAT;

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
                    reloadMultiplier = 0.6f;
                    ammoMultiplier = 4;
                    lifetime = 60f;
                }},
                Items.graphite, new BasicBulletType(8f, 18){{
                    width = 7f;
                    height = 9f;
                    homingPower = 0.1f;
                    reloadMultiplier = 1.5f;
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
                    reloadMultiplier = 0.6f;
                    ammoMultiplier = 4;
                    lifetime = 60f;
                }},
                Items.graphite, new BasicBulletType(8f, 18){{
                    width = 7f;
                    height = 9f;
                    homingPower = 0.1f;
                    reloadMultiplier = 1.5f;
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
    };
}; 