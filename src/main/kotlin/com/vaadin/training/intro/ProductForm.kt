package com.vaadin.training.intro

import com.vaadin.flow.component.button.Button
import com.vaadin.flow.component.button.ButtonVariant
import com.vaadin.flow.component.combobox.ComboBox
import com.vaadin.flow.component.datepicker.DatePicker
import com.vaadin.flow.component.html.Span
import com.vaadin.flow.component.notification.Notification
import com.vaadin.flow.component.orderedlayout.HorizontalLayout
import com.vaadin.flow.component.orderedlayout.VerticalLayout
import com.vaadin.flow.component.textfield.NumberField
import com.vaadin.flow.component.textfield.TextArea
import com.vaadin.flow.component.textfield.TextField

class ProductForm : VerticalLayout() {
    private val name = TextField("Name")
    private val desc = TextArea("Description")
    private val price = NumberField("Price")
    private val priceSfx = Span("€")

    // 0.0.1 ???
    private val avail = DatePicker("Availability")
    private val cat = ComboBox<String>("Category")
    private val btnSave = Button(        "Save"    )
    private val btnCancel = Button("Cancel")

    init {
        price.suffixComponent = priceSfx
        price.step = 0.01
        cat.setItems("A", "B", "C")
        btnSave.addClickListener {
            Notification.show(
                "Saved",
                2000,
                Notification.Position.BOTTOM_START
            )
        }
        btnSave.addThemeVariants(ButtonVariant.LUMO_PRIMARY)
        btnCancel.addClickListener {
            Notification.show(
                "Cancelled",
                2000,
                Notification.Position.BOTTOM_END
            )
        }
        add(name, desc, price, priceSfx, avail, cat, HorizontalLayout(btnSave, btnCancel))
    }
}