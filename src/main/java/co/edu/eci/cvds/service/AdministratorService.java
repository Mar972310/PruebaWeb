package co.edu.eci.cvds.service;

import co.edu.eci.cvds.model.Administrator;
import co.edu.eci.cvds.model.Administrator;
import co.edu.eci.cvds.repository.AdministratorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class AdministratorService {
    private final AdministratorRepository administratorRepository;

    @Autowired
    public AdministratorService(AdministratorRepository administratorRepository) {
        this.administratorRepository = administratorRepository;
    }

    public Administrator addAdministrator(Administrator administrator) {
        return administratorRepository.save(administrator);
    }

    public Optional<Administrator> getAdministratorM(String email) {
        return administratorRepository.findById(email);
    }
    public Administrator getAdministrator(String email) {
        return administratorRepository.findById(email).get();
    }

    public List<Administrator> getAllAdministrators() {
        return administratorRepository.findAll();
    }

    public Administrator updateAdministrator(Administrator administrator) {
        return administratorRepository.save(administrator);
    }

    public void deleteAdministrator(String email) {
        administratorRepository.deleteById(email);
    }

    public String getName() {
        return administratorRepository.findByEmail("1").get(0).getEmail();
    }
}