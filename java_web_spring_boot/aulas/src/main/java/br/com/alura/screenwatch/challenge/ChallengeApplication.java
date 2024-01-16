package br.com.alura.screenwatch.challenge;

import br.com.alura.screenwatch.aulas.main.ClassMain;
import br.com.alura.screenwatch.challenge.main.Main;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ChallengeApplication implements CommandLineRunner {
    public static void main(String[] args) {
    }

    @Override
    public void run(String... args) throws Exception {
        Main main = new Main();
        main.run();
    }
}