package co.edu.eci.cvds.repository;

import co.edu.eci.cvds.model.Administrator;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdministratorRepository extends JpaRepository<Administrator, String> {
    public List<Administrator> findByEmail(String administratorId);
}