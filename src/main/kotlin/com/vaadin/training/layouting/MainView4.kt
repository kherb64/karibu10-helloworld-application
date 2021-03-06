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

import com.vaadin.flow.component.button.Button
import com.vaadin.flow.component.button.ButtonVariant
import com.vaadin.flow.component.combobox.ComboBox
import com.vaadin.flow.component.datepicker.DatePicker
import com.vaadin.flow.component.dependency.CssImport
import com.vaadin.flow.component.html.Span
import com.vaadin.flow.component.notification.Notification
import com.vaadin.flow.component.orderedlayout.FlexComponent
import com.vaadin.flow.component.orderedlayout.FlexLayout
import com.vaadin.flow.component.orderedlayout.HorizontalLayout
import com.vaadin.flow.component.orderedlayout.VerticalLayout
import com.vaadin.flow.component.textfield.NumberField
import com.vaadin.flow.component.textfield.TextArea
import com.vaadin.flow.component.textfield.TextField
import com.vaadin.flow.router.Route

/**
 * The main view contains a button and a click listener.
 */
@Route("4 flexform")
@CssImport.Container(
    value = [  // repeatable annotations are not supported by Kotlin, please vote for https://youtrack.jetbrains.com/issue/KT-12794
        CssImport("./styles/shared-styles.css"),
        CssImport(value = "./styles/vaadin-text-field-styles.css", themeFor = "vaadin-text-field")
    ]
)
class MainView4 : VerticalLayout() {
    init {
        add(ProductFlexForm())
    }
}

class ProductFlexForm : VerticalLayout() {
    private val name = TextField("Name")
    private val desc = TextArea("Description")
    private val price = NumberField("Price")
    private val priceSfx = Span("???")
    private val avail = DatePicker("Availability")
    private val cat = ComboBox<String>("Category")

    private val btnSave = Button("Save")
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

        val flex = FlexLayout(name, desc, price, priceSfx, avail, cat)
        flex.justifyContentMode = FlexComponent.JustifyContentMode.START
        flex.alignItems = FlexComponent.Alignment.BASELINE
        flex.flexWrap = FlexLayout.FlexWrap.WRAP

        add(flex, HorizontalLayout(btnSave, btnCancel))
    }
}