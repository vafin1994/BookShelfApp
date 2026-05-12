package org.vafin.bookshelfapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookDTO {
    Long id;
    String title;
    Long authorId;
    String authorName;
    String isbn;
    String genre;
    Integer publishingYear;
    String language;
}
