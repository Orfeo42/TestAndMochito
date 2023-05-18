package com.example.testandmochito.repository;

import com.example.testandmochito.entity.Foo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FooRepository extends CrudRepository<Foo, Long> {}
