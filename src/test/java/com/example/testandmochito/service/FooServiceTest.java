package com.example.testandmochito.service;

import com.example.testandmochito.dto.FooDTO;
import com.example.testandmochito.entity.Foo;
import com.example.testandmochito.repository.FooRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FooServiceTest {

    private FooRepository fooRepository;
    private FooService fooService;

    private final Foo defaultFoo = new Foo(1L, "AA", "BB");

    private final FooDTO defaultFooDTO = FooDTO.builder().id(1L).field1("AA").field2("BB").build();

    @BeforeEach
    void setUp() {
        System.out.println("Load mock");
        fooRepository = Mockito.mock(FooRepository.class);
        fooService = new FooService(fooRepository);
        Mockito.when(fooRepository.findById(1L)).thenReturn(Optional.of(defaultFoo));
    }

    @Test
    void getById() {
        FooDTO fooDTO = fooService.getById(1L);
        assertEquals(defaultFooDTO, fooDTO);
        Mockito.verify(fooRepository).findById(1L);
    }

    @Test
    void getAll() {
    }
}