package ru.aklimov.gwtflexbox.client.impl;

import ru.aklimov.gwtflexbox.client.enums.FlexDirectionEnum;
import ru.aklimov.gwtflexbox.client.enums.FlexboxPropertyEnum;
import ru.aklimov.gwtflexbox.client.impl.FlexboxPanel;

public class HFlexboxPanel extends FlexboxPanel {

    public HFlexboxPanel() {
        this(false);
    }

    public HFlexboxPanel(boolean reverse) {
        super();
        FlexDirectionEnum direction = (reverse) ? FlexDirectionEnum.ROW_REVERSE : FlexDirectionEnum.ROW;
        getElement().getStyle().setProperty(FlexboxPropertyEnum.FLEX_DIRECTION.getValue(), direction.getValue());
    }


}
