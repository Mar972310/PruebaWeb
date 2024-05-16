package co.edu.eci.cvds.service;

import co.edu.eci.cvds.model.Category;
import co.edu.eci.cvds.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category addCategory(Category category) {
        category.setCategoryId(UUID.randomUUID().toString());
        return categoryRepository.save(category);
    }

    public Optional<Category> getCategoryM(String categoryId) {
        return categoryRepository.findById(categoryId);
    }
    public Category getCategory(String categoryId) {
        return categoryRepository.findById(categoryId).get();
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Category updateCategory(Category category) {
        return categoryRepository.save(category);
    }

    public void deleteCategory(String categoryId) {
        categoryRepository.deleteById(categoryId);
    }

    public String getName() {
        return categoryRepository.findByCategoryId("1").get(0).getName();
    }
}