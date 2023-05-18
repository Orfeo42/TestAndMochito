package com.example.testandmochito.service;

import com.example.testandmochito.dto.FooDTO;
import com.example.testandmochito.entity.Foo;
import com.example.testandmochito.repository.FooRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class FooService {
    private final FooRepository fooRepository;

    public FooService(FooRepository fooRepository) {
        this.fooRepository = fooRepository;
    }

    public FooDTO getById(Long id) {

        return fooRepository.findById(id)
                .map(this::entityToDTO)
                .orElseThrow(() -> new RuntimeException("Foo non trovato"));
    }

    public List<FooDTO> getAll() {
        return StreamSupport.stream(fooRepository.findAll().spliterator(), false)
                .map(this::entityToDTO).collect(Collectors.toList());
    }

    private FooDTO entityToDTO(Foo foo) {
        return FooDTO.builder()
                .id(foo.getId())
                .field1(foo.getField1())
                .field2(foo.getField2())
                .build();
    }

}
