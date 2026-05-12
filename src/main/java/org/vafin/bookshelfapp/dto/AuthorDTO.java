package org.vafin.bookshelfapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.vafin.bookshelfapp.model.Author;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthorDTO {
    Long id;
    String name;
    String country;


    public static AuthorDTO from(Author author){
        AuthorDTO dto = new AuthorDTO();
        dto.setId(author.getId());
        dto.setName(author.getName());
        dto.setCountry(author.getCountry());
        return dto;
    }
}
