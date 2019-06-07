package com.mititch.inventoryctrl.model;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public enum Roles {
    SUPER_USER(0, true),
    UI_ADMIN(1, true),
    UI_USER(2, false),
    UI_GUEST(3, false),
    API_ADMIN(100, true),
    API_PING(101, false),
    API_GET_TRANSACTION(102, false),
    API_CONFIRM_TRANSACTION(103, false);

    final int code;
    final boolean macro;

    Roles(int code, boolean macro) {
        this.code = code;
        this.macro = macro;
    }

    public static Roles findByCode(int code) {
        for (Roles value : values()) {
            if (value.code == code) {
                return value;
            }
        }
        return null;
    }

    public static Set<Roles> expandRole(Roles role) {
        Set<Roles> result = new HashSet<Roles>();
        if (role == SUPER_USER) {
            result.addAll(Arrays.asList(values()));
        }
        if (role == UI_ADMIN) {
            result.add(UI_USER);
            result.add(UI_GUEST);
        }
        if (role == API_ADMIN) {
            result.add(API_PING);
            result.add(API_GET_TRANSACTION);
            result.add(API_CONFIRM_TRANSACTION);
        }
        return result;
    }

    public int getCode() {
        return code;
    }

    public boolean isMacro() {
        return macro;
    }
}
