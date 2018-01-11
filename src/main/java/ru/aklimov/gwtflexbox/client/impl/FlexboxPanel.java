package ru.aklimov.gwtflexbox.client.impl;

import com.google.gwt.dom.client.DivElement;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Style;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.ComplexPanel;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.RequiresResize;
import com.google.gwt.user.client.ui.Widget;
import ru.aklimov.gwtflexbox.client.IFlexContainer;
import ru.aklimov.gwtflexbox.client.IFlexItem;
import ru.aklimov.gwtflexbox.client.enums.FlexboxPropertyEnum;

public class FlexboxPanel extends ComplexPanel implements IFlexContainer, IFlexItem, RequiresResize {

    protected Timer onResizeDelayTimer;
    protected boolean delayedOnResize;

    public FlexboxPanel() {
        DivElement divElement = Document.get().createDivElement();
        divElement.getStyle().setDisplay(Style.Display.FLEX);
        setElement(divElement);
    }


    /**
     * Adds a widget to this panel.
     *
     * <p>
     * By default, each child will be inserted with the default parameters - see {@link IFlexItem.Flex}.<br/>
     * <strong>But IF</strong> the widget implements {@link IFlexItem} interface, we will use its flexbox-related properties value.
     * </p>
     *
     * @param widget the widget to be added
     */
    @Override
    public void add(Widget widget) {
        if(widget instanceof IFlexItem){
            addFlexItem((IFlexItem) widget);
        } else {
            add(widget, new IFlexItem.Flex());
        }
    }


    public void add(IsWidget child, IFlexItem.Flex flex) {
        add(child.asWidget(), flex);
    }

    /**
     *
     * @param child
     * @param flex
     */
    public void add(Widget child, IFlexItem.Flex flex) {
        insert(child, getWidgetCount(), false, flex);
    }

    /**
     * <p>
     * By default, each child will be inserted with the default parameters - see {@link IFlexItem.Flex}.<br/>
     * <strong>But IF</strong> the widget implements {@link IFlexItem} interface, we will use its flexbox-related properties value.
     * </p>
     * @param child
     * @param beforeIndex
     */
    public void insert(Widget child, int beforeIndex) {
        if(child instanceof IFlexItem){
            insertFlexItem((IFlexItem) child, beforeIndex);
        } else {
            insert(child, beforeIndex, new IFlexItem.Flex());
        }
    }

    public void insert(Widget child, int beforeIndex, IFlexItem.Flex flex) {
        insert(child, beforeIndex, true, flex);
    }

    protected void insert(Widget child, int beforeIndex, boolean domInsert, IFlexItem.Flex flex) {
        child.getElement().getStyle().setProperty(FlexboxPropertyEnum.FLEX.getValue(), flex.toString());
        insert(child, Element.as(getElement()), beforeIndex, domInsert);
    }


    protected void addFlexItem(IFlexItem flexItem) {
        insertFlexItem(flexItem, getWidgetCount(), false);
    }

    protected void insertFlexItem(IFlexItem child, int beforeIndex, boolean domInsert) {
        insert(child.asWidget(), Element.as(getElement()), beforeIndex, domInsert);
    }

    protected void insertFlexItem(IFlexItem child, int beforeIndex) {
        insertFlexItem(child, beforeIndex, true);
    }


    @Override
    public void onResize() {
        if (delayedOnResize) {
            onResizeDelayed();
        } else {
            onResizeImmediately();
        }
    }

    public void onResizeDelayed() {
        if (onResizeDelayTimer == null) {
            onResizeDelayTimer = new Timer() {
                @Override
                public void run() {
                    FlexboxPanel.this.onResizeImmediately();
                }
            };
        }
        onResizeDelayTimer.cancel();
        onResizeDelayTimer.schedule(100);
    }

    public void onResizeImmediately() {
        if (onResizeDelayTimer != null) {
            onResizeDelayTimer.cancel();
        }

        for (Widget widget : this) {
            if (widget instanceof RequiresResize) {
                ((RequiresResize) widget).onResize();
            }
        }
    }


    public boolean isDelayedOnResize() {
        return delayedOnResize;
    }

    public void setDelayedOnResize(boolean delayedOnResize) {
        this.delayedOnResize = delayedOnResize;
    }
}
