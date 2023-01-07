package com.example.graphqlservice.input;

import java.util.Set;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CreateBookInput {
    @NotBlank
    private String id;
    @NotBlank
    private String name;
    private int pageCount;
    private Set<CreateAuthorInput> authors;
}
