package com.teamacronymcoders.base;

import com.teamacronymcoders.base.entities.dataserializers.BaseDataSerializers;
import com.teamacronymcoders.base.materialsystem.MaterialSystem;
import com.teamacronymcoders.base.proxies.ModCommonProxy;
import com.teamacronymcoders.base.util.LanguageHelper;
import com.teamacronymcoders.base.util.OreDictUtils;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import static com.teamacronymcoders.base.Reference.*;

@Mod(modid = MODID, name = NAME, version = VERSION, dependencies = DEPENDENCIES)
public class Base extends BaseModFoundation<Base> {
    public static final LanguageHelper languageHelper = new LanguageHelper(MODID);

    static {
        FluidRegistry.enableUniversalBucket();
    }

    @Instance(MODID)
    public static Base instance;

    @SidedProxy(clientSide = "com.teamacronymcoders.base.proxies.ModClientProxy", serverSide = "com.teamacronymcoders.base.proxies.ModCommonProxy")
    public static ModCommonProxy proxy;

    public Base() {
        super(MODID, NAME, VERSION, CreativeTabs.MISC);
    }

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        super.preInit(event);
        OreDictUtils.setup();
        BaseDataSerializers.registerSerializers();
        Capabilities.register();
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        super.init(event);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        super.postInit(event);
    }

    public void setCreativeTab(CreativeTabs creativeTab) {
        this.creativeTab = creativeTab;
    }

    @Override
    public Base getInstance() {
        return instance;
    }
}
