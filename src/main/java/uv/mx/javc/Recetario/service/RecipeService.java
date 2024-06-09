package uv.mx.javc.Recetario.service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import uv.mx.javc.Recetario.dto.CreateRecipeDTO;
import uv.mx.javc.Recetario.dto.RecipeDTO;
import uv.mx.javc.Recetario.mapper.RecipeMapper;
import uv.mx.javc.Recetario.model.Recipe;
import uv.mx.javc.Recetario.repository.RecipeRepository;

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

    public Optional<RecipeDTO> update(long id, CreateRecipeDTO data) {
        Recipe model = recipeMapper.toModel(data);
        return recipeRepository.update(id, model)
                .map(recipeMapper::toDTO);
    }

    public boolean delete(long id) {
        return recipeRepository.delete(id);
    }
}
