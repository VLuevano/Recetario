package java.uv.mx.Recetario.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Recipe {
    private long id;
    private String title;
    private String description;
    private List<String> ingredients;
    private List<String> steps;
}
