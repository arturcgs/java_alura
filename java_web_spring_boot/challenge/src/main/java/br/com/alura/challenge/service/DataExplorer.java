package br.com.alura.challenge.service;

import br.com.alura.challenge.model.Data;

import java.util.List;

public class DataExplorer {
    public boolean isCodeNotPresent(List<Data> list, String userChoice) {
        return list.stream().noneMatch(b -> b.code().equalsIgnoreCase(userChoice));
    }

}
