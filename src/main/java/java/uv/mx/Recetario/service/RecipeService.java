package java.uv.mx.Recetario.service;

import java.util.LinkedList;
import java.util.List;
import java.uv.mx.Recetario.dto.CreateRecipeDTO;
import java.uv.mx.Recetario.dto.RecipeDTO;
import java.uv.mx.Recetario.mapper.RecipeMapper;
import java.uv.mx.Recetario.model.Recipe;
import java.uv.mx.Recetario.repository.RecipeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecipeService {
    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private RecipeMapper recipeMapper;


    public List<RecipeDTO> getAll() {
        List<Recipe> recipes = recipeRepository.getAll();
        List<RecipeDTO> data = new LinkedList<>();

        for (Recipe recipe : recipes) {
            data.add(recipeMapper.toDTO(recipe));
        }
        return data;
    }

    public RecipeDTO save(CreateRecipeDTO data) {
        Recipe model = recipeMapper.toModel(data);
        return recipeMapper.toDTO(recipeRepository.save(model));

    }
}
