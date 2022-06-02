package nav.springframework.springrecipe.repositories;

import nav.springframework.springrecipe.model.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
