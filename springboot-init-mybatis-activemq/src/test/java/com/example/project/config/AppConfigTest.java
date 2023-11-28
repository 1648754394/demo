package com.example.project.config;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;

@SpringBootTest
public class AppConfigTest {

    @Autowired
    private TableConfigService tableConfigService;

    @Test
    void getPropertyTest() {
        Set<String> tables = tableConfigService.getTables();
        for (String tableName : tables) {
            String columnNames = tableConfigService.getColumnNames(tableName);
            System.out.println("Column Names for " + tableName + ": " + columnNames);
        }
    }
}
