package nav.springframework.springrecipe.services;

import nav.springframework.springrecipe.commands.IngredientCommand;
import org.springframework.transaction.annotation.Transactional;

public interface IngredientService {

    IngredientCommand findByRecipeIdAndIngredientId(Long recipeId, Long ingredientId);

    IngredientCommand saveIngredientCommand(IngredientCommand command);
}
