package org.ifa.fbansept.Alea.security;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class securityTestController {
    @GetMapping("/")
    public String resourcePourToutLeMonde() {
        return "Hello buddy";
    }
    @GetMapping("/user/hello")
    public String resourcePourUtilisateur() {
        return "Hello user";
    }
    @GetMapping("/admin/hello")
    public String resourcePourAdministrateur() {
        return "Hello admin";
    }
}
