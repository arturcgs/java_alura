package br.com.alura.screenwatch.aulas.service;

public interface IDataConverter {
    <T> T getData(String json, Class<T> c);
}
