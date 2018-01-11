package ru.aklimov.gwtflexbox.client;

import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.ProvidesResize;
import ru.aklimov.gwtflexbox.client.enums.AlignContentEnum;
import ru.aklimov.gwtflexbox.client.enums.AlignItemsEnum;
import ru.aklimov.gwtflexbox.client.enums.FlexDirectionEnum;
import ru.aklimov.gwtflexbox.client.enums.FlexWrapEnum;
import ru.aklimov.gwtflexbox.client.enums.JustifyContentEnum;

public interface IFlexContainer extends IsWidget, ProvidesResize {
    default void setFlexDirection(FlexDirectionEnum flexDirection) {
        FlexUtils.setFlexDirection(this, flexDirection);
    }

    default FlexDirectionEnum getFlexDirection() {
        return FlexUtils.getFlexDirection(this);
    }

    default void setFlexWrap(FlexWrapEnum flexWrap) {
        FlexUtils.setFlexWrap(this, flexWrap);
    }

    default FlexWrapEnum getFlexWrap() {
        return FlexUtils.getFlexWrap(this);
    }

    default void setFlexFlow(FlexDirectionEnum flexDirection, FlexWrapEnum flexWrap){
        FlexUtils.setFlexFlow(this, flexDirection, flexWrap);
    }

    default void setJustifyContent(JustifyContentEnum justifyContent){
        FlexUtils.setJustifyContent(this, justifyContent);
    }

    default JustifyContentEnum getJustifyContent(){
        return FlexUtils.getJustifyContent(this);
    }

    default void setAlignItems(AlignItemsEnum alignItems){
        FlexUtils.setAlignItems(this, alignItems);
    }

    default AlignItemsEnum getAlignItems(){
        return FlexUtils.getAlignItems(this);
    }

    default void setAlignContent(AlignContentEnum alignContent){
        FlexUtils.setAlignContent(this, alignContent);
    }

    default AlignContentEnum getAlignContent(){
        return FlexUtils.getAlignContent(this);
    }
}
