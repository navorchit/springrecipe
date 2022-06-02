package nav.springframework.springrecipe.repositories;

import nav.springframework.springrecipe.model.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}
