package nav.springframework.springrecipe.services;

import nav.springframework.springrecipe.model.Recipe;

import java.util.Set;

public interface RecipeService {

    Set<Recipe> getRecipes();

    Recipe findById(Long id);
}
