package uv.mx.javc.Recetario.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uv.mx.javc.Recetario.dto.CreateRecipeDTO;
import uv.mx.javc.Recetario.dto.RecipeDTO;
import uv.mx.javc.Recetario.mapper.RecipeMapper;
import uv.mx.javc.Recetario.model.Recipe;
import uv.mx.javc.Recetario.repository.RecipeRepository;

@Service
public class RecipeService {

    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private RecipeMapper recipeMapper;

    public List<RecipeDTO> getAll() {
        List<Recipe> recipes = recipeRepository.findAll();
        return recipes.stream()
                      .map(recipeMapper::toDTO)
                      .collect(Collectors.toList());
    }

    public RecipeDTO save(CreateRecipeDTO data) {
        Recipe model = recipeMapper.toModel(data);
        Recipe savedRecipe = recipeRepository.save(model);
        return recipeMapper.toDTO(savedRecipe);
    }

    public Optional<RecipeDTO> update(String id, CreateRecipeDTO data) {
        return recipeRepository.findById(id).map(existingRecipe -> {
            recipeMapper.updateRecipeFromDto(data, existingRecipe);
            Recipe updatedRecipe = recipeRepository.save(existingRecipe);
            return recipeMapper.toDTO(updatedRecipe);
        });
    }

    public boolean delete(String id) {
        if (recipeRepository.existsById(id)) {
            recipeRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
