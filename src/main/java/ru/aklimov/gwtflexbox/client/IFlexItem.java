package ru.aklimov.gwtflexbox.client;

import com.google.gwt.dom.client.Style;
import com.google.gwt.user.client.ui.IsWidget;
import ru.aklimov.gwtflexbox.client.enums.AlignSelfEnum;

public interface IFlexItem extends IsWidget {
    Double FLEX_GROW_DEFAULT = 0.0;
    Double FLEX_SHRINK_DEFAULT = 1.0;
    String FLEX_BASIS_DEFAULT = "auto";

    default void setOrder(Integer order) {
        FlexUtils.setOrder(this, order);
    }

    default int getOrder() {
        return FlexUtils.getOrder(this);
    }

    default void setFlexGrow(Double flexGrow) {
        FlexUtils.setFlexGrow(this, flexGrow);
    }

    default double getFlexGrow() {
        return FlexUtils.getFlexGrow(this);
    }

    default void setFlexShrink(Double flexShrink) {
        FlexUtils.setFlexShrink(this, flexShrink);
    }

    default double getFlexShrink() {
        return FlexUtils.getFlexShrink(this);
    }

    default void setFlexBasis(Double value, Style.Unit unit) {
        FlexUtils.setFlexBasis(this, value, unit);
    }

    default String getFlexBasis() {
        return FlexUtils.getFlexBasis(this);
    }

    default void setAlignSelf(AlignSelfEnum alignSelf) {
        FlexUtils.setAlignSelf(this, alignSelf);
    }

    default AlignSelfEnum getAlignSelf() {
        return FlexUtils.getAlignSelf(this);
    }

    default void setFlex(Double grow, Double shrink, String basis, Style.Unit basisUnit) {
        FlexUtils.setFlex(this, grow, shrink, basis, basisUnit);
    }

    default void setFlex(Flex flex) {
        FlexUtils.setFlex(this, flex);
    }

    default Flex getFlex() {
       return FlexUtils.getFlex(this);
    }

    default String getFlexAsString() {
        return FlexUtils.getFlexAsString(this);
    }


    class Flex {
        public Double grow = IFlexItem.FLEX_GROW_DEFAULT;
        public Double shrink = IFlexItem.FLEX_SHRINK_DEFAULT;
        public String basis = FLEX_BASIS_DEFAULT;
        public Style.Unit basisUnit;

        @Override
        public String toString() {
            return Flex.buildCssValueStr(this);
        }

        public static String buildCssValueStr(IFlexItem.Flex flex) {
            StringBuilder sb = new StringBuilder();

            if (flex.grow != null) {
                sb.append(flex.grow);

                if (flex.shrink != null) {
                    sb.append(" ").append(flex.shrink);
                }

                if (flex.basis != null) {
                    sb.append(" ").append(flex.basis);

                    if (flex.basisUnit != null) {
                        String unitStr = flex.basisUnit.getType();
                        sb.append(unitStr);
                    }
                }
            }
            return sb.toString();
        }
    }
}
