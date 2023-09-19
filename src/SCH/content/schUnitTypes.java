package SCH.content;

import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.math.*;
import arc.math.geom.*;
import arc.struct.*;
import arc.util.*;
import mindustry.Vars;
import mindustry.ai.*;
import mindustry.ai.types.*;
import mindustry.content.Fx;
import mindustry.entities.*;
import mindustry.entities.abilities.*;
import mindustry.entities.bullet.*;
import mindustry.entities.effect.*;
import mindustry.entities.part.*;
import mindustry.entities.pattern.*;
import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.type.*;
import mindustry.type.ammo.*;
import mindustry.type.unit.*;
import mindustry.type.weapons.*;
import mindustry.world.meta.*;

import static arc.graphics.g2d.Draw.*;
import static arc.graphics.g2d.Lines.*;
import static arc.math.Angles.*;
import static mindustry.Vars.*;
import static mindustry.content.Fx.*;

public class schUnitTypes {
    static {
        EntityMapping.nameMap.put("turretex-java-AVM-Army-Soldier", EntityMapping.idMap[4]);
    }
    public static UnitType
    RukhtuskaMKI, RukhtuskaMKII, RukhtuskaMKIII, HulletuseMKI, HulletuseMKII, HulletuseMKIII,
    
    avmArmyTroop;

