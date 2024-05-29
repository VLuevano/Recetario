package java.uv.mx.Recetario.mapper;

import org.mapstruct.Mapping;

import java.uv.mx.Recetario.dto.CreateRecipeDTO;
import java.uv.mx.Recetario.dto.RecipeDTO;
import java.uv.mx.Recetario.model.Recipe;

public interface RecipeMapper {
    // source: Recipe
    // target: RecipeDTO
    RecipeDTO toDTO(Recipe model);


    // source: CreateRecipeDTO -> el objeto de entrada
    // target: Recipe -> al objeto de salida
    // En el target se va a ignorar el atributo "id"
    @Mapping(target = "id", ignore = true)
    @Mapping(source = "definition", target = "description" )
    Recipe toModel(CreateRecipeDTO dto);
}
