package ru.aklimov.gwtflexbox.client.enums;

public enum FlexboxPropertyEnum {
    FLEX_DIRECTION("flexDirection", "flex-direction"),
    FLEX_WRAP("flexWrap", "flex-wrap"),
    FLEX_FLOW("flexFlow", "flex-flow"),
    JUSTIFY_CONTENT("justifyContent", "justify-content"),
    ALIGN_ITEMS("alignItems", "align-items"),
    ALIGN_CONTENT("alignContent", "align-content"),
    ORDER("order", "order"),
    FLEX_GROW("flexGrow", "flex-grow"),
    FLEX_SHRINK("flexShrink", "flex-shrink"),
    FLEX_BASIS("flexBasis", "flex-basis"),
    FLEX("flex", "flex"),
    ALIGN_SELF("alignSelf", "align-self");

    private String value;
    private String rawValue;

    FlexboxPropertyEnum(String value, String rawValue) {
        this.value = value;
        this.rawValue = rawValue;
    }

    public String getValue() {
        return value;
    }

    public String getRawValue() {
        return rawValue;
    }
}

