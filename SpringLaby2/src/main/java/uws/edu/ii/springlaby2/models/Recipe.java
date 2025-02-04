package uws.edu.ii.springlaby2.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "recipes")
public class Recipe implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 3, max = 50)
    @Column(name = "name", nullable = false)
    private String name;

    @NotBlank
    @Size(min = 3, max = 50)
    @Column(name = "author", nullable = false)
    private String author;

    @NotNull
    @Min(1) @Max(10)
    @NumberFormat(pattern = "#.00")
    @Column(name = "difficulty", nullable = false)
    private Float difficulty;

    @NotNull
    @Past
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "release_date", nullable = false)
    private LocalDate releaseDate;

    @Column(name = "is_vegan")
    private boolean isVegan;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id", nullable = false)
    @NotNull
    private Category categoryDetail;

    public Recipe() {
        this.categoryDetail = new Category();
    }

    public Recipe(Long id, String name, String author, Float difficulty, LocalDate releaseDate, boolean isVegan, Category categoryDetail) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.difficulty = difficulty;
        this.releaseDate = releaseDate;
        this.isVegan = isVegan;
        this.categoryDetail = categoryDetail;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

//    public String getCategory() {
//        return category;
//    }
//
//    public void setCategory(String category) {
//        this.category = category;
//    }

    public Float getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Float difficulty) {
        this.difficulty = difficulty;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public boolean isVegan() {
        return isVegan;
    }

    public void setVegan(boolean vegan) {
        isVegan = vegan;
    }

    public Category getCategoryDetail() {
        return categoryDetail;
    }

    public void setCategoryDetail(Category categoryDetail) {
        this.categoryDetail = categoryDetail;
    }

//    @Override
//    public String toString() {
//        return "Recipe{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", author='" + author + '\'' +
//                ", difficulty=" + difficulty +
//                ", releaseDate=" + releaseDate +
//                ", isVegan=" + isVegan +
//                ", categoryDetail=" + categoryDetail +
//                '}';
//    }
}