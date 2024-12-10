package uz.ksan.backend.Config_server_service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/config/")
public class ConfigController {

    @GetMapping("ping")
    public String ping() {
        return "pong";
    }

}
