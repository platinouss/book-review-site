package com.platinouss.bookrecommend.service;

import com.platinouss.bookrecommend.domain.Author;
import com.platinouss.bookrecommend.domain.Book;
import com.platinouss.bookrecommend.domain.BookAndAuthor;
import com.platinouss.bookrecommend.domain.Publisher;
import com.platinouss.bookrecommend.naver.dto.NaverBookDto;
import com.platinouss.bookrecommend.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    private final PublisherService publisherService;
    private final AuthorService authorService;
    private final BookAndAuthorService bookAndAuthorService;

    public Book add(NaverBookDto bookDto) {
        if(bookRepository.findBookByIsbn(bookDto.getIsbn()).isPresent()) {
            return bookRepository.findBookByIsbn(bookDto.getIsbn()).get();
        }

        Book book = Book.builder()
                .name(bookDto.getTitle()).category(bookDto.getCategory()).imageLink(bookDto.getImage())
                .isbn(bookDto.getIsbn()).pubdate(bookDto.getPubdate())
                .description(bookDto.getDescription())
                .reviews(new ArrayList<>())
                .bookAndAuthors(new ArrayList<>())
                .build();

        Publisher publisher = publisherService.add(bookDto.getPublisher());
        Author author = authorService.add(bookDto.getAuthor());
        BookAndAuthor bookAndAuthor = bookAndAuthorService.add(book, author);

        author.getBookAndAuthors().add(bookAndAuthor);

        book.setPublisher(publisher);
        book.getBookAndAuthors().add(bookAndAuthor);
        return bookRepository.save(book);
    }

    public Book find(String name) {
        return bookRepository.findByName(name)
                .orElseThrow(RuntimeException::new);
    }

    public Book find(Long id) {
        return bookRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    public List<Book> getAll() {
        return bookRepository.findAll();
    }
}
