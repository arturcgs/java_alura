package br.com.alura.challenge.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;

import java.util.ArrayList;
import java.util.List;

public class DataConverter implements IDataConverter{
    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    public <T> T getData(String json, Class<T> c) {
        try {
            return mapper.readValue(json, c);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public <T> List<T> getDataList(String json, Class<T> c) {
        try {
            return mapper.readValue(json, TypeFactory.defaultInstance().constructParametrizedType(ArrayList.class, List.class, c));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
