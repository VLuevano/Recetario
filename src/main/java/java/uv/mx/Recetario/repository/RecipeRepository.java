package java.uv.mx.Recetario.repository;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.uv.mx.Recetario.model.Recipe;

import org.springframework.stereotype.Repository;

@Repository
public class RecipeRepository {
    private long currentId;
    private List<Recipe> recipes;

    public RecipeRepository() {
        currentId = 1;
        recipes = new LinkedList<>();
    }

    public Recipe save(Recipe data) {
        data.setId(currentId);
        recipes.add(data);
        return data;
    }

    public List<Recipe> getAll() {
        return recipes;
    }

    public Optional<Recipe> getById(long id) {

        for (Recipe recipe : recipes) {
            if (recipe.getId() == id) {
                return Optional.of(recipe);
            }
        }
        return Optional.empty();
    }

    public void update(long id, Recipe data) {
        Optional<Recipe> entry = getById(id);

        if (!entry.isPresent()) {
            return;
        }

        Recipe recipe = entry.get();

        if (data.getTitle() != null) {
            recipe.setTitle(data.getTitle());
        }

        if (data.getDescription() != null) {
            recipe.setDescription(data.getDescription());
        }

        if (data.getIngredients() != null) {
            recipe.setIngredients(data.getIngredients());
        }

        if (data.getSteps() != null) {
            recipe.setSteps(data.getSteps());
        }

    }
}
