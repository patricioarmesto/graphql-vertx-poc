package com.github.patricioarmesto;

import com.google.inject.AbstractModule;
import io.vertx.core.Vertx;

public class BootstrapBinder extends AbstractModule {

  private final Vertx vertx;

  public BootstrapBinder(Vertx vertx) {
    this.vertx = vertx;
  }


  @Override
  protected void configure() {
    bind(BookRepository.class).to(MockedBookRepository.class);
  }

}
