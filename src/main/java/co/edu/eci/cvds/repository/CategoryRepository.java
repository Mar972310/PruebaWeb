package co.edu.eci.cvds.repository;

import co.edu.eci.cvds.model.Category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, String> {
    public List<Category> findByCategoryId(String categoryId);
}