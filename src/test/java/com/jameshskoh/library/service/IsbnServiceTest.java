package com.jameshskoh.library.service;

import static org.mockito.Mockito.when;

import com.jameshskoh.library.model.Isbn;
import com.jameshskoh.library.repository.IsbnRepository;
import jakarta.persistence.EntityExistsException;
import java.util.List;
import java.util.Optional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class IsbnServiceTest {

  @InjectMocks private IsbnService isbnService;

  @Mock private IsbnRepository isbnRepository;

  @Test
  void createIsbn_givenNewIsbn_shouldInsertIsbn() {
    // mock
    Isbn newIsbn = new Isbn("12-123-12345-12-1", "Existing Test Book", "Existing Author");
    when(isbnRepository.findById(newIsbn.getId())).thenReturn(Optional.empty());
    when(isbnRepository.save(newIsbn)).thenReturn(newIsbn);

    // given, when
    Isbn result = isbnService.createIsbn(newIsbn);

    // then
    Assertions.assertThat(result).isEqualTo(newIsbn);
  }

  @Test
  void createIsbn_givenExistingIsbn_shouldThrowEntityExistsException() {
    // mock
    Isbn existingIsbn = new Isbn("12-123-12345-12-1", "Existing Test Book", "Existing Author");
    when(isbnRepository.findById(existingIsbn.getId())).thenReturn(Optional.of(existingIsbn));

    // given, when, then
    Assertions.assertThatThrownBy(() -> isbnService.createIsbn(existingIsbn))
        .isInstanceOf(EntityExistsException.class)
        .hasMessageContaining("ISBN")
        .hasMessageContaining("12-123-12345-12-1");
  }

  @Test
  void getAllIsbns_shouldReturnAllIsbns() {
    // mock
    Isbn isbn1 = new Isbn("12-123-12345-12-1", "Existing Test Book 1", "Existing Author 1");
    Isbn isbn2 = new Isbn("12-123-12345-12-2", "Existing Test Book 2", "Existing Author 2");
    when(isbnRepository.findAll()).thenReturn(List.of(isbn1, isbn2));

    // given
    List<Isbn> result = isbnService.getAllIsbns();

    // when, then
    Assertions.assertThat(result).containsExactly(isbn1, isbn2);
  }
}
