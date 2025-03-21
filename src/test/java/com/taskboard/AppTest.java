package com.taskboard;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class AppTest {

    @Test
    void contextLoads() {
        // Teste básico pra verificar se o contexto do Spring Boot carrega corretamente
        assertTrue(true);
    }
}