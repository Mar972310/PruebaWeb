package co.edu.eci.cvds;

import co.edu.eci.cvds.model.Brand;
import co.edu.eci.cvds.repository.BrandRepository;
import co.edu.eci.cvds.service.BrandService;
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

class BrandServiceTest {

    @Mock
    private BrandRepository brandRepository;

    @InjectMocks
    private BrandService brandService;

    private Brand brand;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        brand = new Brand("Toyota");
        brand.setBrandId("1");
    }

    @Test
    void addBrand() {
        Brand brand = new Brand("Toyota");
        when(brandRepository.save(any(Brand.class))).thenReturn(brand);
        Brand result = brandService.addBrand(brand);
        assertNotNull(result);
        assertEquals("Toyota", result.getName());
    }
    

    @Test
    void getBrandM() {
        when(brandRepository.findById(anyString())).thenReturn(Optional.of(brand));
        Optional<Brand> result = brandService.getBrandM("1");
        assertTrue(result.isPresent());
        assertEquals("1", result.get().getBrandId());
        assertEquals("Toyota", result.get().getName());
    }

    @Test
    void getBrand() {
        when(brandRepository.findById(anyString())).thenReturn(Optional.of(brand));
        Brand result = brandService.getbrand("1");
        assertNotNull(result);
        assertEquals("1", result.getBrandId());
        assertEquals("Toyota", result.getName());
    }

    @Test
    void getAllBrands() {
        List<Brand> brandList = Arrays.asList(brand, new Brand("Ford"));
        when(brandRepository.findAll()).thenReturn(brandList);
        List<Brand> result = brandService.getAllBrands();
        assertEquals(2, result.size());
    }

    @Test
    void updateBrand() {
        when(brandRepository.save(any(Brand.class))).thenReturn(brand);
        Brand result = brandService.updateBrand(brand);
        assertNotNull(result);
        assertEquals("1", result.getBrandId());
        assertEquals("Toyota", result.getName());
    }

    @Test
    void deleteBrand() {
        doNothing().when(brandRepository).deleteById(anyString());
        assertDoesNotThrow(() -> brandService.deleteBrand("1"));
        verify(brandRepository, times(1)).deleteById("1");
    }

    @Test
    void getName() {
        when(brandRepository.findByBrandId(anyString())).thenReturn(Arrays.asList(brand));
        String result = brandService.getName();
        assertEquals("Toyota", result);
    }
}
