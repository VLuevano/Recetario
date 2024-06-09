package uv.mx.javc.Recetario.mapper;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import uv.mx.javc.Recetario.dto.CreateRecipeDTO;
import uv.mx.javc.Recetario.dto.RecipeDTO;
import uv.mx.javc.Recetario.model.Recipe;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface RecipeMapper {
    // source: Recipe
    // target: RecipeDTO
    RecipeDTO toDTO(Recipe model);


    // source: CreateRecipeDTO -> el objeto de entrada
    // target: Recipe -> al objeto de salida
    // En el target se va a ignorar el atributo "id"
    @Mapping(target = "id", ignore = true)
    @Mapping(source = "description", target = "description" )
    Recipe toModel(CreateRecipeDTO dto);
}
