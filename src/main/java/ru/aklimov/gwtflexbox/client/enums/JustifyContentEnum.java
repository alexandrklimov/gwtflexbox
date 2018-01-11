package ru.aklimov.gwtflexbox.client.enums;

public enum JustifyContentEnum {
    FLEX_START("flex-start"),
    FLEX_END("flex-end"),
    CENTER("center"),
    SPACE_BETWEEN("space-between"),
    SPACE_AROUND("space-around"),
    SPACE_EVENLY("space-evenly");

    private String value;
    JustifyContentEnum(String value) {
        this.value = value;
    }

    public static JustifyContentEnum getDefault(){
        return FLEX_START;
    }

    public String getValue() {
        return value;
    }

    public static JustifyContentEnum findByValue(String value) {
        JustifyContentEnum res = null;
        for(JustifyContentEnum val : JustifyContentEnum.values()){
            if(val.getValue().equals(value)){
                res = val;
                break;
            }
        }
        return res;
    }
}
