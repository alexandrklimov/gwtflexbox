package ru.aklimov.gwtflexbox.client.enums;

public enum AlignSelfEnum {
    AUTO("auto"),
    FLEX_START("flex-start"),
    FLEX_END("flex-end"),
    CENTER("center"),
    BASELINE("baseline"),
    STRETCH("stretch");

    private String value;
    AlignSelfEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static AlignSelfEnum findByValue(String value){
        AlignSelfEnum res = null;
        for(AlignSelfEnum val : AlignSelfEnum.values()){
            if(val.getValue().equals(value)){
                res = val;
                break;
            }
        }
        return res;
    }
}
