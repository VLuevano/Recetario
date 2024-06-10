package uv.mx.javc.Recetario.mapper;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import uv.mx.javc.Recetario.dto.CreateRecipeDTO;
import uv.mx.javc.Recetario.dto.RecipeDTO;
import uv.mx.javc.Recetario.model.Recipe;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface RecipeMapper {

    RecipeDTO toDTO(Recipe model);

    @Mapping(target = "id", ignore = true)
    @Mapping(source = "description", target = "description")
    Recipe toModel(CreateRecipeDTO dto);

    @Mapping(target = "id", ignore = true)
    void updateRecipeFromDto(CreateRecipeDTO dto, @MappingTarget Recipe entity);
}
