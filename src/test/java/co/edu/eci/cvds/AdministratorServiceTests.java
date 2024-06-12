package co.edu.eci.cvds;

import co.edu.eci.cvds.model.Administrator;
import co.edu.eci.cvds.repository.AdministratorRepository;
import co.edu.eci.cvds.service.AdministratorService;
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

class AdministratorServiceTest {

    @Mock
    private AdministratorRepository administratorRepository;

    @InjectMocks
    private AdministratorService administratorService;

    private Administrator admin;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        admin = new Administrator("admin@example.com", "password123");
    }

    @Test
    void addAdministrator() {
        when(administratorRepository.save(any(Administrator.class))).thenReturn(admin);
        Administrator result = administratorService.addAdministrator(admin);
        assertNotNull(result);
        assertEquals("admin@example.com", result.getEmail());
    }

    @Test
    void getAdministratorM() {
        when(administratorRepository.findById(anyString())).thenReturn(Optional.of(admin));
        Optional<Administrator> result = administratorService.getAdministratorM("admin@example.com");
        assertTrue(result.isPresent());
        assertEquals("admin@example.com", result.get().getEmail());
    }

    @Test
    void getAdministrator() {
        when(administratorRepository.findById(anyString())).thenReturn(Optional.of(admin));
        Administrator result = administratorService.getAdministrator("admin@example.com");
        assertNotNull(result);
        assertEquals("admin@example.com", result.getEmail());
    }

    @Test
    void getAllAdministrators() {
        List<Administrator> adminList = Arrays.asList(admin, new Administrator("admin2@example.com", "password456"));
        when(administratorRepository.findAll()).thenReturn(adminList);
        List<Administrator> result = administratorService.getAllAdministrators();
        assertEquals(2, result.size());
    }

    @Test
    void updateAdministrator() {
        when(administratorRepository.save(any(Administrator.class))).thenReturn(admin);
        Administrator result = administratorService.updateAdministrator(admin);
        assertNotNull(result);
        assertEquals("admin@example.com", result.getEmail());
    }

    @Test
    void deleteAdministrator() {
        doNothing().when(administratorRepository).deleteById(anyString());
        assertDoesNotThrow(() -> administratorService.deleteAdministrator("admin@example.com"));
        verify(administratorRepository, times(1)).deleteById("admin@example.com");
    }

    @Test
    void getName() {
        when(administratorRepository.findByEmail(anyString())).thenReturn(Arrays.asList(admin));
        String result = administratorService.getName();
        assertEquals("admin@example.com", result);
    }
}
