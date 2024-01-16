package br.com.alura.challenge.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record VehicleData(@JsonAlias("Valor") String price,
                          @JsonAlias("Modelo") String model,
                          @JsonAlias("AnoModelo") String year,
                          @JsonAlias("Combustivel") String fuel,
                          @JsonAlias("CodigoFipe") String fipeCode,
                          @JsonAlias("Marca") String brand ) {
}
