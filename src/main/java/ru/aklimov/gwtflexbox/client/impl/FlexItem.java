package ru.aklimov.gwtflexbox.client.impl;

import com.google.gwt.dom.client.DivElement;
import com.google.gwt.dom.client.Document;
import com.google.gwt.user.client.ui.Widget;
import ru.aklimov.gwtflexbox.client.IFlexItem;

public class FlexItem extends Widget implements IFlexItem {
    public FlexItem() {
        DivElement divElem = Document.get().createDivElement();
        setElement(divElem);
    }
}
