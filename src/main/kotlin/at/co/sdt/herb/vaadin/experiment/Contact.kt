package at.co.sdt.herb.vaadin.experiment

data class Contact(
    var firstName: String = "",
    var lastName: String = ""
) {

    /*
        @ManyToOne
        @JoinColumn(name = "company_id")
        @JsonIgnoreProperties(["employees"])
        var company: @NotNull Company? = null

        @ManyToOne
        var status: @NotNull Status? = null
        var email: @Email @NotEmpty String? = ""
    */
    override fun toString(): String {
        return "$firstName $lastName"
    }
}
