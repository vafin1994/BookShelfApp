package org.vafin.bookshelfapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.vafin.bookshelfapp.model.Book;

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

    public static BookDTO from(Book book) {
        BookDTO dto = new BookDTO();
        dto.setId(book.getId());
        dto.setTitle(book.getTitle());
        dto.setIsbn(book.getIsbn());
        dto.setGenre(book.getGenre());
        dto.setPublishingYear(book.getPublishingYear());
        dto.setLanguage(book.getLanguage());
        if (book.getAuthor() != null) {
            dto.setAuthorId(book.getAuthor().getId());
            dto.setAuthorName(book.getAuthor().getName());
        }
        return dto;
    }
}
