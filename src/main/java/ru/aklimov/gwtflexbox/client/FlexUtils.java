package ru.aklimov.gwtflexbox.client;

import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Style;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import ru.aklimov.gwtflexbox.client.enums.AlignContentEnum;
import ru.aklimov.gwtflexbox.client.enums.AlignItemsEnum;
import ru.aklimov.gwtflexbox.client.enums.AlignSelfEnum;
import ru.aklimov.gwtflexbox.client.enums.FlexDirectionEnum;
import ru.aklimov.gwtflexbox.client.enums.FlexWrapEnum;
import ru.aklimov.gwtflexbox.client.enums.FlexboxPropertyEnum;
import ru.aklimov.gwtflexbox.client.enums.JustifyContentEnum;

public class FlexUtils {
    private FlexUtils() {
    }

    /////
    /// About Flex
    /////

    public static void setFlex(IsWidget isWidget, Double grow, Double shrink, String basis, Style.Unit basisUnit) {
        setFlex(isWidget.asWidget(), grow, shrink, basis, basisUnit);
    }

    public static void setFlex(Widget widget, Double grow, Double shrink, String basis, Style.Unit basisUnit) {
        setFlex(widget.getElement(), grow, shrink, basis, basisUnit);
    }

    public static void setFlex(Element elem, Double grow, Double shrink, String basis, Style.Unit basisUnit) {
        if (grow == null) {
            throw new IllegalArgumentException("[grow] is mandatory value!");

        } else {
            IFlexItem.Flex flex = new IFlexItem.Flex();
            flex.grow = grow;
            flex.shrink = shrink;
            flex.basis = basis;
            flex.basisUnit = basisUnit;
            setFlex(elem, flex);
        }
    }

    public static void setFlex(IsWidget isWidget, IFlexItem.Flex flex) {
        setFlex(isWidget.asWidget(), flex);
    }

    public static void setFlex(Widget widget, IFlexItem.Flex flex) {
        setFlex(widget.getElement(), flex);
    }

    public static void setFlex(Element element, IFlexItem.Flex flex) {
        Style style = element.getStyle();
        style.setProperty(FlexboxPropertyEnum.FLEX.getValue(), flex.toString());
    }

    public static IFlexItem.Flex getFlex(IsWidget isWidget) {
        return getFlex(isWidget.asWidget());
    }

    public static IFlexItem.Flex getFlex(Widget widget) {
        return getFlex(widget.getElement());
    }

    public static IFlexItem.Flex getFlex(Element elem) {
        String flexAsStr = getFlexAsString(elem);
        String[] split = flexAsStr.split(" ");

        IFlexItem.Flex flex = new IFlexItem.Flex();
        flex.grow = Double.parseDouble(split[0]);

        if (split.length > 1 && FlexUtils.checkIsNumber(split[1])) {
            flex.shrink = Double.parseDouble(split[1]);
        }
        if (split.length > 2) {
            flex.basis = split[2];
            for (Style.Unit unit : Style.Unit.values()) {
                if (flex.basis.endsWith(unit.getType())) {
                    flex.basis = flex.basis.replace(unit.getType(), "");
                    flex.basisUnit = unit;
                }
            }
        }

        return flex;
    }

    public static String getFlexAsString(IsWidget isWidget) {
        return getFlexAsString(isWidget.asWidget());
    }

    public static String getFlexAsString(Widget widget) {
        return getFlexAsString(widget.getElement());
    }

    public static String getFlexAsString(Element elem) {
        return FlexUtils.getComputedStyleProperty(elem, FlexboxPropertyEnum.FLEX.getRawValue());
    }


    /////
    /// About Order
    /////

    public static void setOrder(IsWidget isWidget, Integer order) {
        setOrder(isWidget.asWidget(), order);
    }

    public static void setOrder(Widget widget, Integer order) {
        setOrder(widget.getElement(), order);
    }

    public static void setOrder(Element elem, Integer order) {
        String orderStr = (order == null) ? "" : String.valueOf(order);
        elem.getStyle().setProperty(FlexboxPropertyEnum.ORDER.getValue(), orderStr);
    }

    public static int getOrder(IsWidget isWidget) {
        return getOrder(isWidget.asWidget());
    }

    public static int getOrder(Widget widget) {
        return getOrder(widget.getElement());
    }

    public static int getOrder(Element elem) {
        String orderStr = FlexUtils.getComputedStyleProperty(elem, FlexboxPropertyEnum.ORDER.getRawValue());
        return Integer.parseInt(orderStr);
    }


