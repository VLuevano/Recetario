package uv.mx.javc.Recetario.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RecipeDTO {
    private String id;
    private String title;
    private String description;
    private List<String> ingredients;
    private List<String> steps;
}
