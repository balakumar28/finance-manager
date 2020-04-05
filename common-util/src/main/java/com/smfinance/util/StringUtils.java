package com.smfinance.util;

public final class StringUtils
{
    private static String EMPTY_STRING = new String();
    
    public static boolean isBlank(String value)
    {
        return value == null || value.trim().isEmpty();
    }
    
    public static String nullify(String value)
    {
        return isBlank(value) ? null : value.trim();
    }
    
    public static String nonNullify(String value)
    {
        return value == null ? EMPTY_STRING : value.trim();
    }
    
    public static String capitalize(String value)
    {
        return org.apache.commons.lang3.StringUtils.capitalize(value);
    }
}
