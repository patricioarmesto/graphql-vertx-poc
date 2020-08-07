package com.github.patricioarmesto;

import java.util.List;

public interface BookRepository {
  List<Book> findAll();
}
