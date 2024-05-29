package java.uv.mx.Recetario.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RecipeDTO {
    private long id;
    private String title;
    private String description;
    private List<String> ingredients;
    private List<String> steps;
}
