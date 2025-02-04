package uws.edu.ii.springlaby2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import uws.edu.ii.springlaby2.models.Recipe;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
}