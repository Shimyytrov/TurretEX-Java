package SCH.content;

import arc.struct.*;
import mindustry.content.Planets;
import mindustry.content.TechTree;
import mindustry.game.Objectives.*;
import mindustry.type.ItemStack;

import static mindustry.content.Blocks.*;
import static SCH.content.schBlocks.*;
import static SCH.content.schUnitTypes.*;
import static mindustry.content.TechTree.*;
import static mindustry.content.UnitTypes.*;

public class schTechTree {
    public static void load(){
        nodeRoot("TurretEX", duo, false, () -> {
            node(flagSCH, () -> {
                node(KavtashkaMKI, () -> {
                    node(KavtashkaMKII, () -> {
                        node(KavtashkaMKIII, () -> {
                            node(KavtashkaMKIV);
                        });
                        node(Kalinka, () -> {
                            node(Katyusha, () -> {
                                node(KatyushaCHEAT);
                                node(Satan);
                            });
                        });
                    });
                    node(GoryMKI, () -> {
                        node(GoryMKII);
                    });
                });
            });
            node(flagPOL, () -> {
                node(Niedzwiedz, () -> {
                    node(NiedzwiedzA2);
                    node(Rozpierducha);
                });
            });
            node(flagDEU, () -> {
                node(SteinkaMKI, () -> {
                    node(SteinkaMKII, () -> {
                        node(SteinkaMKIII);
                    });
                });
            });
            node(schAirFactory);
            node(t2Reconstructor, () -> {
                node(t3Reconstructor);
            });
            node(RukhtuskaMKI, () -> {
                node(RukhtuskaMKII, () -> {
                    node(RukhtuskaMKIII);
                });
                node(HulletuseMKI, () -> {
                    node(HulletuseMKII, () -> {
                        node(HulletuseMKIII);
                    });
                });
            });
            node(coalBurner, () -> {
                node(steamTurbine);
            });
        });
    };
}