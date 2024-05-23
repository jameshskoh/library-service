package com.jameshskoh.library.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.jameshskoh.library.dto.book.CreateRequestDTO;
import com.jameshskoh.library.model.Book;
import com.jameshskoh.library.model.Isbn;
import com.jameshskoh.library.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(BookController.class)
class BookControllerTest {

  @Autowired private MockMvc mockMvc;

  @MockBean private BookService bookService;

  @Test
  void createBook() throws Exception {

    Isbn isbn = new Isbn("12-123-12345-12-1", "A Title", "An Author");
    Book createdBook = new Book(201L, isbn, null);

    CreateRequestDTO dto = new CreateRequestDTO("12-123-12345-12-1");
    when(bookService.createBook(dto)).thenReturn(createdBook);

    String payload = """
{
    "isbn": "12-123-12345-12-1"
}""";

    mockMvc
        .perform(post("/books/create").contentType(MediaType.APPLICATION_JSON).content(payload))
        .andExpect(status().isCreated())
        .andReturn();
  }
}
