package com.example.app1.models;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompraForm {
    @NotEmpty
    @Min(1L)
    private double precio;
    @NotEmpty
    private String desc;

}
