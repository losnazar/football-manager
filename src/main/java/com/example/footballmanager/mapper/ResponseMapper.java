package com.example.footballmanager.mapper;

public interface ResponseMapper<T, K> {
    T toDto(K model);
}
