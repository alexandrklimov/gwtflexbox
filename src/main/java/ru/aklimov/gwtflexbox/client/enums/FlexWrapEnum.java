package ru.aklimov.gwtflexbox.client.enums;

public enum FlexWrapEnum {
    NOWRAP("nowrap"),
    WRAP("wrap"),
    WRAP_REVERSE("wrap-reverse");

    private String value;
    FlexWrapEnum(String value) {
        this.value = value;
    }

    public static FlexWrapEnum getDefault(){
        return NOWRAP;
    }

    public String getValue() {
        return value;
    }

    public static FlexWrapEnum findByValue(String value) {
        FlexWrapEnum res = null;
        for(FlexWrapEnum val : FlexWrapEnum.values()){
            if(val.getValue().equals(value)){
                res = val;
                break;
            }
        }
        return res;
    }
}
