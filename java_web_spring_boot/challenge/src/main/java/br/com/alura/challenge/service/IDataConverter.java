package br.com.alura.challenge.service;

public interface IDataConverter {
    <T> T getData(String json, Class<T> c);
}
