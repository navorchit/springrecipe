package nav.springframework.springrecipe.services;

import nav.springframework.springrecipe.commands.IngredientCommand;
import nav.springframework.springrecipe.converters.IngredientToIngredientCommand;
import nav.springframework.springrecipe.model.Ingredient;
import nav.springframework.springrecipe.model.Recipe;
import nav.springframework.springrecipe.repositories.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class IngredientServiceImpl implements IngredientService {

    private final IngredientToIngredientCommand ingredientToIngredientCommand;
    private final RecipeRepository recipeRepository;

    public IngredientServiceImpl(IngredientToIngredientCommand ingredientToIngredientCommand, RecipeRepository recipeRepository) {
        this.ingredientToIngredientCommand = ingredientToIngredientCommand;
        this.recipeRepository = recipeRepository;
    }

    public IngredientCommand findByRecipeIdAndIngredientId(Long recipeId, Long ingredientId) {
        Optional<Recipe> recipeOptional = recipeRepository.findById(recipeId);

        if (recipeOptional.isEmpty()) {
            // todo implement error handling
        }

        Recipe recipe = recipeOptional.get();

        Set<Ingredient> ingredients = recipe.getIngredients();
        Optional<IngredientCommand> ingredientCommandOptional = ingredients.stream()
                .peek(ingredient -> System.out.println(ingredient))
                .filter(ingredient -> ingredient.getId().equals(ingredientId))
                .peek(ingredient -> System.out.println(ingredient))
                .map(ingredient -> ingredientToIngredientCommand.convert(ingredient))
                .peek(ingredient -> System.out.println(ingredient))
                .findFirst();

        if (ingredientCommandOptional.isEmpty()) {
            // todo implement error handling
        }

        return ingredientCommandOptional.get();
    }
}
