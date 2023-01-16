package org.iesvi.isara.bookManagement.infra.dto.converter;

import lombok.RequiredArgsConstructor;
import org.iesvi.isara.bookManagement.domain.Book;
import org.iesvi.isara.bookManagement.infra.dto.BookDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class BookDTOConverter {
    private static final ModelMapper modelMapper = new ModelMapper();

    public static BookDTO convertToDto(Book book) {
        return modelMapper.map(book, BookDTO.class);
    }

    public static List<BookDTO> convertListToDto(List<Book> booksBd) {
        List<BookDTO> books = new ArrayList<>();
        for (Book b : booksBd) {
            books.add(modelMapper.map(b, BookDTO.class));
        }
        return books;
    }

    public static BookDTO convertToDto(Optional<Book> byId) {
        return modelMapper.map(byId, BookDTO.class);
    }
}
