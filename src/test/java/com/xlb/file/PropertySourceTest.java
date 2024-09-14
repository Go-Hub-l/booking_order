package com.xlb.file;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class PropertySourceTest {
    @Value("${insert.count}")
    private String count;

    @Test
    public void getValue() {

        System.out.println("value: " + count);
    }
}
