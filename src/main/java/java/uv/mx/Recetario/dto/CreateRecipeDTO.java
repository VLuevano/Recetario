package java.uv.mx.Recetario.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
/*
 * @Data es la unión de:
 * @Getter
 * @Setter
 * @ToString
 * @EqualsAndHashCode
 */

@Data
public class CreateRecipeDTO {
    @NotBlank(message = "El título de la receta es obligatorio")
    private String title;

    @NotBlank(message = "La descripción de la receta es obligatorio")
    private String description;
}
