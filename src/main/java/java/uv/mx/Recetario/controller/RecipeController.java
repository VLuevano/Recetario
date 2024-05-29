package java.uv.mx.Recetario.controller;

import java.util.List;
import java.uv.mx.Recetario.dto.CreateRecipeDTO;
import java.uv.mx.Recetario.dto.RecipeDTO;
import java.uv.mx.Recetario.service.RecipeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class RecipeController {
    @Autowired
    private RecipeService recipeService;

    @RequestMapping("/obtenerProductos")
    public List<RecipeDTO> getAll() {
        return recipeService.getAll();
    }

    @RequestMapping("/crearProductos")
    public RecipeDTO save(@Valid @RequestBody CreateRecipeDTO data) {
        log.info("Ejcutando el guardado de un producto", data );
        log.info(data.toString());
        return recipeService.save(data);
    }
}
