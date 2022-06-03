package nav.springframework.springrecipe.controllers;

import lombok.extern.slf4j.Slf4j;
import nav.springframework.springrecipe.services.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
public class IndexController {

    private final RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"", "/", "/index"})
    public String getIndexPage(Model model) {
        log.debug("Acessing Index Page");
        model.addAttribute("recipes", recipeService.getRecipes());
        return "index";
    }

}
