package com.example.mobile.app.ws.ui.model.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UpdateUserDetailsRequestModel {
    @NotNull(message = "First name missing or empty")
    @Size(min = 2  , message = "First Name must not be less the 2 character ")
    private String firstName;
    @NotNull(message = "Last name missing or empty")
    @Size(min = 2  , message = "Last Name must not be less the 2 character ")
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
