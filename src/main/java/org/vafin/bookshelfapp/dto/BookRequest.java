package org.vafin.bookshelfapp.dto;

import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BookRequest {
    @NotBlank(message = "Title is required")
    String title;
    Long authorId;
    @Pattern(regexp = "^(?:\\d{10}|\\d{13})$", message = "ISBN must be 10 or 13 digits")
    String isbn;
    String genre;
    @Min(value = 1450, message = "Publishing year must be after 1450")
    @Max(value = 2100, message = "Publishing year seems to far in the future")
    Integer publishingYear;
    @Size(max = 50, message = "Language must be 50 characters or less")
    String language;
}
