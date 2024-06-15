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
        // Simulamos el comportamiento del servicio
        List<RecipeDTO> recipes = Arrays.asList(
            new RecipeDTO("1", "Tarta de Manzana", "Deliciosa tarta de manzana", Arrays.asList("manzanas", "harina"), Arrays.asList("Paso 1", "Paso 2")),
            new RecipeDTO("2", "Ensalada César", "Clásica ensalada César", Arrays.asList("lechuga", "pollo"), Arrays.asList("Paso 1", "Paso 2", "Paso 3"))
        );
        when(recipeService.getAll()).thenReturn(recipes);

        // Llamamos al método del controlador y verificamos el resultado
        List<RecipeDTO> result = recipeController.getAll();
        assertEquals(2, result.size());
    }

    @Test
    void testSave() {
        // Datos de prueba para la receta
        CreateRecipeDTO data = new CreateRecipeDTO("Paella", "Deliciosa paella", Arrays.asList("arroz", "pollo"), Arrays.asList("Paso 1", "Paso 2"));

        // Simulamos el comportamiento del servicio
        RecipeDTO savedRecipe = new RecipeDTO("1", "Paella", "Deliciosa paella", Arrays.asList("arroz", "pollo"), Arrays.asList("Paso 1", "Paso 2"));
        when(recipeService.save(any(CreateRecipeDTO.class))).thenReturn(savedRecipe);

        // Llamamos al método del controlador y verificamos el resultado
        RecipeDTO result = recipeController.save(data);
        assertEquals("Paella", result.getTitle());
    }

    @Test
    void testUpdate() {
        // Datos de prueba para la receta
        CreateRecipeDTO data = new CreateRecipeDTO("Paella Valenciana", "Receta actualizada de paella", Arrays.asList("arroz", "pollo"), Arrays.asList("Paso 1", "Paso 2", "Paso 3"));

        // Simulamos el comportamiento del servicio
        RecipeDTO updatedRecipe = new RecipeDTO("1", "Paella Valenciana", "Receta actualizada de paella", Arrays.asList("arroz", "pollo"), Arrays.asList("Paso 1", "Paso 2", "Paso 3"));
        when(recipeService.update(anyString(), any(CreateRecipeDTO.class))).thenReturn(Optional.of(updatedRecipe));

        // Llamamos al método del controlador y verificamos el resultado
        Optional<RecipeDTO> result = recipeController.update("1", data);
        assertEquals("Paella Valenciana", result.get().getTitle());
    }

    @Test
    void testDelete() {
        // Simulamos el comportamiento del servicio
        when(recipeService.delete(anyString())).thenReturn(true);

        // Llamamos al método del controlador y verificamos el resultado
        boolean result = recipeController.delete("1");
        assertEquals(true, result);
    }
}
