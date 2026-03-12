package com.github.dvrecky.smartbudget;

import com.github.dvrecky.smartbudget.common.storage.init.S3IconInitializer;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

@SpringBootTest
@ActiveProfiles("test")
class SmartBudgetApplicationTests {

    @MockitoBean
    private S3IconInitializer s3IconInitializer;

    @Test
    void contextLoads() {
    }

}
