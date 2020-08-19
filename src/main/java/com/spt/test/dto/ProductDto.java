package com.spt.test.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class ProductDto {

    @NotBlank
    private String name;

    @Pattern(regexp = "(^[0-9]{13})", message = "должен содержать только цифры. длина строки 13 символов")
    private String code;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
