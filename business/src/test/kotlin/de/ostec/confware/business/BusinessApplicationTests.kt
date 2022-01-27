package de.ostec.confware.business

import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest(
    properties = ["test.firestore.emulatorEndpoint=localhost:9999"]
)
class BusinessApplicationTests {
    @Test
    fun contextLoads() {}
}
