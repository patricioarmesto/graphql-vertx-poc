package com.github.patricioarmesto;

import graphql.GraphQL;
import graphql.kickstart.tools.SchemaParser;
import graphql.schema.GraphQLSchema;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.graphql.GraphQLHandler;

public class GraphQLVerticle extends AbstractVerticle {

  private BookRepository bookRepository = new MockedBookRepository();
  private AuthorRepository authorRepository;

  public static void main(String[] args) {
    Vertx vertx = Vertx.vertx(); // (1)
    vertx.deployVerticle(new GraphQLVerticle()); // (2)
  }

  @Override
  public void start() {

    GraphQL graphQL = setupGraphQL();
    GraphQLHandler graphQLHandler = GraphQLHandler.create(graphQL); // (1)

    Router router = Router.router(vertx);
    router.route("/graphql").handler(graphQLHandler); // (2)

    vertx.createHttpServer()
      .requestHandler(router)
      .listen(8080);
  }

  private GraphQL setupGraphQL() {

    String schema = vertx.fileSystem().readFileBlocking("tasks.graphqls").toString(); // (1)

    GraphQLSchema graphQLSchema = SchemaParser.newParser()
      .schemaString(schema)
      .resolvers(new Query(bookRepository), new BookResolver(authorRepository))
      .build()
      .makeExecutableSchema();

    return GraphQL.newGraphQL(graphQLSchema).build(); // (5)
  }

}
