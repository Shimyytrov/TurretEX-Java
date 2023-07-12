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
    Niedzwiedz, NiedzwiedzA2, Rozpierducha,

    /* Unit Factories */
    schAirFactory,

    /* Reconstructors */
    t2Reconstructor, t3Reconstructor,

    /* Generators */
    coalBurner, steamTurbine,

    /* Fortresses */
    fortCopperRot, fortCopperCor, fortCopperCorII, fortCopperTurret
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
                shots = 3;
                barrels = 3;
                spread = 3.5f;
                shotDelay = 5f;
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
            health = 81928097;
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
                        frontColor = Color.valueOf("cc00ff");
                        backColor = Color.valueOf("762EFF");
                        trailLength = 25;
                        trailWidth = 15;
                        trailColor = Color.valueOf("762EFF");
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
                    hitSound = Vars.tree.loadSound("Hits/GlassHit");
                }}
            );

            shoot = new ShootAlternate(){{
                shots = 3;
                shotDelay = 4f;
                barrels = 1;
            }};

            size = 1;
            shootY = 3f;
            reload = 30f;
            range = 256;
            health = 150;
            shootCone = 5f;
            inaccuracy = 2f;
            rotateSpeed = 25f;
            coolant = consumeCoolant(0.1f);
            targetGround = false;
            targetAir = true;
            shootSound = Vars.tree.loadSound("Turrets/AA-sg");

            limitRange();
        }};
        GoryMKII = new ItemTurret("GoryMKII"){{
            requirements(Category.turret, ItemStack.with(Items.copper, 30, Items.lead, 15, Items.graphite, 15, Items.titanium, 5));
            ammo(
                Items.copper, new FlakBulletType(12f, 15){{
                    frontColor = Color.valueOf("FFD04D");
                    backColor = Color.valueOf("863925");
                    width = 5f;
                    height = 15f;
                    ammoMultiplier = 10f;
                    lifetime = 60;
                    shootEffect = Fx.shootSmall;
                    smokeEffect = Fx.shootSmallSmoke;
                    hitEffect = Fx.flakExplosion;
                    hitSound = Vars.tree.loadSound("Hits/MetalHitRL");
                }},
                Items.lead, new FlakBulletType(12f, 20){{
                    frontColor = Color.valueOf("6F72FF");
                    backColor = Color.valueOf("1B1D6E");
                    width = 5f;
                    height = 15f;
                    splashDamageRadius = 36f;
                    splashDamage = 36f * 1.5f;
                    ammoMultiplier = 10f;
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
                    frontColor = Color.valueOf("FFFFFF");
                    backColor = Color.valueOf("606060");
                    width = 2f;
                    height = 9f;
                    splashDamageRadius = 48f;
                    splashDamage = 48f * 1.5f;
                    ammoMultiplier = 10f;
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
                    hitSound = Vars.tree.loadSound("Hits/GlassHit");
                }}
            );

            shoot = new ShootAlternate(){{
                shots = 1;
                barrels = 3;
                spread = 3.5f;
            }};

            size = 2;
            shootY = 7f;
            reload = 6f;
            range = 360;
            health = 250;
            maxAmmo = 360;
            shootCone = 5f;
            inaccuracy = 4f;
            rotateSpeed = 18f;
            coolant = consumeCoolant(0.1f);
            targetGround = false;
            targetAir = true;
            shootSound = Vars.tree.loadSound("Turrets/AAmk2");

            limitRange();
        }};
        SteinkaMKI = new ItemTurret("SteinkaMKI"){{
            requirements(Category.turret, ItemStack.with(Items.copper, 35, Items.lead, 15));
            ammo(
                Items.copper, new BasicBulletType(12f, 9){{
                    width = 2f;
                    height = 9f;
                    ammoMultiplier = 2f;
                    lifetime = 160;
                    shootEffect = Fx.shootSmall;
                    smokeEffect = Fx.shootSmallSmoke;
                    hitSound = Vars.tree.loadSound("Hits/hitShotgun");
                }},
                Items.lead, new BasicBulletType(12f, 12){{
                    width = 2f;
                    height = 9f;
                    ammoMultiplier = 2f;
                    lifetime = 160;
                    shootEffect = Fx.shootSmall;
                    smokeEffect = Fx.shootSmallSmoke;
                    hitSound = Vars.tree.loadSound("Hits/hitShotgun");
                }},
                Items.metaglass, new BasicBulletType(12f, 24){{
                    width = 2f;
                    height = 9f;
                    ammoMultiplier = 2f;
                    lifetime = 160;
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
                        hitSound = Vars.tree.loadSound("Hits/GlassHit");
                    }};
                    hitSound = Vars.tree.loadSound("Hits/hitShotgun");
                }}
            );

            shoot = new ShootAlternate(){{
                shots = 12;
                barrels = 1;
                spread = 12f;
            }};

            size = 2;
            shootY = 7f;
            reload = 45f;
            range = 128;
            health = 300;
            maxAmmo = 360;
            shootCone = 5f;
            inaccuracy = 12f;
            rotateSpeed = 12f;
            coolant = consumeCoolant(0.05f);
            targetGround = true;
            targetAir = false;
            shootSound = Vars.tree.loadSound("Turrets/SteinkaMKI");

            limitRange();
        }};
        SteinkaMKII = new ItemTurret("SteinkaMKII"){{
            requirements(Category.turret, ItemStack.with(Items.copper, 45, Items.lead, 20));
            ammo(
                Items.copper, new BasicBulletType(12f, 9){{
                    width = 2f;
                    height = 9f;
                    ammoMultiplier = 2f;
                    lifetime = 160;
                    shootEffect = Fx.shootSmall;
                    smokeEffect = Fx.shootSmallSmoke;
                    hitSound = Vars.tree.loadSound("Hits/hitShotgun");
                }},
                Items.lead, new BasicBulletType(12f, 12){{
                    width = 2f;
                    height = 9f;
                    ammoMultiplier = 2f;
                    lifetime = 160;
                    shootEffect = Fx.shootSmall;
                    smokeEffect = Fx.shootSmallSmoke;
                    hitSound = Vars.tree.loadSound("Hits/hitShotgun");
                }},
                Items.metaglass, new BasicBulletType(12f, 24){{
                    width = 2f;
                    height = 9f;
                    ammoMultiplier = 2f;
                    lifetime = 160;
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
                        hitSound = Vars.tree.loadSound("Hits/GlassHit");
                    }};
                    hitSound = Vars.tree.loadSound("Hits/hitShotgun");
                }}
            );

            shoot = new ShootAlternate(){{
                shots = 14;
                barrels = 1;
                spread = 12f;
            }};

            size = 2;
            shootY = 7f;
            reload = 30f;
            range = 168;
            health = 300;
            maxAmmo = 360;
            shootCone = 5f;
            inaccuracy = 14f;
            rotateSpeed = 12f;
            coolant = consumeCoolant(0.05f);
            targetGround = true;
            targetAir = false;
            shootSound = Vars.tree.loadSound("Turrets/SteinkaMKII");

            limitRange();
        }};
        SteinkaMKIII = new ItemTurret("SteinkaMKIII"){{
            requirements(Category.turret, ItemStack.with(Items.copper, 45, Items.lead, 20, Items.graphite, 5));
            ammo(
                Items.copper, new BasicBulletType(12f, 9){{
                    width = 2f;
                    height = 9f;
                    ammoMultiplier = 2f;
                    lifetime = 160;
                    shootEffect = Fx.shootSmall;
                    smokeEffect = Fx.shootSmallSmoke;
                    hitSound = Vars.tree.loadSound("Hits/hitShotgun");
                }},
                Items.lead, new BasicBulletType(12f, 12){{
                    width = 2f;
                    height = 9f;
                    ammoMultiplier = 2f;
                    lifetime = 160;
                    shootEffect = Fx.shootSmall;
                    smokeEffect = Fx.shootSmallSmoke;
                    hitSound = Vars.tree.loadSound("Hits/hitShotgun");
                }},
                Items.metaglass, new BasicBulletType(12f, 24){{
                    width = 2f;
                    height = 9f;
                    ammoMultiplier = 2f;
                    lifetime = 160;
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
                        hitSound = Vars.tree.loadSound("Hits/GlassHit");
                    }};
                    hitSound = Vars.tree.loadSound("Hits/hitShotgun");
                }}
            );

            shoot = new ShootAlternate(){{
                shots = 16;
                barrels = 1;
                spread = 16f;
            }};

            size = 2;
            shootY = 7f;
            reload = 24f;
            range = 192;
            health = 300;
            maxAmmo = 360;
            shootCone = 5f;
            inaccuracy = 16f;
            rotateSpeed = 12f;
            coolant = consumeCoolant(0.05f);
            targetGround = true;
            targetAir = false;
            shootSound = Vars.tree.loadSound("Turrets/SteinkaMKIII");

            limitRange();
        }};
        Niedzwiedz = new ItemTurret("Niedzwiedz"){{
            requirements(Category.turret, ItemStack.with(Items.copper, 255, Items.lead, 55, Items.graphite, 100, Items.titanium, 35));
            range = 128;
            float brange = range + 10f;
            ammo(
                Items.titanium, new ShrapnelBulletType(){{
                    length = brange;
                    damage = 150f;
                    ammoMultiplier = 4f;
                    width = 17f;
                    reloadMultiplier = 1.5f;
                }},
                Items.thorium, new ShrapnelBulletType(){{
                    length = brange;
                    damage = 325f;
                    ammoMultiplier = 5f;
                    toColor = Pal.thoriumPink;
                    shootEffect = smokeEffect = Fx.thoriumShoot;
                }}
            );

            shoot = new ShootSpread(3, 20f);

            size = 3;
            reload = 35f;
            shake = 4f;
            
            recoil = 5f;
            scaledHealth = 250;
            shootCone = 30f;
            rotateSpeed = 12f;
            coolant = consumeCoolant(0.1f);
            targetGround = true;
            targetAir = true;
            shootSound = Vars.tree.loadSound("Turrets/PolskiLaser");
        }};
        NiedzwiedzA2 = new ItemTurret("Niedzwiedz_A2"){{
            requirements(Category.turret, ItemStack.with(Items.copper, 255, Items.lead, 55, Items.graphite, 100, Items.titanium, 35));
            range = 256;
            float brange = range + 10f;
            ammo(
                Items.titanium, new ShrapnelBulletType(){{
                    length = brange;
                    damage = 256f;
                    ammoMultiplier = 4f;
                    width = 17f;
                    reloadMultiplier = 1.5f;
                }},
                Items.thorium, new ShrapnelBulletType(){{
                    length = brange;
                    damage = 512f;
                    ammoMultiplier = 5f;
                    toColor = Pal.thoriumPink;
                    shootEffect = smokeEffect = Fx.thoriumShoot;
                }}
            );

            shoot = new ShootAlternate(){{
                shots = 3;
                barrels = 1;
                spread = 4f;
                shotDelay = 4f;
            }};

            size = 3;
            reload = 60f;
            shake = 4f;
            
            recoil = 5f;
            scaledHealth = 250;
            shootCone = 30f;
            rotateSpeed = 12f;
            inaccuracy = 8f;
            coolant = consumeCoolant(0.1f);
            targetGround = true;
            targetAir = true;
            shootSound = Vars.tree.loadSound("Turrets/PolskiLaser");
        }};
        Rozpierducha = new ItemTurret("Rozpierducha"){{
            requirements(Category.turret, ItemStack.with(Items.copper, 256, Items.lead, 64, Items.graphite, 128, Items.titanium, 32, Items.thorium, 16));
            ammo(
                Items.copper, new BasicBulletType(12f, 36){{
                    frontColor = Color.valueOf("FFD04D");
                    backColor = Color.valueOf("863925");
                    width = 4f;
                    height = 18f;
                    ammoMultiplier = 5f;
                    lifetime = 160;
                    shootEffect = Fx.shootSmall;
                    smokeEffect = Fx.shootSmallSmoke;
                    hitSound = Vars.tree.loadSound("Hits/MetalHitRL");
                }},
                Items.lead, new BasicBulletType(12f, 60){{
                    frontColor = Color.valueOf("6F72FF");
                    backColor = Color.valueOf("1B1D6E");
                    width = 4f;
                    height = 18f;
                    ammoMultiplier = 5f;
                    lifetime = 160;
                    shootEffect = Fx.shootSmall;
                    smokeEffect = Fx.shootSmallSmoke;
                    hitSound = Vars.tree.loadSound("Hits/LeadHit");
                }},
                Items.titanium, new BasicBulletType(12f, 128){{
                    frontColor = Color.valueOf("00e4ff");
                    backColor = Color.valueOf("005963");
                    width = 6f;
                    height = 18f;
                    ammoMultiplier = 5f;
                    lifetime = 160;
                    shootEffect = Fx.shootSmall;
                    smokeEffect = Fx.shootSmallSmoke;
                    hitSound = Vars.tree.loadSound("Hits/MetalHitRL");
                }},
                Items.thorium, new BasicBulletType(12f, 192){{
                    frontColor = Color.valueOf("e400ff");
                    backColor = Color.valueOf("640070");
                    width = 8f;
                    height = 20f;
                    ammoMultiplier = 5f;
                    lifetime = 160;
                    shootEffect = Fx.shootSmall;
                    smokeEffect = Fx.shootSmallSmoke;
                    hitSound = Vars.tree.loadSound("Hits/MetalHitRL");
                }}
            );

            shoot = new ShootAlternate(){{
                shots = 1;
                barrels = 2;
                spread = 5f;
            }};

            size = 3;
            reload = 5f;
            range = 296;
            health = 600;
            maxAmmo = 360;
            shootCone = 5f;
            inaccuracy = 2f;
            rotateSpeed = 12f;
            coolant = consumeCoolant(0.3f);
            targetGround = true;
            targetAir = true;
            shootSound = Vars.tree.loadSound("Turrets/PolskiMG");

            limitRange();
        }};

        schAirFactory = new UnitFactory("schAirFactory"){{
            requirements(Category.units, with(Items.copper, 50, Items.lead, 35));
            plans = Seq.with(
                new UnitPlan(schUnitTypes.RukhtuskaMKI, 60f * 5, with(Items.lead, 10, Items.graphite, 2)),
                new UnitPlan(schUnitTypes.HulletuseMKI, 60f * 4, with(Items.silicon, 4, Items.graphite, 2)),
                new UnitPlan(schUnitTypes.avmArmyTroop, 60f * 4, with(Items.lead, 4, Items.copper, 2))
            );
            size = 3;
            consumePower(1.5f);
            ambientSound = Vars.tree.loadSound("Factory/schAirFactory");
            health = 500;
        }};
        t2Reconstructor = new Reconstructor("t2Reconstructor"){{
            requirements(Category.units, with(Items.copper, 50, Items.lead, 35, Items.silicon, 15));

            size = 3;
            consumePower(1f);
            consumeItems(with(Items.titanium, 15));
            health = 500;
            ambientSound = Vars.tree.loadSound("Factory/schAirFactory");
            constructTime = 60f * 4f;

            upgrades.addAll(
                new UnitType[]{schUnitTypes.RukhtuskaMKI, schUnitTypes.RukhtuskaMKII},
                new UnitType[]{schUnitTypes.HulletuseMKI, schUnitTypes.HulletuseMKII}
            );
        }};
        t3Reconstructor = new Reconstructor("t3Reconstructor"){{
            requirements(Category.units, with(Items.copper, 50, Items.lead, 35, Items.silicon, 20));

            size = 3;
            consumePower(1f);
            consumeItems(with(Items.titanium, 50, Items.silicon, 25));
            health = 500;
            ambientSound = Vars.tree.loadSound("Factory/schAirFactory");
            constructTime = 60f * 4f;

            upgrades.addAll(
                new UnitType[]{schUnitTypes.RukhtuskaMKII, schUnitTypes.RukhtuskaMKIII},
                new UnitType[]{schUnitTypes.HulletuseMKII, schUnitTypes.HulletuseMKIII}
            );
        }};
        coalBurner = new ConsumeGenerator("coalBurner"){{
            requirements(Category.power, with(Items.copper, 30, Items.lead, 15, Items.graphite, 5));
            size = 2;
            itemDuration = 240f;
            hasLiquids = false;
            powerProduction = 1.5f;
            warmupSpeed = 0.005f;
            drawer = new DrawMulti(
                new DrawDefault(),
                new DrawWarmupRegion(),
                new DrawRegion("-rot"){{
                    rotateSpeed = 8f;
                }},
                new DrawRegion("-rot"){{
                    rotateSpeed = -8f;
                    rotation = 45f;
                }},
                new DrawRegion("-cap")
                );
            consume(new ConsumeItemFlammable());
            consume(new ConsumeItemExplode());
            ambientSound = Vars.tree.loadSound("Power/coalBurner");
            ambientSoundVolume = 0.1f;
        }};
        steamTurbine = new ConsumeGenerator("steamTurbine"){{
            requirements(Category.power, with(Items.copper, 40, Items.lead, 25, Items.graphite, 10));
            size = 3;
            itemDuration = 300f;
            hasLiquids = true;
            liquidCapacity = 180;
            powerProduction = 6.15f;
            warmupSpeed = 0.005f;
            drawer = new DrawMulti(new DrawDefault(), new DrawBlurSpin("-fan", 120f), new DrawRegion("-top"));
            consume(new ConsumeItemFlammable());
            consume(new ConsumeItemExplode());
            consumeLiquid(Liquids.water, 0.1f);
            ambientSound = Vars.tree.loadSound("Power/steamTurbine");
            ambientSoundVolume = 1f;
        }};
        fortCopperRot = new Wall("fortress-copper-rot"){{
            requirements(Category.defense, with(Items.copper, 36));
            size = 2;
            rotate = true;
            health = 1540;
        }};
        fortCopperCor = new Wall("fortress-copper-cor"){{
            requirements(Category.defense, with(Items.copper, 36));
            size = 2;
            rotate = true;
            health = 1540;
        }};
        fortCopperCorII = new Wall("fortress-copper-corii"){{
            requirements(Category.defense, with(Items.copper, 36));
            size = 2;
            rotate = true;
            health = 1540;
        }};
        fortCopperTurret = new PowerTurret("fortress-copper-turret"){{
            requirements(Category.defense, with(Items.copper, 36, Items.lead, 16));
            range = 240f;
            recoil = 2f;
            reload = 8f;
            shake = 2f;
            shootEffect = Fx.shootSmall;
            smokeEffect = Fx.shootBigSmoke2;
            heatColor = Color.red;
            size = 2;
            health = 1540;
            targetAir = true;
            shootSound = Vars.tree.loadSound("Turrets/PolskiLaser");
            coolant = consumeCoolant(0.1f);

            consumePower(0.5f);

            shootType = new LaserBulletType(140){{
                colors = new Color[]{Pal.lancerLaser.cpy().a(0.4f), Pal.lancerLaser, Color.white};
                //TODO merge
                chargeEffect = new MultiEffect(Fx.lancerLaserCharge, Fx.lancerLaserChargeBegin);

                buildingDamageMultiplier = 0.25f;
                hitEffect = Fx.hitLancer;
                hitSize = 4;
                lifetime = 8f;
                drawSize = 400f;
                collidesAir = true;
                length = 173f;
                ammoMultiplier = 1f;
                pierceCap = 4;
            }};
        }};
    };
};