package com.luxoft.pages;

import lombok.Getter;

@Getter
public enum PageAlias {

    HOME("home page");

    private String alias;


    PageAlias(String alias) {
        this.alias = alias;
    }

    public static PageAlias byDescription(final String value) {
        for (PageAlias name : PageAlias.values()) {
            if (name.getAlias().equals(value)) {
                return name;
            }
        }
        return null;
    }
}
