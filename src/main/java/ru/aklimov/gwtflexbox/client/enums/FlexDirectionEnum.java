package ru.aklimov.gwtflexbox.client.enums;

public enum FlexDirectionEnum {
    ROW("row"),
    ROW_REVERSE("row-reverse"),
    COLUMN("column"),
    COLUMN_REVERSE("column-reverse");

    private String value;
    FlexDirectionEnum(String value) {
        this.value = value;
    }

    public static FlexDirectionEnum getDefault(){
        return ROW;
    }

    public String getValue() {
        return value;
    }

    public static FlexDirectionEnum findByValue(String value) {
        FlexDirectionEnum res = null;
        for(FlexDirectionEnum val : FlexDirectionEnum.values()){
            if(val.getValue().equals(value)){
                res = val;
                break;
            }
        }
        return res;
    }
}
