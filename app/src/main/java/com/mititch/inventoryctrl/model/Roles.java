package com.mititch.inventoryctrl.model;

import java.util.HashSet;
import java.util.Set;

public enum Roles {
    ADMIN(1/*, true*/),
    USER(2/*, false*/),
    GUEST(3);

    final int code;
//    final boolean macro;

    Roles(int code /*, boolean macro*/) {
        this.code = code;
//        this.macro = macro;
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

        if (role == ADMIN) {
            result.add(USER);
        }
        return result;
    }

    public int getCode() {
        return code;
    }

//    public boolean isMacro() {
//        return macro;
//    }
}
