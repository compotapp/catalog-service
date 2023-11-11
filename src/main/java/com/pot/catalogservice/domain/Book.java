package com.pot.catalogservice.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

public record Book(
        @Id //Идентифицирует поле как первичный ключ для сущности
        Long id,

        @NotBlank(message = "The book ISBN must be defined.")
        @Pattern(
                regexp = "^([0-9]{10}|[0-9]{13})$",
                message = "The ISBN format must be valid."
        )
        String isbn,
        @NotBlank(message = "The book title must be defined.")
        String title,
        @NotBlank(message = "The book author must be defined.")
        String author,
        @NotNull(message = "The book price must be defined.")
        @Positive(message = "The book price must be greater than zero.")
        Double price,
        @Version //Номер версии объекта, который используется для оптимистической блокировки
        int version
) {
    public static Book of(String isbn, String title, String author, Double price) {
        return new Book(null, isbn, title, author, price, 0); //Объект считается новым, если его идентификатор равен нулю, а версия равна 0
    }
}




