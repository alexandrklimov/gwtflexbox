package ru.aklimov.gwtflexbox.client.enums;

public enum AlignContentEnum {
    FLEX_START("flex-start"),
    FLEX_END("flex-end"),
    CENTER("center"),
    SPACE_BETWEEN("space-between"),
    SPACE_AROUND("space-around"),
    STRETCH("stretch");

    private String value;
    AlignContentEnum(String value) {
        this.value = value;
    }

    public static AlignContentEnum getDefault(){
        return STRETCH;
    }

    public String getValue() {
        return value;
    }

    public static AlignContentEnum findByValue(String value) {
        AlignContentEnum res = null;
        for(AlignContentEnum val : AlignContentEnum.values()){
            if(val.getValue().equals(value)){
                res = val;
                break;
            }
        }
        return res;
    }
}
