package nav.springframework.springrecipe.bootstrap;

import lombok.extern.slf4j.Slf4j;
import nav.springframework.springrecipe.model.*;
import nav.springframework.springrecipe.repositories.RecipeRepository;
import nav.springframework.springrecipe.repositories.UnitOfMeasureRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Slf4j
@Component
public class DataLoader implements CommandLineRunner {

    private final RecipeRepository recipeRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;

    public DataLoader(RecipeRepository recipeRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.recipeRepository = recipeRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        log.debug("Initiating Loading of Data");
        Recipe spicyGrilledChickenTacos = new Recipe();
        spicyGrilledChickenTacos.setDescription("Spicy Grilled Chicken Tacos");
        spicyGrilledChickenTacos.setPrepTime(20);
        spicyGrilledChickenTacos.setCookTime(15);
        spicyGrilledChickenTacos.setServings(6);
        spicyGrilledChickenTacos.setSource("SimplyRecipes");
        spicyGrilledChickenTacos.setUrl("https://www.simplyrecipes.com/recipes/spicy_grilled_chicken_tacos/");
        spicyGrilledChickenTacos.setDirections("Prepare a gas or charcoal grill for medium-high, direct heat\n" +
                "Make the marinade and coat the chicken:\n" +
                "In a large bowl, stir together the chili powder, oregano, cumin, sugar, salt, garlic and orange zest. Stir in the orange juice and olive oil to make a loose paste. Add the chicken to the bowl and toss to coat all over.\n" +
                "\n" +
                "Set aside to marinate while the grill heats and you prepare the rest of the toppings.\n" +
                "\n" +
                "Spicy Grilled Chicken Tacos\n" +
                "Grill the chicken:\n" +
                "Grill the chicken for 3 to 4 minutes per side, or until a thermometer inserted into the thickest part of the meat registers 165F. Transfer to a plate and rest for 5 minutes.\n" +
                "\n" +
                "Warm the tortillas:\n" +
                "Place each tortilla on the grill or on a hot, dry skillet over medium-high heat. As soon as you see pockets of the air start to puff up in the tortilla, turn it with tongs and heat for a few seconds on the other side.\n" +
                "\n" +
                "Wrap warmed tortillas in a tea towel to keep them warm until serving.\n" +
                "\n" +
                "Assemble the tacos:\n" +
                "Slice the chicken into strips. On each tortilla, place a small handful of arugula. Top with chicken slices, sliced avocado, radishes, tomatoes, and onion slices. Drizzle with the thinned sour cream. Serve with lime wedges.");
        spicyGrilledChickenTacos.setDifficulty(Difficulty.MODERATE);

        spicyGrilledChickenTacos.addAllIngredients(List.of(new Ingredient[]{
                new Ingredient("Ancho Chilli Powder", bd(2), uom("Tablespoon")),
                new Ingredient("Dried Oregano", bd(1),uom("Teaspoon")),
                new Ingredient("Dried Cumin", bd(1), uom("Teaspoon")),
                new Ingredient("Sugar", bd(1), uom("Teaspoon")),
                new Ingredient("Salt", bd(0.5), uom("Teaspoon")),
                new Ingredient("Clove Finely Chopped Garlic", bd(1), null),
                new Ingredient("Finely Grated Orange Zest", bd(1), uom("Tablespoon")),
                new Ingredient("Fresh-Squeezed Orange Juice", bd(3), uom("Tablespoon")),
                new Ingredient("Olive Oil", bd(2), uom("Tablespoon")),
                new Ingredient("Skinless, Boneless Chicken Thighs", bd(6), null)
        }));

        Notes notes1 = new Notes();
        notes1.setRecipeNotes("Look for ancho chile powder with the Mexican ingredients at your grocery store, on buy it online. (If you can't find ancho chili powder, you replace the ancho chili, the oregano, and the cumin with 2 1/2 tablespoons regular chili powder, though the flavor won't be quite the same.)");
        spicyGrilledChickenTacos.setNotes(notes1);

        recipeRepository.save(spicyGrilledChickenTacos);
        log.debug("Saved Spicy Grilled Chicken Taco Recipe");

        Recipe bestGuacamole = new Recipe();
        bestGuacamole.setDescription("The Best Guacamole");
        bestGuacamole.setPrepTime(10);
        bestGuacamole.setCookTime(0);
        bestGuacamole.setServings(4);
        bestGuacamole.setSource("SimplyRecipes");
        bestGuacamole.setUrl("https://www.simplyrecipes.com/recipes/perfect_guacamole/");
        bestGuacamole.setDirections("Cut the avocado:\n" +
                "Cut the avocados in half. Remove the pit. Score the inside of the avocado with a blunt knife and scoop out the flesh with a spoon. (See How to Cut and Peel an Avocado.) Place in a bowl.\n" +
                "\n" +
                "How to make guacamole - scoring avocado\n" +
                "Mash the avocado flesh:\n" +
                "Using a fork, roughly mash the avocado. (Don't overdo it! The guacamole should be a little chunky.)\n" +
                "\n" +
                "How to make guacamole - smashing avocado with fork\n" +
                "Add the remaining ingredients to taste:\n" +
                "Sprinkle with salt and lime (or lemon) juice. The acid in the lime juice will provide some balance to the richness of the avocado and will help delay the avocados from turning brown.\n" +
                "\n" +
                "Add the chopped onion, cilantro, black pepper, and chilis. Chili peppers vary individually in their spiciness. So, start with a half of one chili pepper and add more to the guacamole to your desired degree of heat.\n" +
                "\n" +
                "Remember that much of this is done to taste because of the variability in the fresh ingredients. Start with this recipe and adjust to your taste.\n" +
                "\n" +
                "Serve immediately:\n" +
                "If making a few hours ahead, place plastic wrap on the surface of the guacamole and press down to cover it to prevent air reaching it. (The oxygen in the air causes oxidation which will turn the guacamole brown.)\n" +
                "\n" +
                "Garnish with slices of red radish or jigama strips. Serve with your choice of store-bought tortilla chips or make your own homemade tortilla chips.\n" +
                "\n" +
                "Refrigerate leftover guacamole up to 3 days.");
        bestGuacamole.setDifficulty(Difficulty.EASY);

        bestGuacamole.addAllIngredients(List.of(new Ingredient[]{
                new Ingredient("Ripe Avocados", bd(2), null),
                new Ingredient("Kosher Salt", bd(0.25), uom("Teaspoon")),
                new Ingredient("Fresh Lime or Lemon Juice", bd(1), uom("Tablespoon")),
                new Ingredient("Minced Red Onion or Thinly Sliced Green Onion", bd(4), uom("Tablespoon")),
                new Ingredient("Serrano (or Jalapeño) Chilis, stems and seeds removed, minced", bd(2), null),
                new Ingredient("Cilantro (Leaves and Tender Stems), Finely Chopped", bd(2), uom("Tablespoon")),
                new Ingredient("Freshly Grounded Black Pepper", bd(1), uom("Pinch")),
                new Ingredient("Ripe Tomato, Chopped (Optional)", bd(0.5), null),
                new Ingredient("Red radish or Jicama Slices for Garnish (Optional)",null, null)
        }));

        Notes notes2 = new Notes();
        notes2.setRecipeNotes("Be careful handling chilis! If using, it's best to wear food-safe gloves. If no gloves are available, wash your hands thoroughly after handling, and do not touch your eyes or the area near your eyes for several hours afterwards.");
        bestGuacamole.setNotes(notes2);

        recipeRepository.save(bestGuacamole);
        log.debug("Saved Guacamole Recipe");
        log.debug("Completed Data Loading");
    }

    private BigDecimal bd(int val) {
        return new BigDecimal(val);
    }

    private BigDecimal bd(double val) {
        return new BigDecimal(val);
    }

    private UnitOfMeasure uom(String description) {
        Optional<UnitOfMeasure> unitOfMeasureOptional = unitOfMeasureRepository.findByDescription(description);
        if (unitOfMeasureOptional.isEmpty()) throw new RuntimeException("Unit of Measure \"" +
                description + "\" Not Found!");
        log.debug("Successfully Retrieved Unit of Measurement " + description);
        return unitOfMeasureOptional.get();
    }
}
