package br.com.alura.challenge.main;

import br.com.alura.challenge.model.Data;
import br.com.alura.challenge.model.ModelsData;
import br.com.alura.challenge.model.VehicleData;
import br.com.alura.challenge.service.ApiHandler;
import br.com.alura.challenge.service.DataConverter;
import br.com.alura.challenge.service.DataExplorer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    // Declare Variables
    private final String API_ADDRESS = "https://parallelum.com.br/fipe/api/v1/";

    public void runApplication() {
        // Start Useful Objects
        Scanner scanner = new Scanner(System.in);
        ApiHandler apiHandler = new ApiHandler();
        DataConverter dataConverter = new DataConverter();
        ObjectMapper mapper = new ObjectMapper();
        DataExplorer dataExplorer = new DataExplorer();

        // Welcome Message
        System.out.println("""
                                
                ************************************************
                Welcome! Choose on of the following options:
                (please type the number)
                1 - Carros
                2 - Motos
                3 - Caminhões
                ************************************************
                """);
        String vehicleOption = scanner.nextLine();

        // Process selection
        if (vehicleOption.equalsIgnoreCase("1")) {
            vehicleOption = "carros";
        } else if (vehicleOption.equalsIgnoreCase("2")) {
            vehicleOption = "motos";
        } else if (vehicleOption.equalsIgnoreCase("3")) {
            vehicleOption = "caminhoes";
        } else {
            System.out.println(vehicleOption + " is not a valid choice!");
            return;
        }

        // get vehicle brands from API
        String fullApiAddress = API_ADDRESS + vehicleOption + "/marcas";
        String vehicleJson = apiHandler.getJson(fullApiAddress);
        List<Data> allBrands= dataConverter.getDataList(vehicleJson, Data.class);

        // prints brands and ask user to choose
        System.out.println("""
                
                ************************************************
                Select e vehicle brand
                (please type the brand's code):""");
        allBrands.forEach(b -> System.out.println("Code: " + b.code() + " == Name: " + b.name()));
        System.out.println("************************************************");
        String brandChoice = scanner.nextLine();


        // check if brandChoice is an actual choice
        if (dataExplorer.isCodeNotPresent(allBrands, brandChoice)) {
            System.out.println(brandChoice + " is not a valid choice.");
            return;
        }

        // get brand vehicle models
        fullApiAddress = fullApiAddress + "/" + brandChoice + "/modelos";
        String modelsJson = apiHandler.getJson(fullApiAddress);
        ModelsData allModels = dataConverter.getData(modelsJson, ModelsData.class);
        System.out.println("""
                
                ************************************************
                Select a vehicle model:
                (please type the model's code):
                """);
        allModels.allModels().forEach(m -> System.out.println("Code: " + m.code() + "== Name: " + m.name()));
        System.out.println("************************************************");
        String modelChoice = scanner.nextLine();

        // check if modelChoice is an actual choice
        if (dataExplorer.isCodeNotPresent(allModels.allModels(), modelChoice)) {
            System.out.println(modelChoice + " is not a valid choice.");
            return;
        }

        // get all years objects
        // get data from api
        fullApiAddress = fullApiAddress + "/" + modelChoice + "/anos";
        String modelYearsJson = apiHandler.getJson(fullApiAddress);
        List<Data> allModelYears = dataConverter.getDataList(modelYearsJson, Data.class);

        // get data for each year information
        ArrayList<VehicleData> allVehicles = new ArrayList<VehicleData>();
        for (Data modelYear: allModelYears) {
            String fullApiAddressForModelYear = fullApiAddress + "/" + modelYear.code();
            String modelYearJson = apiHandler.getJson(fullApiAddressForModelYear);
            VehicleData vehicleData = dataConverter.getData(modelYearJson, VehicleData.class);
            allVehicles.add(vehicleData);
        }

        allVehicles.forEach(v -> System.out.printf("""
                                
                ************************************************
                Model: %s
                Brand: %s
                Year: %s
                Price: %s
                Fuel: %s
                FIPE code: %s
                ************************************************
                """, v.model(), v.brand(), v.year(), v.price(), v.fuel(), v.fipeCode()));









    }
}
