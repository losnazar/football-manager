package com.example.footballmanager.mapper;

public interface RequestMapper<T, K> {
    T toModel(K dto);
}
