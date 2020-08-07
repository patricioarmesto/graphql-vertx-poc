package com.github.patricioarmesto;

import graphql.kickstart.tools.GraphQLQueryResolver;

import java.util.List;

class Query implements GraphQLQueryResolver {

  private BookRepository bookRepository;

  public Query(BookRepository bookRepository) {
    this.bookRepository = bookRepository;
  }

  public List<Book> books() {
    return bookRepository.findAll();
  }
}