    /////
    /// About Grow
    /////

    public static void setFlexGrow(IsWidget isWidget, Double flexGrow) {
        setFlexGrow(isWidget.asWidget(), flexGrow);
    }

    public static void setFlexGrow(Widget widget, Double flexGrow) {
        setFlexGrow(widget.getElement(), flexGrow);
    }

    public static void setFlexGrow(Element elem, Double flexGrow) {
        String val = (flexGrow == null) ? "" : String.valueOf(flexGrow);
        elem.getStyle().setProperty(FlexboxPropertyEnum.FLEX_GROW.getValue(), val);
    }

    public static double getFlexGrow(IsWidget isWidget) {
        return getFlexGrow(isWidget.asWidget());
    }

    public static double getFlexGrow(Widget widget) {
        return getFlexGrow(widget.getElement());
    }

    public static double getFlexGrow(Element elem) {
        String growStr = FlexUtils.getComputedStyleProperty(elem, FlexboxPropertyEnum.FLEX_GROW.getRawValue());
        return Double.parseDouble(growStr);
    }


    //////
    /// About Shrink
    /////

    public static void setFlexShrink(IsWidget isWidget, Double flexShrink) {
        setFlexShrink(isWidget.asWidget(), flexShrink);
    }

    public static void setFlexShrink(Widget widget, Double flexShrink) {
        setFlexShrink(widget.getElement(), flexShrink);
    }

    public static void setFlexShrink(Element elem, Double flexShrink) {
        String val = (flexShrink == null) ? "" : String.valueOf(flexShrink);
        elem.getStyle().setProperty(FlexboxPropertyEnum.FLEX_SHRINK.getValue(), val);
    }

    public static double getFlexShrink(IsWidget isWidget) {
        return getFlexShrink(isWidget.asWidget());
    }

    public static double getFlexShrink(Widget widget) {
        return getFlexShrink(widget.getElement());
    }

    public static double getFlexShrink(Element elem) {
        String shrinkStr = FlexUtils.getComputedStyleProperty(elem, FlexboxPropertyEnum.FLEX_SHRINK.getRawValue());
        return Double.parseDouble(shrinkStr);
    }


    /////
    /// About Basis
    /////

    public static void setFlexBasis(IsWidget isWidget, Double basisVal, Style.Unit basisUnit) {
        setFlexBasis(isWidget.asWidget(), basisVal, basisUnit);
    }

    public static void setFlexBasis(Widget widget, Double basisVal, Style.Unit basisUnit) {
        setFlexBasis(widget.getElement(), basisVal, basisUnit);
    }

    public static void setFlexBasis(Element elem, Double basisVal, Style.Unit basisUnit) {
        String valueStr = "";
        String unitStr = "";
        valueStr = (valueStr == null) ? "" : String.valueOf(basisVal);
        if (!valueStr.equals("")) {
            unitStr = (basisUnit == null) ? "" : basisUnit.getType();
        }
        elem.getStyle().setProperty(FlexboxPropertyEnum.FLEX_BASIS.getValue(), valueStr + unitStr);

    }

    public static void setFlexBasis(IsWidget isWidget, String basis) {
        setFlexBasis(isWidget.asWidget(), basis);
    }

    public static void setFlexBasis(Widget widget, String basis) {
        setFlexBasis(widget.getElement(), basis);
    }

    public static void setFlexBasis(Element elem, String basis) {
        String val = (basis == null) ? "" : String.valueOf(basis);
        elem.getStyle().setProperty(FlexboxPropertyEnum.FLEX_BASIS.getValue(), val);
    }

    public static String getFlexBasis(IsWidget isWidget) {
        return getFlexBasis(isWidget.asWidget());
    }

    public static String getFlexBasis(Widget widget) {
        return getFlexBasis(widget.getElement());
    }

    public static String getFlexBasis(Element elem) {
        return FlexUtils.getComputedStyleProperty(elem, FlexboxPropertyEnum.FLEX_BASIS.getRawValue());
    }


    /////
    /// Align Self
    /////

    public static void setAlignSelf(IsWidget isWidget, AlignSelfEnum alignSelf) {
        setAlignSelf(isWidget.asWidget(), alignSelf);
    }

    public static void setAlignSelf(Widget widget, AlignSelfEnum alignSelf) {
        setAlignSelf(widget.getElement(), alignSelf);
    }

