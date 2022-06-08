package nav.springframework.springrecipe.services;

import nav.springframework.springrecipe.commands.UnitOfMeasureCommand;
import nav.springframework.springrecipe.converters.IngredientCommandToIngredient;
import nav.springframework.springrecipe.converters.IngredientToIngredientCommand;
import nav.springframework.springrecipe.repositories.RecipeRepository;
import nav.springframework.springrecipe.repositories.UnitOfMeasureRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ImageServiceImpl implements ImageService {

    @Override
    public void saveImageFile(Long recipeId, MultipartFile file) {

    }
}
