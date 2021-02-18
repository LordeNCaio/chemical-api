package com.chemicalgears.chemicalapi.utils;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class SystemHelpers {

    public static String getHostName() throws UnknownHostException {
        return InetAddress.getLocalHost().getHostName();
    }

    public static String getSystemModel() {
        return System.getProperty("os.name");
    }

    public static String getSystemArch() {
        return System.getProperty("os.arch");
    }

    public static String getSystemVersion() {
        return System.getProperty("os.version");
    }

    public static Long getSystemMaxMemory() {
        return Runtime.getRuntime().maxMemory();
    }

    public static Long getApplicationMemoryUsage() {
        return Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
    }

}
