package org.yearup.ui;

import org.yearup.ColorCodes;
import org.yearup.managers.DealershipFileManager;
import org.yearup.models.Dealership;
import org.yearup.models.Vehicle;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface
{
    // Variables
    private Dealership dealership;
    private static Scanner scanner = new Scanner(System.in);

    // Constructor
    public UserInterface()
    {

    }

    // Load dealership
    private void init()
    {
        DealershipFileManager fileManager = new DealershipFileManager();
        this.dealership = fileManager.getDealership();
        System.out.println("\nTravelling to " + dealership.getName() + "...");
    }

    // Methods
    public void display()
    {
        init();

        while(true)
        {
            System.out.println("\n" + ColorCodes.BLACK_BACKGROUND + "---------- WELCOME TO THE DEALERSHIP ----------" + ColorCodes.RESET + "\n");
            System.out.println("What would you like to do?");
            System.out.println();
            System.out.println("1) Search Vehicle by Price");
            System.out.println("2) Search Vehicle by Make/Model");
            System.out.println("3) Search Vehicle by Year");
            System.out.println("4) Search Vehicle by Color");
            System.out.println("5) Search Vehicle by Mileage");
            System.out.println("6) Search Vehicle by Type");
            System.out.println("7) List All Vehicles");
            System.out.println("8) Add a Vehicle");
            System.out.println("9) Remove a Vehicle");
            System.out.println("0) Exit");
            System.out.println();

            System.out.print("Enter an option: ");
            int option = Integer.parseInt(scanner.nextLine());

            switch(option)
            {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    // Price
                    // processGetByPriceRequest();
                    break;
                case 2:
                    // Make/Model
                    break;
                case 3:
                    // Year
                    break;
                case 4:
                    // Color
                    break;
                case 5:
                    // Mileage
                    break;
                case 6:
                    // Type
                    break;
                case 7:
                    // List all
                    processGetAllVehiclesRequest();
                    break;
                case 8:
                    // Add vehicle
                    break;
                case 9:
                    // Remove vehicle
                    break;
            }

        }
    }

    public void printLabels()
    {
        System.out.println("------------------------------------------------------------------------------");
        System.out.println(" VIN    YEAR   MAKE     MODEL      TYPE       COLOR      MILES         PRICE");
        System.out.println("------------------------------------------------------------------------------");
    }

    public void printEntry(Vehicle v)
    {
        System.out.printf("%-7d %-6d %-8s %-10s %-10s %-10s %-10d $ %8.2f\n", v.getVin(), v.getYear(), v.getMake(), v.getModel(), v.getVehicleType(), v.getColor(), v.getOdometer(), v.getPrice());
        System.out.println("------------------------------------------------------------------------------");
    }

    public void displayVehicles(ArrayList<Vehicle> vehicles)
    {
        printLabels();
        for(Vehicle v : vehicles)
        {
            printEntry(v);
        }
    }

    public void processGetByPriceRequest(double min, double max)
    {
        dealership.getVehiclesByPrice(min, max);
    }

    public void processGetByMakeModelRequest()
    {
        dealership.getVehiclesByMakeModel("make", "model");
    }

    public void processGetByYearRequest()
    {
        dealership.getVehiclesByYear(2000, 2030);
    }

    public void processGetByColorRequest()
    {
        dealership.getVehiclesByColor("Red");
    }

    public void processGetByMileageRequest()
    {

    }

    public void processGetByVehicleTypeRequest()
    {

    }

    public void processGetAllVehiclesRequest()
    {
        displayVehicles(dealership.getAllVehicles());
    }

    public void processAddVehicleRequest()
    {

    }

    public void processRemoveVehicleRequest()
    {

    }

}
