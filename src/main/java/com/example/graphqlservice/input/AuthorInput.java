package com.example.graphqlservice.input;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AuthorInput {
    private String firstName;
    @NotBlank
    private String lastName;

}
