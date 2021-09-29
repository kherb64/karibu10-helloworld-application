package at.co.sdt.herb.vaadin.experiment

import com.vaadin.flow.component.button.Button
import com.vaadin.flow.component.dependency.CssImport
import com.vaadin.flow.component.dialog.Dialog
import com.vaadin.flow.component.html.Paragraph
import com.vaadin.flow.component.notification.Notification
import com.vaadin.flow.component.orderedlayout.FlexComponent
import com.vaadin.flow.component.orderedlayout.FlexLayout
import com.vaadin.flow.component.orderedlayout.HorizontalLayout
import com.vaadin.flow.component.orderedlayout.VerticalLayout
import com.vaadin.flow.router.Route

@Route("5 dialog")
@CssImport.Container(
    value = [  // repeatable annotations are not supported by Kotlin, please vote for https://youtrack.jetbrains.com/issue/KT-12794
        CssImport("./styles/shared-styles.css"),
        CssImport(value = "./styles/vaadin-text-field-styles.css", themeFor = "vaadin-text-field")
    ]
)
class MainView5 : VerticalLayout() {
    private val btnDialog = Button("Dialog")
    private val confirmDialog = ConfirmDialog()

    init {
        btnDialog.addClickListener {
            confirmDialog.open()
        }
        add(btnDialog)
    }
}

class ConfirmDialog : Dialog() {
    private val confirmText = Paragraph("Are you sure you want to leave this page?")
    private val confirmButton = Button("Confirm")
    private val cancelButton = Button("Cancel")

    // Add a FlexLayout wrapper for the element you want to right align
    private val cancelButtonWrapper = FlexLayout(cancelButton)

    // Create the HorizontalLayout and expand the wrapper component
    private val dialogButtons = HorizontalLayout(confirmButton, cancelButtonWrapper)

    init {
        confirmButton.addClickListener {
            Notification.show("Confirmed", 2500, Notification.Position.MIDDLE)
            close()
        }
        cancelButton.addClickListener { close() }

        // Set the wrapper flex alignment to end (right)
        cancelButtonWrapper.justifyContentMode = FlexComponent.JustifyContentMode.END
        dialogButtons.expand(cancelButtonWrapper)

        // Add the components to the dialog
        add(confirmText, dialogButtons)
        isCloseOnEsc = true
        isCloseOnOutsideClick = false
    }
}