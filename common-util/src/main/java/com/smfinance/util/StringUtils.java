package com.smfinance.util;

public final class StringUtils
{
    public static boolean isBlank(String value)
    {
        return value == null || value.trim().isEmpty();
    }
}