    public static void load(){
        RukhtuskaMKI = new UnitType("RukhtuskaMKI"){{
            speed = 4f;
            accel = 0.05f;
            drag = 0.02f;
            flying = true;
            health = 360f;
            engineOffset = 6f;
            hitSize = 9f;
            itemCapacity = 50;
            targetAir = true;
            targetGround = true;
            faceTarget = true;
            circleTarget = true;
            targetFlags = new BlockFlag[]{BlockFlag.generator, BlockFlag.drill, null};
            weapons.add(new Weapon("RukhtustiskayaGewehrMKI"){{
                y = 0;
                x = 0;
                mirror = false;
                rotate = false;
                reload = 6;
                recoil = 2;
                ejectEffect = casing2;
                shake = 2;
                bullet = new BasicBulletType(12f, 24){{
                    width = 5f;
                    height = 24f;
                    lifetime = 15f;
                    shootEffect = Fx.shootSmall;
                    smokeEffect = shootSmallSmoke;
                    ammoMultiplier = 2;
                    frontColor = Color.valueOf("ff00ff");
                    backColor = Color.valueOf("52239f");
                    lightColor = Color.valueOf("ff0000");
                }};
                shootSound = Vars.tree.loadSound("Turrets/KavtashkaMKI");
            }});
            constructor = UnitEntity::create;
        }};
        RukhtuskaMKII = new UnitType("RukhtuskaMKII"){{
            speed = 5f;
            accel = 0.1f;
            drag = 0.02f;
            flying = true;
            health = 560f;
            engineOffset = 6f;
            hitSize = 9f;
            itemCapacity = 70;
            targetAir = true;
            targetGround = true;
            faceTarget = true;
            autoFindTarget = true;
            forceMultiTarget = true;
            circleTarget = true;
            rotateToBuilding = true;
            buildSpeed = 2f;
            defaultCommand = UnitCommand.rebuildCommand;
            targetFlags = new BlockFlag[]{BlockFlag.generator, BlockFlag.turret, null};
            weapons.add(new Weapon("RukhtustiskayaGewehrMKII"){{
                y = 0;
                x = 4;
                mirror = true;
                rotate = false;
                reload = 8;
                recoil = 8;
                ejectEffect = casing2;
                shake = 2;
                bullet = new BasicBulletType(16f, 36){{
                    width = 5f;
                    height = 48f;
                    lifetime = 12f;
                    shootEffect = Fx.shootSmall;
                    smokeEffect = shootSmallSmoke;
                    ammoMultiplier = 2;
                    frontColor = Color.valueOf("ffffff");
                    backColor = Color.valueOf("00ff00");
                    lightColor = Color.valueOf("00ff00");
                }};
                shootSound = Vars.tree.loadSound("Turrets/KavtashkaMKII");
            }});
            weapons.add(new Weapon("RukhtustiskayaArtylleryMKI"){{
                y = 0;
                x = 0;
                mirror = false;
                rotate = true;
                reload = 20;
                recoil = 2;
                ejectEffect = casing2;
                shake = 2;
                bullet = new ArtilleryBulletType(4.8f, 36){{
                    width = 12f;
                    height = 16f;
                    lifetime = 60f;
                    shootEffect = Fx.shootBig;
                    smokeEffect = shootBigSmoke;
                    ammoMultiplier = 2;
                }};
                shootSound = Vars.tree.loadSound("Turrets/AA-sg");
            }});
            constructor = UnitEntity::create;
        }};
        RukhtuskaMKIII = new UnitType("RukhtuskaMKIII"){{
            speed = 6f;
            accel = 0.1f;
            drag = 0.02f;
            flying = true;
            health = 1024f;
            engineOffset = 6f;
            hitSize = 10f;
            itemCapacity = 100;
            targetAir = true;
            targetGround = true;
            faceTarget = true;
            autoFindTarget = true;
            forceMultiTarget = true;
            circleTarget = true;
            rotateToBuilding = false;
            buildSpeed = 2.5f;
            defaultCommand = UnitCommand.rebuildCommand;
            targetFlags = new BlockFlag[]{BlockFlag.turret, BlockFlag.core, null};
            weapons.add(new Weapon("RukhtustiskayaGewehrMKIII"){{
                y = 0;
                x = 4;
                mirror = true;
                rotate = false;
                reload = 4;
                recoil = 8;
                ejectEffect = casing3;
                shake = 3;
                bullet = new BasicBulletType(24f, 48){{
                    width = 5f;
                    height = 48f;
                    lifetime = 12f;
                    shootEffect = Fx.shootSmall;
                    smokeEffect = shootSmallSmoke;
                    ammoMultiplier = 4;
                    frontColor = Color.valueOf("ffffff");
                    backColor = Color.valueOf("ff0000");
                    lightColor = Color.valueOf("ff0000");
                }};
                shootSound = Vars.tree.loadSound("Turrets/KavtashkaMKIII");
            }});
            weapons.add(new Weapon("RukhtustiskayaArtylleryMKII"){{
                y = 0;
                x = 0;
                mirror = false;
                rotate = true;
                reload = 30;
                recoil = 2;
                ejectEffect = casing2;
                shake = 3;
                bullet = new ArtilleryBulletType(6f, 48){{
                    width = 12f;
                    height = 16f;
                    lifetime = 48f;
                    shootEffect = Fx.shootBig;
                    smokeEffect = shootBigSmoke;
                    ammoMultiplier = 2;
                    fragBullets = 3;
                    fragBullet = new BasicBulletType(4f, 24){{
                        width = 24f;
                        height = 36f;
                        lifetime = 30f;
                        backColor = Color.violet;
                        frontColor = Color.cyan;
                        despawnEffect = Fx.explosion;
                        collidesGround = true;
                        fragBullets = 8;
                        fragBullet = new BasicBulletType(6f, 1){{
                            width = 12f;
                            height = 16f;
                            lifetime = 15f;
                            backColor = Color.scarlet;
                            frontColor = Color.red;
                            despawnEffect = Fx.flakExplosion;
                            collidesGround = true;
                        }};
                    }};
                }};
                shootSound = Vars.tree.loadSound("Turrets/AA-sg");
            }});
            constructor = UnitEntity::create;
        }};
        HulletuseMKI = new UnitType("HulletuseMKI"){{
            speed = 4f;
            mineTier = 3;
            accel = 0.05f;
            drag = 0.017f;
            flying = true;
            health = 360f;
            engineOffset = 6f;
            hitSize = 9f;
            itemCapacity = 50;
            targetAir = true;
            targetGround = true;
            faceTarget = true;
            circleTarget = false;
            rotateToBuilding = false;
            defaultCommand = UnitCommand.repairCommand;
            parts.addAll(
                new RegionPart(){{
                    outline = true;
                    layer = 91f;
                }},
                new RegionPart("-bottom"){{
                    outline = false;
                    layer = 90.5f;
                }}
            );
            weapons.add(new Weapon("HulletiskayaGewehrMKI"){{
                y = 0;
                x = 0;
                mirror = false;
                rotate = true;
                reload = 15;
                recoil = 2;
                ejectEffect = casing2;
                shake = 2;
                bullet = new BasicBulletType(5f, 24){{
                    width = 12f;
                    height = 24f;
                    lifetime = 45f;
                    shootEffect = Fx.shootSmall;
                    smokeEffect = shootSmallSmoke;
                    ammoMultiplier = 2;
                    frontColor = Color.valueOf("ffffff");
                    backColor = Color.valueOf("11ff11");
                    lightColor = Color.valueOf("00ff00");
                    collidesTeam = true;
                    healPercent = 5f;
                }};
                shootSound = Vars.tree.loadSound("Turrets/KavtashkaMKI");
            }});
            constructor = UnitEntity::create;
        }};
        HulletuseMKII = new UnitType("HulletuseMKII"){{
            speed = 4f;
            mineTier = 4;
            accel = 0.05f;
            drag = 0.017f;
            flying = true;
            health = 512f;
            engineOffset = 8f;
            hitSize = 9f;
            itemCapacity = 50;
            targetAir = true;
            targetGround = true;
            faceTarget = false;
            circleTarget = false;
            rotateToBuilding = false;
            buildSpeed = 5f;
            defaultCommand = UnitCommand.rebuildCommand;
            targetFlags = new BlockFlag[]{BlockFlag.drill, BlockFlag.turret, null};
            weapons.add(new Weapon("turretex-java-hulle-gun"){{
                y = -5;
                x = 5;
                mirror = true;
                rotate = true;
                reload = 5;
                recoil = 2;
                ejectEffect = casing2;
                shake = 2;
                bullet = new BasicBulletType(5f, 36){{
                    width = 11f;
                    height = 12f;
                    lifetime = 45f;
                    shootEffect = Fx.shootSmall;
                    smokeEffect = shootSmallSmoke;
                    ammoMultiplier = 2;
                    frontColor = Color.valueOf("ffffff");
                    backColor = Color.valueOf("11ff11");
                    lightColor = Color.valueOf("00ff00");
                    collidesTeam = false;
                }};
                shootSound = Vars.tree.loadSound("Turrets/KavtashkaMKI");
            }});
            weapons.add(new Weapon("turretex-java-hulle-missile"){{
                y = 4;
                x = 5;
                mirror = true;
                rotate = true;
                reload = 30;
                recoil = 2;
                ejectEffect = casing2;
                shake = 2;
                bullet = new MissileBulletType(5f, 33){{
                    width = 6f;
                    height = 12f;
                    lifetime = 60f;
                    shootEffect = Fx.shootSmall;
                    smokeEffect = shootSmallSmoke;
                    ammoMultiplier = 2;
                    frontColor = Color.valueOf("ffffff");
                    backColor = Color.valueOf("cc11ff");
                    lightColor = Color.valueOf("0000ff");
                    homingRange = 80f;
                    homingPower = 0.5f;
                    splashDamageRadius = 36f;
                    splashDamage = 48f;
                    collidesTeam = false;
                    hitEffect = Fx.blastExplosion;
                    despawnEffect = Fx.blastExplosion;
                }};
                shootSound = Vars.tree.loadSound("Turrets/laser");
            }});
            constructor = UnitEntity::create;
        }};
        HulletuseMKIII = new UnitType("HulletuseMKIII"){{
            speed = 2f;
            rotateSpeed = 1.9f;
            mineTier = 5;
            mineSpeed = 5f;
            accel = 0.04f;
            drag = 0.04f;
            flying = true;
            lowAltitude = true;
            health = 4500f;
            armor = 64f;
            engineOffset = 21;
            engineSize = 5.3f;
            hitSize = 46f;
            itemCapacity = 100;
            targetAir = true;
            targetGround = true;
            faceTarget = false;
            circleTarget = false;
            rotateToBuilding = false;
            buildSpeed = 4f;
            defaultCommand = UnitCommand.rebuildCommand;
            targetFlags = new BlockFlag[]{BlockFlag.drill, BlockFlag.turret, null};

            BulletType basic = new BasicBulletType(5f, 32){{
                width = 6f;
                height = 16f;
                lifetime = 60f;
                shootEffect = Fx.shootSmall;
                smokeEffect = shootSmallSmoke;
                ammoMultiplier = 2;
                frontColor = Color.valueOf("ffffff");
                backColor = Color.valueOf("11ff11");
                lightColor = Color.valueOf("00ff00");
                collidesTeam = false;
            }};
            BulletType minigun = new BasicBulletType(8f, 8){{
                width = 6f;
                height = 18f;
                lifetime = 45f;
                shootEffect = Fx.shootSmall;
                smokeEffect = shootSmallSmoke;
                ammoMultiplier = 5;
                frontColor = Color.valueOf("ffffff");
                backColor = Color.valueOf("ff0000");
                lightColor = Color.valueOf("ff0000");
                collidesTeam = false;
            }};
            BulletType missiles = new MissileBulletType(5f, 64){{
                width = 6f;
                height = 12f;
                lifetime = 60f;
                shootEffect = Fx.shootSmall;
                smokeEffect = shootSmallSmoke;
                ammoMultiplier = 2;
                frontColor = Color.valueOf("ffffff");
                backColor = Color.valueOf("cc11ff");
                lightColor = Color.valueOf("0000ff");
                homingRange = 80f;
                homingPower = 0.5f;
                splashDamageRadius = 36f;
                splashDamage = 12f;
                collidesTeam = false;
                hitEffect = Fx.blastExplosion;
                despawnEffect = Fx.blastExplosion;
            }};

            weapons.add(new Weapon("turretex-java-hulle-gun"){{
                y = -12f;
                x = 8f;
                mirror = true;
                rotate = true;
                reload = 6;
                recoil = 2;
                ejectEffect = casing1;
                shake = 2;
                bullet = basic;
                shootSound = Vars.tree.loadSound("Turrets/AA-sg");
            }});
            weapons.add(new Weapon("turretex-java-hulle-gun"){{
                y = 12f;
                x = 8f;
                mirror = true;
                rotate = true;
                reload = 6;
                recoil = 2;
                ejectEffect = casing1;
                shake = 2;
                bullet = basic;
                shootSound = Vars.tree.loadSound("Turrets/AA-sg");
            }});
            weapons.add(new Weapon("turretex-java-hulle-gun"){{
                y = 0f;
                x = 12f;
                mirror = true;
                rotate = true;
                reload = 1;
                recoil = 2;
                ejectEffect = casing1;
                shake = 2;
                bullet = minigun;
                shootSound = Vars.tree.loadSound("Turrets/AA-sg");
            }});
            weapons.add(new Weapon("turretex-java-hulle-missile"){{
                y = 4;
                x = 4;
                mirror = true;
                rotate = true;
                reload = 15;
                recoil = 2;
                ejectEffect = casing2;
                shake = 2;
                bullet = missiles;
                shootSound = Vars.tree.loadSound("Turrets/SteinMKIII");
            }});
            weapons.add(new Weapon("turretex-java-hulle-missile"){{
                y = -4;
                x = 4;
                mirror = true;
                rotate = true;
                reload = 15;
                recoil = 2;
                ejectEffect = casing2;
                shake = 2;
                bullet = missiles;
                shootSound = Vars.tree.loadSound("Turrets/SteinMKI");
            }});
            weapons.add(new Weapon("turretex-java-hulle-missile"){{
                y = 0;
                x = 6;
                mirror = true;
                rotate = true;
                reload = 6;
                recoil = 2;
                ejectEffect = casing2;
                shake = 2;
                bullet = missiles;
                shootSound = Vars.tree.loadSound("Turrets/SteinMKII");
            }});
            constructor = UnitEntity::create;
        }};
        avmArmyTroop = new UnitType("AVM-Army-Soldier"){{
            speed = 0.8f;
            hitSize = 9f;
            health = 250;
            weapons.add(new Weapon("ak"){{
                reload = 8f;
                x = 4f;
                y = 2f;
                top = false;
                rotate = false;
                mirror = false;
                ejectEffect = Fx.casing1;
                shootSound = Vars.tree.loadSound("Turrets/ak12");
                bullet = new BasicBulletType(12f, 36){{
                    width = 4f;
                    height = 12f;
                    lifetime = 15f;
                }};
            }});
        }};
    };
};