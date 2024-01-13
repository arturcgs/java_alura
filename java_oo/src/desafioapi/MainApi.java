package desafioapi;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class MainApi {
    public static void main(String[] args) throws IOException, InterruptedException {
        // ask user for cep
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o CEP desejado: ");
        String cep = scanner.nextLine();

        // getting cep information
        ApiHandler apiHandler = new ApiHandler(cep);
        String addressString = apiHandler.getCepJson();

        // turn into address object
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        AddressApi myAddressApi = gson.fromJson(addressString, AddressApi.class);
        Address address = new Address(myAddressApi);

        // write to file
        File file = new File("json.txt");
        FileWriter writer = new FileWriter(file);
        writer.write(gson.toJson(address));
        writer.close();

    }
}