    public static void setAlignSelf(Element elem, AlignSelfEnum alignSelf) {
        String alignSelfStr = (alignSelf == null) ? "" : alignSelf.getValue();
        elem.getStyle().setProperty(FlexboxPropertyEnum.ALIGN_SELF.getValue(), alignSelfStr);
    }

    public static AlignSelfEnum getAlignSelf(IsWidget isWidget) {
        return getAlignSelf(isWidget.asWidget());
    }

    public static AlignSelfEnum getAlignSelf(Widget widget) {
        return getAlignSelf(widget.getElement());
    }

    public static AlignSelfEnum getAlignSelf(Element elem) {
        String alignSelfStr = FlexUtils.getComputedStyleProperty(elem, FlexboxPropertyEnum.ALIGN_SELF.getRawValue());
        return AlignSelfEnum.findByValue(alignSelfStr);
    }


    /////
    /// About Flex Direction
    /////

    public static void setFlexDirection(IsWidget isWidget, FlexDirectionEnum flexDirection) {
        setFlexDirection(isWidget.asWidget(), flexDirection);
    }

    public static void setFlexDirection(Widget widget, FlexDirectionEnum flexDirection) {
        setFlexDirection(widget.getElement(), flexDirection);
    }

    public static void setFlexDirection(Element elem, FlexDirectionEnum flexDirection) {
        String flexDirectionStr = (flexDirection == null) ? "" : flexDirection.getValue();
        elem.getStyle().setProperty(FlexboxPropertyEnum.FLEX_DIRECTION.getValue(), flexDirectionStr);
    }

    public static FlexDirectionEnum getFlexDirection(IsWidget isWidget) {
        return getFlexDirection(isWidget.asWidget());
    }

    public static FlexDirectionEnum getFlexDirection(Widget widget) {
        return getFlexDirection(widget.getElement());
    }

    public static FlexDirectionEnum getFlexDirection(Element elem) {
        String flexDirectionStr = FlexUtils.getComputedStyleProperty(elem, FlexboxPropertyEnum.FLEX_DIRECTION.getRawValue());
        return FlexDirectionEnum.findByValue(flexDirectionStr);
    }


    /////
    /// About Flex Wrap
    /////

    public static void setFlexWrap(IsWidget isWidget, FlexWrapEnum flexWrap) {
        setFlexWrap(isWidget.asWidget(), flexWrap);
    }

    public static void setFlexWrap(Widget widget, FlexWrapEnum flexWrap) {
        setFlexWrap(widget.getElement(), flexWrap);
    }

    public static void setFlexWrap(Element elem, FlexWrapEnum flexWrap) {
        String flexWrapStr = (flexWrap == null) ? "" : flexWrap.getValue();
        elem.getStyle().setProperty(FlexboxPropertyEnum.FLEX_WRAP.getValue(), flexWrapStr);
    }

    public static FlexWrapEnum getFlexWrap(IsWidget isWidget) {
        return getFlexWrap(isWidget.asWidget());
    }

    public static FlexWrapEnum getFlexWrap(Widget widget) {
        return getFlexWrap(widget.getElement());
    }

    public static FlexWrapEnum getFlexWrap(Element elem) {
        String flexWrapStr = FlexUtils.getComputedStyleProperty(elem, FlexboxPropertyEnum.FLEX_WRAP.getRawValue());
        return FlexWrapEnum.findByValue(flexWrapStr);
    }


    /////
    /// About Flex Flow
    /////

    public static void setFlexFlow(IsWidget isWidget, FlexDirectionEnum flexDirection, FlexWrapEnum flexWrap) {
        setFlexFlow(isWidget.asWidget(), flexDirection, flexWrap);
    }

    public static void setFlexFlow(Widget widget, FlexDirectionEnum flexDirection, FlexWrapEnum flexWrap) {
        setFlexFlow(widget.getElement(), flexDirection, flexWrap);
    }

    public static void setFlexFlow(Element elem, FlexDirectionEnum flexDirection, FlexWrapEnum flexWrap) {
        String propValue;

        if (flexDirection == null && flexWrap == null) {
            propValue = "";

        } else if (flexDirection != null && flexWrap != null) {
            propValue = flexDirection.getValue() + " " + flexWrap.getValue();

        } else {
            propValue = (flexDirection == null) ? flexWrap.getValue() : flexDirection.getValue();
        }

        elem.getStyle().setProperty(FlexboxPropertyEnum.FLEX_FLOW.getValue(), propValue);
    }


    /////
    /// About Justify Content
    /////

    public static void setJustifyContent(IsWidget isWidget, JustifyContentEnum justifyContent) {
        setJustifyContent(isWidget.asWidget(), justifyContent);
    }

