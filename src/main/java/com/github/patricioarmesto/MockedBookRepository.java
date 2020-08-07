package com.github.patricioarmesto;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;

public class MockedBookRepository implements BookRepository {

  private Map<String, Book> books;

  public MockedBookRepository() {
    books = initData();
  }

  @Override
  public List<Book> findAll() {
    return books.values().stream().collect(toList());
  }


  private Map<String, Book> initData() {
    Stream<Book> stream = Stream.<Book>builder()
      .add(new Book("1", "Book 1", 1))
      .add(new Book("2", "Book 2", 2))
      .add(new Book("3", "Book 3", 3))
      .build();

    return stream.collect(toMap(Book::getId, book -> book));
  }
}
