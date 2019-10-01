package user.service.controller;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.MediaType;

@Controller("/")
public class Index {

  @Get(produces=MediaType.TEXT_PLAIN)
  public String index() {
    return "halo semuanya";
  }

}
