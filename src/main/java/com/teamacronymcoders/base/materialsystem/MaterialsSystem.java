package com.teamacronymcoders.base.materialsystem;

import com.teamacronymcoders.base.Base;
import com.teamacronymcoders.base.materialsystem.items.ItemMaterialPart;
import com.teamacronymcoders.base.materialsystem.materials.Material;
import com.teamacronymcoders.base.materialsystem.parts.Part;
import com.teamacronymcoders.base.materialsystem.parts.ProvidedParts;
import com.teamacronymcoders.base.registry.ItemRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.registry.IForgeRegistry;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MaterialsSystem {
    private static final Map<String, Part> PART_MAP = new HashMap<>();
    public static final IForgeRegistry<MaterialPart> MATERIAL_PARTS = GameRegistry.findRegistry(MaterialPart.class);
    public static final ItemMaterialPart ITEM_MATERIAL_PART = new ItemMaterialPart();

    public static void setup() {
        Base.instance.getRegistry(ItemRegistry.class, "ITEM").register(ITEM_MATERIAL_PART);
        ProvidedParts.init();
    }

    public static void registerPart(Part part) {
        PART_MAP.put(part.getUnlocalizedName(), part);
    }

    public static void registerPartsForMaterial(Material material, String... partNames) {
        Arrays.stream(partNames).forEach(partName -> MATERIAL_PARTS.register(new MaterialPart(material, PART_MAP.get(partName))));
    }
}