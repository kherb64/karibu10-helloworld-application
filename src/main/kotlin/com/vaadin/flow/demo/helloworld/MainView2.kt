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
package com.vaadin.flow.demo.helloworld

import com.vaadin.flow.component.Key
import com.vaadin.flow.component.button.Button
import com.vaadin.flow.component.dependency.CssImport
import com.vaadin.flow.component.notification.Notification
import com.vaadin.flow.component.orderedlayout.VerticalLayout
import com.vaadin.flow.component.textfield.TextField
import com.vaadin.flow.router.Route

/**
 * The main view contains a button and a click listener.
 */
@Route("2")
@CssImport.Container(
    value = [  // repeatable annotations are not supported by Kotlin, please vote for https://youtrack.jetbrains.com/issue/KT-12794
        CssImport("./styles/shared-styles.css"),
        CssImport(value = "./styles/vaadin-text-field-styles.css", themeFor = "vaadin-text-field")
    ]
)
class MainView2 : VerticalLayout() {
    private var nameField: TextField = TextField("Your name2")
    private lateinit var greetButton: Button


    init {
        // Use custom CSS classes to apply styling. This is defined in shared-styles.css.
        addClassName("centered-content")

        // Use TextField for standard text input

        // Use Button for a clickable button
        greetButton = Button("Say hello2")
        {
            // ? this.addThemeVariants(ButtonVariant.LUMO_PRIMARY)
            addClickShortcut(Key.ENTER)
        }

        add(nameField, greetButton)

        // attach functionality to the UI components.
        // It's a good practice to keep UI functionality separated from UI definition.

        // Button click listeners can be defined as lambda expressions
        greetButton.addClickListener {
            // Notification.show("Hello, ${nameField.value}")
            Notification.show("Hello, ${nameField.value}", 5000, Notification.Position.MIDDLE)
        }
    }
}
