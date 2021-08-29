package ru.atom.hachaton.config;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {SwaggerConfig.class})
@ExtendWith(SpringExtension.class)
public class SwaggerConfigTest {
    @Autowired
    private SwaggerConfig swaggerConfig;

    @Test
    public void testApi() {
        // TODO: This test is incomplete.
        //   Reason: No meaningful assertions found.
        //   To help Diffblue Cover to find assertions, please add getters to the
        //   class under test that return fields written by the method under test.
        //   See https://diff.blue/R004

        this.swaggerConfig.api();
    }
}

