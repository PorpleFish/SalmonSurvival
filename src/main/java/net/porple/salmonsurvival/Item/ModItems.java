package net.porple.salmonsurvival.Item;

import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TridentItem;
import net.porple.salmonsurvival.Item.custom.SalmonSlammer;
import net.porple.salmonsurvival.Item.custom.SalmoniteChiselItem;
import net.porple.salmonsurvival.SalmonSurvival;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.UnaryOperator;


public class ModItems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, SalmonSurvival.MOD_ID);

    public static final RegistryObject<Item> ALEXANDRITE = ITEMS.register("alexandrite",
            ()->new Item(new Item.Properties().setId(ITEMS.key("alexandrite"))
            ));

    public static final RegistryObject<Item> TOPAZ = ITEMS.register("topaz",
            ()->new Item(new Item.Properties().setId(ITEMS.key("topaz"))

));

    public static final RegistryObject<Item> SALMONITE_INGOT = ITEMS.register("salmonite_ingot",
            ()->new Item(new Item.Properties().setId(ITEMS.key("salmonite_ingot"))
            ));

    public static final RegistryObject<Item> SALMONITE_CHISEL = ITEMS.register("salmonite_chisel",
            ()->new SalmoniteChiselItem(new Item.Properties()
                    .setId(ITEMS.key("salmonite_chisel"))
                    .durability(32)
            ));

    public static final RegistryObject<Item> SALMON_SLAMMER = ITEMS.register(
            "salmon_slammer",
            ()-> new SalmonSlammer(new Item.Properties()
                    .rarity(Rarity.RARE)
                    .durability(250)
                    .attributes(TridentItem.createAttributes())
                    .component(DataComponents.TOOL, TridentItem.createToolProperties())
                    .enchantable(1)
                    .setId(ITEMS.key("salmon_slammer"))
            ));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
