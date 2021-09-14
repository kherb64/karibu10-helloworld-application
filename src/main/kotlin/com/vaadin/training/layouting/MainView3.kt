/*
 * Copyright 2000-2017 Vaadin Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.vaadin.training.layouting

import com.vaadin.flow.component.AbstractField
import com.vaadin.flow.component.button.Button
import com.vaadin.flow.component.button.ButtonVariant
import com.vaadin.flow.component.combobox.ComboBox
import com.vaadin.flow.component.datepicker.DatePicker
import com.vaadin.flow.component.dependency.CssImport
import com.vaadin.flow.component.html.Span
import com.vaadin.flow.component.notification.Notification
import com.vaadin.flow.component.orderedlayout.HorizontalLayout
import com.vaadin.flow.component.orderedlayout.VerticalLayout
import com.vaadin.flow.component.textfield.NumberField
import com.vaadin.flow.component.textfield.TextArea
import com.vaadin.flow.component.textfield.TextField
import com.vaadin.flow.router.Route

/**
 * The main view contains a button and a click listener.
 */
@Route("3 form")
@CssImport.Container(
    value = [  // repeatable annotations are not supported by Kotlin, please vote for https://youtrack.jetbrains.com/issue/KT-12794
        CssImport("./styles/shared-styles.css"),
        CssImport(value = "./styles/vaadin-text-field-styles.css", themeFor = "vaadin-text-field")
    ]
)
class MainView3 : VerticalLayout() {
    init {
        add(ProductForm())
    }
}

class ProductForm : VerticalLayout() {
    private val name = TextField("Name")
    private val desc = TextArea("Description")
    private val price = NumberField("Price")
    private val priceSfx = Span("€")

    // 0.0.1 ???
    private val avail = DatePicker("Availability")
    private val cat = ComboBox<String>("Category")
    private val btnSave = Button("Save")
    private val btnCancel = Button("Cancel")

    init {
        name.addValueChangeListener {
            println("value for ${it.source.label} has changed from ${it.oldValue} to ${it.value}")
        }
        price.addInputListener {
            println("input for ${it.source.element.getProperty("label")} has changed to ${it.source.element.getProperty("value")}")
        }
        price.addValueChangeListener {
            println("value for ${it.source.label} has changed from ${it.oldValue} to ${it.value}")
        }
        desc.addValueChangeListener {
            println("value for ${it.source.label} has changed from ${it.oldValue} to ${it.value}")
        }
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
