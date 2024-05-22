package co.edu.eci.cvds.repository;

import co.edu.eci.cvds.model.Brand;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BrandRepository extends JpaRepository<Brand, String> {
    public List<Brand> findByBrandId(String brandId);
}