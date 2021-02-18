package com.chemicalgears.chemicalapi;

import static org.junit.jupiter.api.Assertions.*;
import com.chemicalgears.chemicalapi.utils.LocalDateTimeHelpers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@SpringBootTest
public class LocalDateTimeHelpersTests {

    @Test
    @DisplayName("Should local date transform to date dont return null")
    public void testLocalDateConversionNotNull() {
        var expected= LocalDateTimeHelpers.toDate(LocalDateTime.now());
        assertNotEquals(expected, null);
    }

    @Test
    @DisplayName("Should local date transform match current date")
    public void testLocalDateConversion() {
        var expected = Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant());;
        assertEquals(expected, LocalDateTimeHelpers.toDate(LocalDateTime.now()));
    }

}
