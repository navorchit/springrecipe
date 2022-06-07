package nav.springframework.springrecipe.services;

import nav.springframework.springrecipe.commands.IngredientCommand;

public interface IngredientService {

    IngredientCommand findByRecipeIdAndIngredientId(Long recipeId, Long ingredientId);
}
