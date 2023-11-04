package com.pot.catalogservice.demo;

import com.pot.catalogservice.domain.Book;
import com.pot.catalogservice.domain.BookRepository;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Profile("testdata")
public class BookDataLoader {
    private final BookRepository bookRepository;
    public BookDataLoader(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    @EventListener(ApplicationReadyEvent.class)//Генерация тестовых данных запускается при отправке события ApplicationReadyEvent, то есть при завершении фазы запуска приложения
    public void loadBookTestData() {
        var book1 = new Book("1234567891", "Northern Lights",
                "Lyra Silverstar", 9.90);
        var book2 = new Book("1234567892", "Polar Journey",
                "Iorek Polarson", 12.90);
        bookRepository.save(book1);
        bookRepository.save(book2);
    }
}
