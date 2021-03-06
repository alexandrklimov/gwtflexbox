package ru.aklimov.gwtflexbox.client.impl;

import ru.aklimov.gwtflexbox.client.enums.FlexDirectionEnum;
import ru.aklimov.gwtflexbox.client.enums.FlexboxPropertyEnum;
import ru.aklimov.gwtflexbox.client.impl.FlexboxPanel;

public class VFlexboxPanel extends FlexboxPanel {

    public VFlexboxPanel() {
        this(false);
    }

    public VFlexboxPanel(boolean reverse) {
        super();
        FlexDirectionEnum direction = (reverse) ? FlexDirectionEnum.COLUMN_REVERSE : FlexDirectionEnum.COLUMN;
        getElement().getStyle().setProperty(FlexboxPropertyEnum.FLEX_DIRECTION.getValue(), direction.getValue());
    }


}
