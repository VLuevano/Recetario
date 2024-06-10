package uv.mx.javc.Recetario.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import uv.mx.javc.Recetario.model.Recipe;

@Repository
public interface RecipeRepository extends MongoRepository<Recipe, String> {
}
