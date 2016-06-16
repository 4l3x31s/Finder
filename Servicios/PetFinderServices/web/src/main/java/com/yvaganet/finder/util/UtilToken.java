package com.yvaganet.finder.util;

import java.util.UUID;

/**
 * Created by acarrillo on 16/06/2016.
 */
public class UtilToken {
    public static String getToken() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }
}
