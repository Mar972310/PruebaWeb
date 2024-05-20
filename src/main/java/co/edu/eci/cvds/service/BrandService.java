package co.edu.eci.cvds.service;

import co.edu.eci.cvds.model.Brand;
import co.edu.eci.cvds.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Service
public class BrandService {
    private final BrandRepository brandRepository;

    @Autowired
    public BrandService(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    public Brand addBrand(Brand brand) {
        brand.setBrandId(UUID.randomUUID().toString());
        return brandRepository.save(brand);
    }

    public Optional<Brand> getBrandM(String brandId) {
        return brandRepository.findById(brandId);
    }
    public Brand getbrand(String brandId) {
        return brandRepository.findById(brandId).get();
    }

    public List<Brand> getAllBrands() {
        return brandRepository.findAll();
    }

    public Brand updateBrand(Brand brand) {
        return brandRepository.save(brand);
    }

    public void deleteBrand(String brandId) {
        brandRepository.deleteById(brandId);
    }

    public String getName() {
        return brandRepository.findByBrandId("1").get(0).getName();
    }
}