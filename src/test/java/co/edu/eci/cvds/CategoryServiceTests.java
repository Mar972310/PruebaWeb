package co.edu.eci.cvds;

import co.edu.eci.cvds.model.Category;
import co.edu.eci.cvds.repository.CategoryRepository;
import co.edu.eci.cvds.service.CategoryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CategoryServiceTest {

    @Mock
    private CategoryRepository categoryRepository;

    @InjectMocks
    private CategoryService categoryService;

    private Category category;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        category = new Category("Electronics");
        category.setCategoryId("1");
    }

    @Test
    void addCategory() {
        Category category = new Category("Electronics");
        when(categoryRepository.save(any(Category.class))).thenReturn(category);
        Category result = categoryService.addCategory(category);
        assertNotNull(result);
        assertEquals("Electronics", result.getName());
    }
    

    @Test
    void getCategoryM() {
        when(categoryRepository.findById(anyString())).thenReturn(Optional.of(category));
        Optional<Category> result = categoryService.getCategoryM("1");
        assertTrue(result.isPresent());
        assertEquals("1", result.get().getCategoryId());
        assertEquals("Electronics", result.get().getName());
    }

    @Test
    void getCategory() {
        when(categoryRepository.findById(anyString())).thenReturn(Optional.of(category));
        Category result = categoryService.getCategory("1");
        assertNotNull(result);
        assertEquals("1", result.getCategoryId());
        assertEquals("Electronics", result.getName());
    }

    @Test
    void getAllCategories() {
        List<Category> categoryList = Arrays.asList(category, new Category("Books"));
        when(categoryRepository.findAll()).thenReturn(categoryList);
        List<Category> result = categoryService.getAllCategories();
        assertEquals(2, result.size());
    }

    @Test
    void updateCategory() {
        when(categoryRepository.save(any(Category.class))).thenReturn(category);
        Category result = categoryService.updateCategory(category);
        assertNotNull(result);
        assertEquals("1", result.getCategoryId());
        assertEquals("Electronics", result.getName());
    }

    @Test
    void deleteCategory() {
        doNothing().when(categoryRepository).deleteById(anyString());
        assertDoesNotThrow(() -> categoryService.deleteCategory("1"));
        verify(categoryRepository, times(1)).deleteById("1");
    }

    @Test
    void getName() {
        when(categoryRepository.findByCategoryId(anyString())).thenReturn(Arrays.asList(category));
        String result = categoryService.getName();
        assertEquals("Electronics", result);
    }
}
