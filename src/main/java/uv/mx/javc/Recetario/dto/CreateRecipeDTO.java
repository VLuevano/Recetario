package uv.mx.javc.Recetario.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.util.List;

/*
 * @Data es la unión de:
 * @Getter
 * @Setter
 * @ToString
 * @EqualsAndHashCode
 */

@Data
public class CreateRecipeDTO {

    @NotNull
    @NotBlank(message = "El título de la receta es obligatorio")
    private String title;

    @NotNull
    @NotBlank(message = "La descripción de la receta es obligatorio")
    private String description;

    @NotNull
    @NotBlank(message = "Los ingredientes de la receta son obligatorios")
    private List<String> ingredients;
    
    @NotNull
    @NotBlank(message = "Los pasos de la receta son obligatorios")
    private List<String> steps;
}
