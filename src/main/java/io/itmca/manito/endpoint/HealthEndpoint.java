package io.itmca.manito.endpoint;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HealthEndpoint {
    @GetMapping({"", "hc"})
    public ResponseEntity<Void> healthCheck() {
        return ResponseEntity.ok().build();
    }
}
