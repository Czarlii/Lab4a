package uws.edu.ii.springlaby2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import uws.edu.ii.springlaby2.models.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}