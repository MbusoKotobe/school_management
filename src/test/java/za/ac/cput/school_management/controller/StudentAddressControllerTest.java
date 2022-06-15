package za.ac.cput.school_management.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class StudentAddressControllerTest {

    //@LocalServerPort
    //private int port;

    @Autowired
    private StudentAddressController controller;

    @BeforeEach
    void setUp(){
        assertNotNull(controller);
    }
    @Test
    void save() {
    }

    @Test
    void read() {
    }

    @Test
    void delete() {
    }

    @Test
    void findAll() {
    }
}