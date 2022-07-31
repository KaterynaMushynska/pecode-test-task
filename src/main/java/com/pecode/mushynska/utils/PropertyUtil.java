package com.pecode.mushynska.utils;

import lombok.experimental.UtilityClass;

import java.util.ResourceBundle;

@UtilityClass
public class PropertyUtil {

    private static final ResourceBundle bundle = ResourceBundle.getBundle("data");

    public static String getBasePageUrl() {
        return bundle.getString("base.url");
    }

    public static String getUsername() {
        return bundle.getString("username");
    }

    public static String getPassword() {
        return bundle.getString("password");
    }

    public static String getInvalidUsername() {
        return bundle.getString("invalid.username");
    }

    public static String getInvalidPassword() {
        return bundle.getString("invalid.password");
    }
}

