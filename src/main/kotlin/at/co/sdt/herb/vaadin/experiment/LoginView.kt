package at.co.sdt.herb.vaadin.experiment

import com.vaadin.flow.component.html.H1
import com.vaadin.flow.component.login.LoginForm
import com.vaadin.flow.component.orderedlayout.FlexComponent
import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode
import com.vaadin.flow.component.orderedlayout.VerticalLayout
import com.vaadin.flow.router.BeforeEnterEvent
import com.vaadin.flow.router.BeforeEnterObserver
import com.vaadin.flow.router.PageTitle
import com.vaadin.flow.router.Route


@Route("6 login")
@PageTitle("Login | Vaadin CRM")
class LoginView: VerticalLayout(), BeforeEnterObserver {
    private val login = LoginForm()

    init {
        addClassName("login-view")
        setSizeFull()
        alignItems = FlexComponent.Alignment.CENTER
        justifyContentMode = JustifyContentMode.CENTER
        login.action = "6 login"
        add(H1("Vaadin CRM"), login)
    }

    override fun beforeEnter(beforeEnterEvent: BeforeEnterEvent) {
        // inform the user about an authentication error
        if (beforeEnterEvent.location
                .queryParameters
                .parameters
                .containsKey("error")
        ) {
            login.isError = true
        }
    }
}