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
    Kalinka, Katyusha, KatyushaCHEAT,

    /* DEU Turrets */
    SteinkaMKI, SteinkaMKII, SteinkaMKIII,

    /* POL Turrets */
    Niedzwiedz, NiedzwiedzA2, Rozpierducha
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
        KavtashkaMKIV = new ItemTurret("KavtashkaMKIV"){{
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

            maxAmmo = 8192;
            size = 2;
            shootY = 6f;
            reload = 1f;
            range = 192;
            shootCone = 5f;
            ammoUseEffect = Fx.casing1;
            health = 336;
            inaccuracy = 1f;
            rotateSpeed = 10f;
            coolant = consumeCoolant(0.1f);
            shootSound = Vars.tree.loadSound("Turrets/KavtashkaMKIV");

            limitRange();
        }};
        Kalinka = new ItemTurret("Kalinka"){{
            requirements(Category.turret, ItemStack.with(Items.silicon, 15, Items.lead, 15, Items.graphite, 35));
            ammo(
                Items.blastCompound, new MissileBulletType(4.8f, 10){{
                    width = 8f;
                    height = 8f;
                    shrinkY = 0f;
                    homingPower = 0.3f;
                    homingRange = 250f;
                    splashDamageRadius = 72f;
                    splashDamage = 72f * 1.5f;
                    ammoMultiplier = 5f;
                    hitEffect = Fx.blastExplosion;
                    despawnEffect = Fx.blastExplosion;

                    status = StatusEffects.blasted;
                    statusDuration = 60f;
                    lifetime = 180;
                    hitSound = Vars.tree.loadSound("Hits/ExplodeRL");
                }},
                Items.pyratite, new MissileBulletType(4.5f, 12){{
                    frontColor = Pal.lightishOrange;
                    backColor = Pal.lightOrange;
                    width = 7f;
                    height = 8f;
                    shrinkY = 0f;
                    homingPower = 0.1f;
                    homingRange = 250f;
                    splashDamageRadius = 48f;
                    splashDamage = 48f * 1.5f;
                    makeFire = true;
                    ammoMultiplier = 5f;
                    hitEffect = Fx.blastExplosion;
                    status = StatusEffects.burning;
                    lifetime = 180;
                    hitSound = Vars.tree.loadSound("Hits/ExplodeRL");
                }},
                Items.silicon, new MissileBulletType(8f, 72){{
                    trailColor = Pal.gray;
                    frontColor = Pal.gray;
                    backColor = Pal.gray;
                    width = 7f;
                    height = 9f;
                    homingPower = 0.8f;
                    homingRange = 250f;
                    ammoMultiplier = 5;
                    lifetime = 120f;
                    hitSound = Vars.tree.loadSound("Hits/MetalHitRL");
                }}
            );

            shoot = new ShootAlternate(){{
                shots = 6;
                barrels = 3;
                spread = 3.5f;
                shotDelay = 4f;
            }};

            size = 2;
            shootY = 7f;
            reload = 30f;
            range = 360;
            health = 336;
            inaccuracy = 10f;
            rotateSpeed = 10f;
            coolant = consumeCoolant(0.1f);
            shootSound = Vars.tree.loadSound("Turrets/KalinkaRL");

            limitRange();
        }};
        Katyusha = new ItemTurret("Katyusha"){{
            requirements(Category.turret, ItemStack.with(Items.silicon, 150, Items.lead, 150, Items.graphite, 100, Items.copper, 50, Items.titanium, 25));
            ammo(
                Items.blastCompound, new MissileBulletType(4.8f, 10){{
                    width = 8f;
                    height = 8f;
                    shrinkY = 0f;
                    homingPower = 0.3f;
                    homingRange = 2500f;
                    splashDamageRadius = 72f;
                    splashDamage = 72f * 1.5f;
                    ammoMultiplier = 5f;
                    hitEffect = Fx.blastExplosion;
                    despawnEffect = Fx.blastExplosion;

                    status = StatusEffects.blasted;
                    statusDuration = 60f;
                    lifetime = 3600;
                    hitSound = Vars.tree.loadSound("Hits/ExplodeRL");
                }},
                Items.pyratite, new MissileBulletType(4.5f, 12){{
                    frontColor = Pal.lightishOrange;
                    backColor = Pal.lightOrange;
                    width = 7f;
                    height = 8f;
                    shrinkY = 0f;
                    homingPower = 0.1f;
                    homingRange = 2500f;
                    splashDamageRadius = 48f;
                    splashDamage = 48f * 1.5f;
                    makeFire = true;
                    ammoMultiplier = 5f;
                    hitEffect = Fx.blastExplosion;
                    status = StatusEffects.burning;
                    lifetime = 3600;
                    hitSound = Vars.tree.loadSound("Hits/ExplodeRL");
                }},
                Items.silicon, new MissileBulletType(8f, 72){{
                    trailColor = Pal.gray;
                    frontColor = Pal.gray;
                    backColor = Pal.gray;
                    width = 7f;
                    height = 9f;
                    homingPower = 0.8f;
                    homingRange = 2500f;
                    ammoMultiplier = 5;
                    lifetime = 3600;
                    hitSound = Vars.tree.loadSound("Hits/MetalHitRL");
                }}
            );

            shoot = new ShootAlternate(){{
                shots = 60;
                shotDelay = 1f;
            }};

            maxAmmo = 240;
            size = 4;
            shootY = -7f;
            reload = 3600f;
            range = 60000;
            health = 2500;
            inaccuracy = 360f;
            shootCone = 360f;
            rotateSpeed = 0f;
            coolant = consumeCoolant(0.1f);
            shootSound = Vars.tree.loadSound("Turrets/KalinkaRL");

            limitRange();
        }};
        KatyushaCHEAT = new ItemTurret("KatyushaCHEAT"){{
            requirements(Category.turret, ItemStack.with(Items.silicon, 150, Items.lead, 150, Items.graphite, 100, Items.copper, 50, Items.titanium, 25));
            ammo(
                    Items.copper, new MissileBulletType(4.8f, 10){{
                        width = 8f;
                        height = 8f;
                        shrinkY = 0f;
                        homingPower = 0.3f;
                        homingRange = 2500f;
                        splashDamageRadius = 72f;
                        splashDamage = 72f * 1.5f;
                        ammoMultiplier = 60f;
                        hitEffect = Fx.blastExplosion;
                        despawnEffect = Fx.blastExplosion;

                        status = StatusEffects.blasted;
                        statusDuration = 60f;
                        lifetime = 3600;
                        hitSound = Vars.tree.loadSound("Hits/ExplodeRL");
                    }},
                    Items.blastCompound, new MissileBulletType(4.8f, 10){{
                        width = 8f;
                        height = 8f;
                        shrinkY = 0f;
                        homingPower = 0.3f;
                        homingRange = 2500f;
                        splashDamageRadius = 72f;
                        splashDamage = 72f * 1.5f;
                        ammoMultiplier = 60f;
                        hitEffect = Fx.blastExplosion;
                        despawnEffect = Fx.blastExplosion;

                        status = StatusEffects.blasted;
                        statusDuration = 60f;
                        lifetime = 3600;
                        hitSound = Vars.tree.loadSound("Hits/ExplodeRL");
                    }},
                    Items.pyratite, new MissileBulletType(4.5f, 12){{
                        frontColor = Pal.lightishOrange;
                        backColor = Pal.lightOrange;
                        width = 7f;
                        height = 8f;
                        shrinkY = 0f;
                        homingPower = 0.1f;
                        homingRange = 2500f;
                        splashDamageRadius = 48f;
                        splashDamage = 48f * 1.5f;
                        makeFire = true;
                        ammoMultiplier = 60;
                        hitEffect = Fx.blastExplosion;
                        status = StatusEffects.burning;
                        lifetime = 3600;
                        hitSound = Vars.tree.loadSound("Hits/ExplodeRL");
                    }},
                    Items.silicon, new MissileBulletType(8f, 72){{
                        trailColor = Pal.gray;
                        frontColor = Pal.gray;
                        backColor = Pal.gray;
                        width = 7f;
                        height = 9f;
                        homingPower = 0.8f;
                        homingRange = 2500f;
                        ammoMultiplier = 60;
                        lifetime = 3600;
                        hitSound = Vars.tree.loadSound("Hits/MetalHitRL");
                    }}
            );

            shoot = new ShootAlternate(0f);

            maxAmmo = 10124;
            size = 4;
            shootY = -7f;
            reload = 1f;
            range = 60000;
            health = 2500;
            inaccuracy = 360f;
            shootCone = 360f;
            rotateSpeed = 0f;
            coolant = consumeCoolant(0.1f);
            shootSound = Vars.tree.loadSound("Turrets/KalinkaRL");

            limitRange();
        }};
        Satan = new ItemTurret("Satan"){{
            requirements(Category.turret, ItemStack.with(Items.silicon, 50, Items.lead, 150, Items.graphite, 50, Items.copper, 200, Items.titanium, 100, Items.thorium, 50));
            ammo(
                    Items.thorium, new ArtilleryBulletType(8f, 8192){{
                        width = 32f;
                        height = 64f;
                        splashDamageRadius = 1024f;
                        splashDamage = 1024f * 1.5f;
                        ammoMultiplier = 1f;
                        hitEffect = Fx.reactorExplosion;
                        despawnEffect = Fx.reactorExplosion;
                        buildingDamageMultiplier = 0.1f;
                        status = StatusEffects.blasted;
                        statusDuration = 120f;
                        lifetime = 1080;
                        hitSound = Vars.tree.loadSound("Hits/SatanEXP");
                        despawnSound = Vars.tree.loadSound("Hits/SatanEXP");
                        shootEffect = Fx.shootBig2;
                        smokeEffect = Fx.shootBigSmoke2;
                        frontColor = Color.valueOf("FFD04D");
                        backColor = Color.valueOf("863925");
                        trailLength = 25;
                        trailWidth = 15;
                        trailColor = Color.valueOf("863925");
                    }},
                    Items.titanium, new ArtilleryBulletType(7f, 4096){{
                        width = 32f;
                        height = 64f;
                        splashDamageRadius = 512f;
                        splashDamage = 512f * 1.5f;
                        ammoMultiplier = 1f;
                        hitEffect = Fx.reactorExplosion;
                        despawnEffect = Fx.reactorExplosion;
                        buildingDamageMultiplier = 0.1f;
                        status = StatusEffects.blasted;
                        statusDuration = 90f;
                        lifetime = 1080;
                        hitSound = Vars.tree.loadSound("Hits/SatanEXP");
                        despawnSound = Vars.tree.loadSound("Hits/SatanEXP");
                        shootEffect = Fx.shootBig;
                        smokeEffect = Fx.shootBigSmoke;
                        frontColor = Color.valueOf("34FFFF");
                        backColor = Color.valueOf("762EFF");
                        trailLength = 25;
                        trailWidth = 15;
                        trailColor = Color.valueOf("762EFF");
                    }}
            );

            shoot = new ShootAlternate(0f);

            maxAmmo = 6;
            ammoPerShot = 3;
            size = 3;
            shootY = 8f;
            reload = 1080f;
            range = 2048;
            health = 2500;
            inaccuracy = 0f;
            rotateSpeed = 2f;
            shootSound = Vars.tree.loadSound("Turrets/Satan");

            limitRange();
        }};
        GoryMKI = new ItemTurret("GoryMKI"){{
            requirements(Category.turret, ItemStack.with(Items.copper, 25, Items.lead, 10));
            ammo(
                Items.copper, new FlakBulletType(12f, 15){{
                    width = 2f;
                    height = 9f;
                    splashDamageRadius = 24f;
                    splashDamage = 24f * 1.5f;
                    ammoMultiplier = 5f;
                    lifetime = 60;
                    shootEffect = Fx.shootSmall;
                    smokeEffect = Fx.shootSmallSmoke;
                    hitEffect = Fx.flakExplosion;
                    hitSound = Vars.tree.loadSound("Hits/MetalHitRL");
                }},
                Items.lead, new FlakBulletType(12f, 24){{
                    width = 2f;
                    height = 9f;
                    splashDamageRadius = 36f;
                    splashDamage = 36f * 1.5f;
                    ammoMultiplier = 5f;
                    lifetime = 60;
                    shootEffect = Fx.shootSmall;
                    smokeEffect = Fx.shootSmallSmoke;
                    hitEffect = Fx.flakExplosion;
                    fragBullets = 8;
                    fragBullet = new BasicBulletType(3f, 24){{
                        width = 5f;
                        height = 12f;
                        shrinkY = 1f;
                        lifetime = 20f;
                        backColor = Pal.gray;
                        frontColor = Color.white;
                        despawnEffect = Fx.none;
                        collidesGround = true;
                    }};
                    hitSound = Vars.tree.loadSound("Hits/LeadHit");
                }},
                Items.metaglass, new FlakBulletType(12f, 36){{
                    width = 2f;
                    height = 9f;
                    splashDamageRadius = 48f;
                    splashDamage = 48f * 1.5f;
                    ammoMultiplier = 5f;
                    lifetime = 60;
                    shootEffect = Fx.shootSmall;
                    smokeEffect = Fx.shootSmallSmoke;
                    hitEffect = Fx.flakExplosion;
                    fragBullets = 12;
                    fragBullet = new BasicBulletType(3f, 28){{
                        width = 5f;
                        height = 12f;
                        shrinkY = 1f;
                        lifetime = 20f;
                        backColor = Pal.gray;
                        frontColor = Color.white;
                        despawnEffect = Fx.none;
                        collidesGround = true;
                    }};
                    hitSound = Vars.tree.loadSound("Hits/LeadHit");
                }}
            );

            shoot = new ShootAlternate(0f);

            size = 1;
            shootY = 3f;
            reload = 15f;
            range = 255;
            health = 150;
            inaccuracy = 7f;
            rotateSpeed = 25f;
            coolant = consumeCoolant(0.1f);
            targetGround = false;
            targetAir = true;
            shootSound = Vars.tree.loadSound("Turrets/AA-sg");

            limitRange();
        }};
    };
}; 