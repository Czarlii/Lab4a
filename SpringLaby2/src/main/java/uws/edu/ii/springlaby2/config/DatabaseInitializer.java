package uws.edu.ii.springlaby2.config;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import uws.edu.ii.springlaby2.models.Category;
import uws.edu.ii.springlaby2.models.Recipe;
import uws.edu.ii.springlaby2.repositories.CategoryRepository;
import uws.edu.ii.springlaby2.repositories.RecipeRepository;

import java.time.LocalDate;

@Configuration
public class DatabaseInitializer {

    @Bean
    public InitializingBean init(CategoryRepository categoryRepository, RecipeRepository recipeRepository) {
        return () -> {
            if (categoryRepository.count() == 0) {
                Category danieGlowne = new Category();
                danieGlowne.setName("Danie główne");
                danieGlowne = categoryRepository.save(danieGlowne);

                Category deser = new Category();
                deser.setName("Deser");
                deser = categoryRepository.save(deser);

                Category przekaska = new Category();
                przekaska.setName("Przekąska");
                przekaska = categoryRepository.save(przekaska);

                Recipe spaghetti = new Recipe();
                spaghetti.setName("Spaghetti Carbonara");
                spaghetti.setAuthor("Marek");
                spaghetti.setDifficulty(5.00f);
                spaghetti.setReleaseDate(LocalDate.of(2022, 10, 10));
                spaghetti.setVegan(false);
                spaghetti.setCategoryDetail(danieGlowne);
                recipeRepository.save(spaghetti);

                Recipe szarlotka = new Recipe();
                szarlotka.setName("Szarlotka");
                szarlotka.setAuthor("Janina");
                szarlotka.setDifficulty(3.50f);
                szarlotka.setReleaseDate(LocalDate.of(2020, 12, 5));
                szarlotka.setVegan(true);
                szarlotka.setCategoryDetail(deser);
                recipeRepository.save(szarlotka);

                Recipe bit = new Recipe();
                bit.setName("3-bit");
                bit.setAuthor("Kasia");
                bit.setDifficulty(4.50f);
                bit.setReleaseDate(LocalDate.of(2024, 1, 1));
                bit.setVegan(true);
                bit.setCategoryDetail(deser);
                recipeRepository.save(bit);
            }
        };
    }
}
