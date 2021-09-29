package at.co.sdt.herb.vaadin.experiment

import com.vaadin.flow.component.html.H2
import com.vaadin.flow.component.html.Image
import com.vaadin.flow.component.html.Paragraph
import com.vaadin.flow.component.orderedlayout.FlexComponent
import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode
import com.vaadin.flow.component.orderedlayout.VerticalLayout
import com.vaadin.flow.router.Route

@Route("7 list")
class ListView : VerticalLayout() {
    init {
        val img = Image("images/empty-plant.png", "placeholder plant")
        img.width = "200px"
        add(img)

        add(H2("This place intentionally left empty"))
        add(Paragraph("It’s a place where you can grow your own UI 🤗"))

        setSizeFull()
        justifyContentMode = JustifyContentMode.CENTER
        defaultHorizontalComponentAlignment = FlexComponent.Alignment.CENTER
        style["text-align"] = "center"
    }
}