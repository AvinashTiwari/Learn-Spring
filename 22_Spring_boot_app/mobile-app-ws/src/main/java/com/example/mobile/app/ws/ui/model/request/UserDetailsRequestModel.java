package com.example.mobile.app.ws.ui.model.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserDetailsRequestModel {
    @NotNull(message = "First name missing or empty")
    @Size(min = 2  , message = "First Name must not be less the 2 character ")
    private String firstName;
    @NotNull(message = "Last name missing or empty")
    @Size(min = 2  , message = "Last Name must not be less the 2 character ")
    private String lastName;
    @NotNull(message = "Email missing or empty")
    @Email
    private String email;
    @NotNull(message = "Password missing or empty")
    @Size(min = 8 , max = 16, message = "Passsword Must be equal or greater then 8 character")
    private String password;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
