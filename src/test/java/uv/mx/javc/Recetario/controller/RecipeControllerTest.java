package uv.mx.javc.Recetario.controller;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import uv.mx.javc.Recetario.dto.CreateRecipeDTO;
import uv.mx.javc.Recetario.dto.RecipeDTO;
import uv.mx.javc.Recetario.service.RecipeService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(MockitoExtension.class)
public class RecipeControllerTest {

    @Mock
    private RecipeService recipeService;

    @InjectMocks
    private RecipeController recipeController;

    @Test
    void testGetAll() {
        List<RecipeDTO> recipes = Arrays.asList(
            new RecipeDTO("1", "Receta 1", "Descripción", Arrays.asList("Ingrediente 1", "Ingrediente 2"), Arrays.asList("Paso 1", "Paso 2")),
            new RecipeDTO("2", "Receta 2", "Descripción", Arrays.asList("Ingrediente 1", "Ingrediente 2"), Arrays.asList("Paso 1", "Paso 2", "Paso 3"))
        );
        when(recipeService.getAll()).thenReturn(recipes);

        List<RecipeDTO> result = recipeController.getAll();
        assertEquals(2, result.size());
    }

    @Test
    void testSave() {
        CreateRecipeDTO data = new CreateRecipeDTO("Receta 1", "Descripción", Arrays.asList("Ingrediente 1", "Ingrediente 2"), Arrays.asList("Paso 1", "Paso 2"));

        RecipeDTO savedRecipe = new RecipeDTO("1", "Receta 1", " Descripción", Arrays.asList("Ingrediente 1", "Ingrediente 2"), Arrays.asList("Paso 1", "Paso 2"));
        when(recipeService.save(any(CreateRecipeDTO.class))).thenReturn(savedRecipe);

        RecipeDTO result = recipeController.save(data);
        assertEquals("Receta 1", result.getTitle());
    }

    @Test
    void testUpdate() {
        CreateRecipeDTO data = new CreateRecipeDTO("Receta 1", "Descripción", Arrays.asList("Ingrediente 1", "Ingrediente 2"), Arrays.asList("Paso 1", "Paso 2", "Paso 3"));

        RecipeDTO updatedRecipe = new RecipeDTO("1", "Receta 1", "Descripción nueva", Arrays.asList("Ingrediente 1", "Ingrediente 2"), Arrays.asList("Paso 1", "Paso 2", "Paso 3"));
        when(recipeService.update(anyString(), any(CreateRecipeDTO.class))).thenReturn(Optional.of(updatedRecipe));

        Optional<RecipeDTO> result = recipeController.update("1", data);
        assertEquals("Receta 1", result.get().getTitle());
    }

    @Test
    void testDelete() {
        when(recipeService.delete(anyString())).thenReturn(true);

        boolean result = recipeController.delete("1");
        assertEquals(true, result);
    }
}
