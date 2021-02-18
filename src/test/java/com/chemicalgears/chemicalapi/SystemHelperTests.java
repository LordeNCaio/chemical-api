package com.chemicalgears.chemicalapi;

import static org.junit.jupiter.api.Assertions.*;

import com.chemicalgears.chemicalapi.utils.SystemHelpers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.net.InetAddress;

public class SystemHelperTests {

    @Test
    @DisplayName("Hostname should be not empty")
    public void testHostnameNotEmpty(){
        String str = assertDoesNotThrow(SystemHelpers::getHostName);
        assertNotEquals("", str);
    }

    @Test
    @DisplayName("Hostname should be equal from IFace hostname")
    public void testHostnameEqual(){
        String expected = assertDoesNotThrow(SystemHelpers::getHostName);
        InetAddress value = assertDoesNotThrow(InetAddress::getLocalHost);
        assertEquals(expected, value.getHostName());
    }

    @Test
    @DisplayName("System model should be not empty")
    public void testSystemModelNotEmpty(){
        assertNotEquals("", SystemHelpers.getSystemModel());
    }

    @Test
    @DisplayName("System model should be equal operational system")
    public void testSystemModelEqual(){
        String expected = System.getProperty("os.name");
        assertEquals(expected, SystemHelpers.getSystemModel());
    }

    @Test
    @DisplayName("System architecture should be not empty")
    public void testSystemArchNotEmpty(){
        assertNotEquals("", SystemHelpers.getSystemArch());
    }

    @Test
    @DisplayName("System model should be equal operational system architecture")
    public void testSystemArchEqual(){
        String expected = System.getProperty("os.arch");
        assertEquals(expected, SystemHelpers.getSystemArch());
    }

    @Test
    @DisplayName("System version should be not empty")
    public void testSystemVersionNotEmpty(){
        assertNotEquals("", SystemHelpers.getSystemVersion());
    }

    @Test
    @DisplayName("System version should be equal operational system version")
    public void testSystemVersionEqual(){
        String expected = System.getProperty("os.version");
        assertEquals(expected, SystemHelpers.getSystemVersion());
    }

    @Test
    @DisplayName("System max memory should be more then zero")
    public void testSystemMaxMemoryValue(){
        assertNotEquals(0, SystemHelpers.getSystemMaxMemory());
    }

    @Test
    @DisplayName("System max memory should be equal operational system max memory")
    public void testSystemMaxMemoryEqual(){
        Long runtimeMemoryUsage = Runtime.getRuntime().maxMemory();
        assertEquals(runtimeMemoryUsage, SystemHelpers.getSystemMaxMemory());
    }

    @Test
    @DisplayName("Memory should be more then zero")
    public void testApplicationMemoryUsage(){
        assertNotEquals(0, SystemHelpers.getApplicationMemoryUsage());
    }

    @Test
    @DisplayName("Memory should be equal with runtime calculation")
    public void testApplicationMemoryUsageEqual(){
        Long runtimeMemoryUsage = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        assertEquals(runtimeMemoryUsage, SystemHelpers.getApplicationMemoryUsage());
    }

}
