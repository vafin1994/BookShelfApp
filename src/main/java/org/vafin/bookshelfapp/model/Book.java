package org.vafin.bookshelfapp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotBlank(message = "Title is required")
    private String title;
    @NotBlank(message = "Author is required")
    private String author;
    @Column(length = 13, unique = true)
    @Pattern(regexp = "^(?:\\d{10}|\\d{13})$", message = "ISBN must be 10 or 13 digits")
    private String isbn;
    private String genre;
    @Min(value=1450, message = "Publishing year must be after 1450")
    @Max(value = 2100, message = "Publishing year seems to far in the future")
    private Integer publishingYear;
    @Column(length = 50)
    @Size(max = 50, message = "Language must be 50 characters or less")
    private String language;
}