    public static void setJustifyContent(Widget widget, JustifyContentEnum justifyContent) {
        setJustifyContent(widget.getElement(), justifyContent);
    }

    public static void setJustifyContent(Element elem, JustifyContentEnum justifyContent) {
        String justifyContentStr = (justifyContent == null) ? "" : justifyContent.getValue();
        elem.getStyle().setProperty(FlexboxPropertyEnum.JUSTIFY_CONTENT.getValue(), justifyContentStr);
    }

    public static JustifyContentEnum getJustifyContent(IsWidget isWidget) {
        return getJustifyContent(isWidget.asWidget());
    }

    public static JustifyContentEnum getJustifyContent(Widget widget) {
        return getJustifyContent(widget.getElement());
    }

    public static JustifyContentEnum getJustifyContent(Element elem) {
        String flexWrapStr = FlexUtils.getComputedStyleProperty(elem, FlexboxPropertyEnum.JUSTIFY_CONTENT.getRawValue());
        return JustifyContentEnum.findByValue(flexWrapStr);
    }


    /////
    /// About Align Items
    /////

    public static void setAlignItems(IsWidget isWidget, AlignItemsEnum alignItems) {
        setAlignItems(isWidget.asWidget(), alignItems);
    }

    public static void setAlignItems(Widget widget, AlignItemsEnum alignItems) {
        setAlignItems(widget.getElement(), alignItems);
    }

    public static void setAlignItems(Element elem, AlignItemsEnum alignItems) {
        String alignItemsStr = (alignItems == null) ? "" : alignItems.getValue();
        elem.getStyle().setProperty(FlexboxPropertyEnum.ALIGN_ITEMS.getValue(), alignItemsStr);
    }

    public static AlignItemsEnum getAlignItems(IsWidget isWidget) {
        return getAlignItems(isWidget.asWidget());
    }

    public static AlignItemsEnum getAlignItems(Widget widget) {
        return getalignItems(widget.getElement());
    }

    public static AlignItemsEnum getalignItems(Element elem) {
        String alignItemsStr = FlexUtils.getComputedStyleProperty(elem, FlexboxPropertyEnum.ALIGN_ITEMS.getRawValue());
        return AlignItemsEnum.findByValue(alignItemsStr);
    }


    /////
    /// About Align Items
    /////

    public static void setAlignContent(IsWidget isWidget, AlignContentEnum alignContent) {
        setAlignContent(isWidget.asWidget(), alignContent);
    }

    public static void setAlignContent(Widget widget, AlignContentEnum alignContent) {
        setAlignContent(widget.getElement(), alignContent);
    }

    public static void setAlignContent(Element elem, AlignContentEnum alignContent) {
        String alignContentStr = (alignContent == null) ? "" : alignContent.getValue();
        elem.getStyle().setProperty(FlexboxPropertyEnum.ALIGN_CONTENT.getValue(), alignContentStr);
    }

    public static AlignContentEnum getAlignContent(IsWidget isWidget) {
        return getAlignContent(isWidget.asWidget());
    }

    public static AlignContentEnum getAlignContent(Widget widget) {
        return getAlignContent(widget.getElement());
    }

    public static AlignContentEnum getAlignContent(Element elem) {
        String alignContentStr = FlexUtils.getComputedStyleProperty(elem, FlexboxPropertyEnum.ALIGN_CONTENT.getRawValue());
        return AlignContentEnum.findByValue(alignContentStr);
    }


    /////
    /// OTHERS
    /////

    public static IFlexItem.Flex buildFlex(IFlexItem flexItem) {
        double flexGrow = flexItem.getFlexGrow();
        double flexShrink = flexItem.getFlexShrink();
        String flexBasis = flexItem.getFlexBasis();

        IFlexItem.Flex flex = new IFlexItem.Flex();
        flex.grow = flexGrow;
        flex.shrink = flexShrink;
        flex.basis = flexBasis;

        return flex;
    }

    public static String getComputedStyleProperty(IsWidget isWidget, String property) {
        return getComputedStyleProperty(isWidget.asWidget().getElement(), property);
    }

    public static native String getComputedStyleProperty(Element element, String property)  /*-{
        if ($doc.defaultView && $doc.defaultView.getComputedStyle) {
            return $doc.defaultView.getComputedStyle(element, null).getPropertyValue(property);
        }
        return "";
    }-*/;

    public static native boolean checkIsNumber(String number)/*-{
        return Number(number) !== NaN;
    }-*/;
}
