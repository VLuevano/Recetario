package uv.mx.javc.Recetario.controller;

import java.util.List;
import java.util.Optional;

import uv.mx.javc.Recetario.dto.CreateRecipeDTO;
import uv.mx.javc.Recetario.dto.RecipeDTO;
import uv.mx.javc.Recetario.service.RecipeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/recipes")
public class RecipeController {
    @Autowired
    private RecipeService recipeService;

    @GetMapping("/getRecipes")
    public List<RecipeDTO> getAll() {
        return recipeService.getAll();
    }

    @PostMapping("/addRecipe")
    public RecipeDTO save(@Valid @RequestBody CreateRecipeDTO data) {
        log.info("Ejecutando el guardado de una receta");
        log.info(data.toString());
        return recipeService.save(data);
    }

    @PutMapping("/updateRecipe/{id}")
    public Optional<RecipeDTO> update(@PathVariable long id, @Valid @RequestBody CreateRecipeDTO data) {
        log.info("Ejecutando la actualización de una receta con id: {}", id);
        log.info(data.toString());
        return recipeService.update(id, data);
    }

    @DeleteMapping("/deleteRecipe/{id}")
    public boolean delete(@PathVariable long id) {
        log.info("Ejecutando la eliminación de una receta con id: {}", id);
        return recipeService.delete(id);
    }
}
