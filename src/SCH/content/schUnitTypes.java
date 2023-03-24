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
    public static UnitType RukhtuskaMKI, RukhtuskaMKII, RukhtuskaMKIII, HulletuseMKI, HulletuseMKII;

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
            health = 440f;
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
            buildRange = 256f;
            defaultCommand = UnitCommand.rebuildCommand;
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
            health = 512f;
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
            buildRange = 360f;
            defaultCommand = UnitCommand.rebuildCommand;
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
                    fragBullet = new BasicBulletType(8f, 24){{
                        width = 24f;
                        height = 36f;
                        shrinkY = 1f;
                        lifetime = 30f;
                        backColor = Color.violet;
                        frontColor = Color.cyan;
                        despawnEffect = Fx.explosion;
                        collidesGround = true;
                        fragBullets = 8;
                        fragBullet = new BasicBulletType(3f, 24){{
                            width = 12f;
                            height = 16f;
                            shrinkY = 1f;
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
    }
};
