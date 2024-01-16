package br.com.alura.screenwatch.aulas.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ShowData(@JsonAlias("Title") String title,
                       @JsonAlias("totalSeasons") Integer totalSeasons,
                       @JsonAlias("Year") String year,
                       @JsonAlias("imdbRating") Double rating) {
}
