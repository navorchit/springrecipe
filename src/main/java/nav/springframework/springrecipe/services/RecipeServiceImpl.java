package nav.springframework.springrecipe.services;

import lombok.extern.slf4j.Slf4j;
import nav.springframework.springrecipe.commands.RecipeCommand;
import nav.springframework.springrecipe.converters.RecipeCommandToRecipe;
import nav.springframework.springrecipe.converters.RecipeToRecipeCommand;
import nav.springframework.springrecipe.model.Recipe;
import nav.springframework.springrecipe.repositories.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Slf4j
@Service
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;
    private final RecipeCommandToRecipe recipeCommandToRecipe;
    private final RecipeToRecipeCommand recipeToRecipeCommand;

    public RecipeServiceImpl(RecipeRepository recipeRepository, RecipeCommandToRecipe recipeCommandToRecipe, RecipeToRecipeCommand recipeToRecipeCommand) {
        this.recipeRepository = recipeRepository;
        this.recipeCommandToRecipe = recipeCommandToRecipe;
        this.recipeToRecipeCommand = recipeToRecipeCommand;
    }

    @Override
    public Set<Recipe> getRecipes() {
        log.debug("Retrieving All Recipes");
        Set<Recipe> recipes = new HashSet<>();
        recipeRepository.findAll().forEach(recipes::add);
        return recipes;
    }

    @Override
    public Recipe findById(Long id) {
        log.debug("Retrieving Recipe with ID " + id);
        return recipeRepository.findById(id).orElse(null);
    }

    @Override
    public RecipeCommand saveRecipeCommand(RecipeCommand command) {
        Recipe detachedRecipe = recipeCommandToRecipe.convert(command);
        Recipe savedRecipe = recipeRepository.save(Objects.requireNonNull(detachedRecipe));
        log.debug("Saved Recipe with ID " + savedRecipe.getId());
        return recipeToRecipeCommand.convert(savedRecipe);
    }
}
