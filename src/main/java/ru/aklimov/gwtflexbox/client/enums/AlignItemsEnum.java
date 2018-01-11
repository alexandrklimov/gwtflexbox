package ru.aklimov.gwtflexbox.client.enums;

public enum AlignItemsEnum {
    FLEX_START("flex-start"),
    FLEX_END("flex-end"),
    CENTER("center"),
    BASELINE("baseline"),
    STRETCH("stretch");

    private String value;
    AlignItemsEnum(String value) {
        this.value = value;
    }

    public static AlignItemsEnum getDefault(){
        return STRETCH;
    }

    public static AlignItemsEnum findByValue(String value) {
        AlignItemsEnum res = null;
        for (AlignItemsEnum val : AlignItemsEnum.values()) {
            if (val.getValue().equals(value)) {
                res = val;
                break;
            }
        }
        return res;
    }

    public String getValue() {
        return value;
    }
}
