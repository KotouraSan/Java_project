package uz.ksan.backend.Discovery_service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/discovery/")
public class DiscoveryController {

    @GetMapping("ping")
    public String ping() {
        return "pong";
    }

}
