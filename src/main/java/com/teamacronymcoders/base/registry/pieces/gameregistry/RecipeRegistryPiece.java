package com.teamacronymcoders.base.registry.pieces.gameregistry;

import com.teamacronymcoders.base.items.IHasRecipe;
import com.teamacronymcoders.base.registry.pieces.RegistryPiece;
import com.teamacronymcoders.base.registry.pieces.RegistryPieceBase;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.ArrayList;

@RegistryPiece
public class RecipeRegistryPiece extends RegistryPieceBase<IHasRecipe> {
    public RecipeRegistryPiece() {
        super(IHasRecipe.class);
    }

    @Override
    public void init(ResourceLocation name, IHasRecipe entry) {
        entry.getRecipes(new ArrayList<>()).forEach(GameRegistry::addRecipe);
    }
}
