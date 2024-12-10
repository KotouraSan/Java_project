package uz.ksan.backend.Gateway_service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/gateway/")
public class GatewayController {

    @GetMapping("ping")
    public String ping() {
        return "pong";
    }

}