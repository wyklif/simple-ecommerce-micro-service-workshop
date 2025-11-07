package com.cliff.ecommerce.payment;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;

@Validated
public record Customer(
       String id,
       @NotNull(message = "Firstname cannot be null")
       String firstname,
       @NotNull(message = "Firstname cannot be null")
       String lastname,
       @NotNull(message = "Firstname cannot be null")
       @Email(message = "The customer email is not valid")
       String email
) {
}
