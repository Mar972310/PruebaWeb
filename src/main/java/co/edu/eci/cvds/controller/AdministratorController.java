package co.edu.eci.cvds.controller;


import co.edu.eci.cvds.model.Administrator;
import co.edu.eci.cvds.service.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import java.net.MalformedURLException;
import java.util.List;
import java.util.Optional;
@Controller
@RequestMapping(value = "")
public class AdministratorController {

    private final AdministratorService administratorService;

    @Autowired
    public AdministratorController(AdministratorService administratorService) {
        this.administratorService = administratorService;
    }

    @GetMapping("/ingresa")
    public String toList(Model model) {
        return "Login";
    }

    @PostMapping("/ingresa/{email}")
    public String login(@PathVariable String email, @ModelAttribute("administrator") Administrator adminLogin) {
        Optional<Administrator> administrator = administratorService.getAdministratorM(email);
        Administrator admini = administrator.get();
        if (administrator != null && admini.getPassword().equals(adminLogin.getPassword())) {
            return "funtionAdmin";
        } else {
            return "falla";
        }

    }
}
