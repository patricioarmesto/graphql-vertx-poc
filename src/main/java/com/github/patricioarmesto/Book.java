package com.github.patricioarmesto;

public class Book {

  private String id;
  private String name;
  private int authorId;

  public Book(String id, String name, int authorId) {
    this.id = id;
    this.name = name;
    this.authorId = authorId;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAuthorId() {
    return authorId;
  }

  public void setAuthorId(int authorId) {
    this.authorId = authorId;
  }
}
