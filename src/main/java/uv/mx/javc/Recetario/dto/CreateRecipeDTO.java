package uv.mx.javc.Recetario.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.util.List;

@Data
public class CreateRecipeDTO {

    @NotNull
    @NotBlank(message = "El título de la receta es obligatorio")
    private String title;

    @NotNull
    @NotBlank(message = "La descripción de la receta es obligatorio")
    private String description;

    @NotEmpty(message = "La lista de ingredientes no puede estar vacía")
    private List<@NotBlank(message = "El ingrediente no puede estar en blanco") String> ingredients;

    @NotEmpty(message = "La lista de pasos no puede estar vacía")
    private List<@NotBlank(message = "El paso no puede estar en blanco") String> steps;
}
