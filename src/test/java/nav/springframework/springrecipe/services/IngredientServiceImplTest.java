package nav.springframework.springrecipe.services;

import nav.springframework.springrecipe.commands.IngredientCommand;
import nav.springframework.springrecipe.converters.IngredientCommandToIngredient;
import nav.springframework.springrecipe.converters.IngredientToIngredientCommand;
import nav.springframework.springrecipe.converters.UnitOfMeasureCommandToUnitOfMeasure;
import nav.springframework.springrecipe.converters.UnitOfMeasureToUnitOfMeasureCommand;
import nav.springframework.springrecipe.model.Ingredient;
import nav.springframework.springrecipe.model.Recipe;
import nav.springframework.springrecipe.repositories.RecipeRepository;
import nav.springframework.springrecipe.repositories.UnitOfMeasureRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class IngredientServiceImplTest {

    @Spy
    IngredientToIngredientCommand ingredientToIngredientCommand = new IngredientToIngredientCommand(
            new UnitOfMeasureToUnitOfMeasureCommand()
    );
    @Spy
    IngredientCommandToIngredient ingredientCommandToIngredient = new IngredientCommandToIngredient(
            new UnitOfMeasureCommandToUnitOfMeasure()
    );

    @Mock
    RecipeRepository recipeRepository;
    @Mock
    UnitOfMeasureRepository unitOfMeasureRepository;

    @InjectMocks
    IngredientServiceImpl ingredientService;

    @Test
    void findByRecipeIdAndIngredientId() {
        Recipe recipe = new Recipe();
        recipe.setId(1L);

        Ingredient ingredient1 = new Ingredient();
        ingredient1.setId(1L);

        Ingredient ingredient2 = new Ingredient();
        ingredient2.setId(2L);

        Ingredient ingredient3 = new Ingredient();
        ingredient3.setId(3L);

        recipe.addIngredient(ingredient1);
        recipe.addIngredient(ingredient2);
        recipe.addIngredient(ingredient3);
        Optional<Recipe> recipeOptional = Optional.of(recipe);

        when(recipeRepository.findById(anyLong())).thenReturn(recipeOptional);

        IngredientCommand ingredientCommand = ingredientService.findByRecipeIdAndIngredientId(1L, 3L);

        assertNotNull(ingredientCommand);
        assertEquals(3L, ingredientCommand.getId());
        assertEquals(1L, ingredientCommand.getRecipeId());
        verify(recipeRepository, times(1)).findById(anyLong());
    }

    @Test
    void saveRecipeCommand() {
        IngredientCommand ingredientCommand = new IngredientCommand();
        ingredientCommand.setId(3L);
        ingredientCommand.setRecipeId(2L);

        Optional<Recipe> recipeOptional = Optional.of(new Recipe());

        Recipe savedRecipe = new Recipe();
        savedRecipe.addIngredient(new Ingredient());
        savedRecipe.getIngredients().iterator().next().setId(3L);

        when(recipeRepository.findById(anyLong())).thenReturn(recipeOptional);
        when(recipeRepository.save(any())).thenReturn(savedRecipe);

        IngredientCommand savedCommand = ingredientService.saveIngredientCommand(ingredientCommand);

        assertNotNull(savedCommand);
        assertEquals(Long.valueOf(3L), savedCommand.getId());
        verify(recipeRepository, times(1)).findById(anyLong());
        verify(recipeRepository, times(1)).save(any(Recipe.class));

    }
}