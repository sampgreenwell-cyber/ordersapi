package com.vxcommerce.ordersapi;

import org.junit.jupiter.api.Test;
import org.springframework.test.web.reactive.server.WebTestClient;

class HealthControllerTest {

    private final WebTestClient client = WebTestClient
            .bindToController(new HealthController("orders-api"))
            .build();

    @Test
    void healthReturnsOkAndServiceName() {
        client.get().uri("/health")
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.status").isEqualTo("ok")
                .jsonPath("$.service").isEqualTo("orders-api");
    }
}
