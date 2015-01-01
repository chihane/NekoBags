package mlxy.nekobags;

import mlxy.nekobags.constant.Constants;
import mlxy.nekobags.item.ModItems;
import mlxy.nekobags.proxy.CommonProxy;
import mlxy.nekobags.recipe.ModRecipes;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;

@Mod(modid=Constants.MOD_ID, name=Constants.MOD_NAME, version=Constants.MOD_VERSION)
public class NekoBags {
	@Mod.Instance(Constants.MOD_ID)
	public static NekoBags instance;
	
	@SidedProxy(clientSide = "mlxy.nekobags.proxy.ClientProxy", serverSide = "mlxy.nekobags.proxy.CommonProxy")
	public static CommonProxy proxy;

	public static final int GUI_ID_KURONEKO = 2333;
	
	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		ModItems.init();
		ModRecipes.init();
	}
	
	@Mod.EventHandler
	public void init(FMLInitializationEvent event) {
		proxy.registerRenderers();
		NetworkRegistry.INSTANCE.registerGuiHandler(this, new CommonProxy());
	}
	
	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		
	}
}
