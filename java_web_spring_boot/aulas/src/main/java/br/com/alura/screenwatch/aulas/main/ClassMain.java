package br.com.alura.screenwatch.aulas.main;

import br.com.alura.screenwatch.aulas.SeasonData;
import br.com.alura.screenwatch.aulas.ShowData;
import br.com.alura.screenwatch.aulas.model.Episode;
import br.com.alura.screenwatch.aulas.model.EpisodeData;
import br.com.alura.screenwatch.aulas.model.SeasonData;
import br.com.alura.screenwatch.aulas.model.ShowData;
import br.com.alura.screenwatch.aulas.service.ApiHandler;
import br.com.alura.screenwatch.aulas.service.ConvertData;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ClassMain {
    private Scanner scanner = new Scanner(System.in);
    private final String API_ADDRESS = "https://omdbapi.com/?t=";
    private final String API_KEY = "&apikey=2e65185a";
    private ApiHandler apiHandler = new ApiHandler();
    private ConvertData converter = new ConvertData();


    public void showMenu() {
        System.out.println("Type the show name: ");
        var showName = scanner.nextLine();

        // build API full address
        String showNameForAddress = showName.replace(" ", "+");
        String fullApiAddress = API_ADDRESS + showNameForAddress + API_KEY;

        // get json
        var json = apiHandler.getData(fullApiAddress);

        // turn json into show object
        var showData = converter.getData(json, ShowData.class);
        System.out.println(showData);

        // create list with seasons objects
        List<SeasonData> allSeasons = new ArrayList<>();

        for (int i = 1; i <= showData.totalSeasons(); i++) {
            fullApiAddress = API_ADDRESS + showNameForAddress + "&Season=" + i + API_KEY;
            json = apiHandler.getData(fullApiAddress);
            SeasonData seasonData = converter.getData(json, SeasonData.class);
            allSeasons.add(seasonData);
        }

        allSeasons.forEach(System.out::println);


        // show episode names
        // allSeasons.forEach(s -> s.episodes().forEach(e -> System.out.println(e.title())));

        // make list with all episodes
        List<EpisodeData> allEpisodes = allSeasons.stream()
                .flatMap(s -> s.episodes().stream())
                .collect(Collectors.toList());

        // allEpisodes.forEach(System.out::println);

        // print top 5 episodes
        allEpisodes.stream()
                .filter(e -> !e.review().equalsIgnoreCase("N/A"))
                .sorted(Comparator.comparing(EpisodeData::review).reversed())
                .limit(5)
                .forEach(System.out::println);

        // use Episode class
        List<Episode> episodes = allSeasons.stream()
                .flatMap(s -> s.episodes().stream()
                        .map(e -> new Episode(s.seasonNumber(), e)))
                .collect(Collectors.toList());

        episodes.forEach(System.out::println);




    }

}
