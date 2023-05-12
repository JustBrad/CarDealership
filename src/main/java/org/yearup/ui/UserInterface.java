package org.yearup.ui;

import org.yearup.ColorCodes;
import org.yearup.managers.DealershipFileManager;
import org.yearup.models.Dealership;
import org.yearup.models.Vehicle;

import java.awt.*;
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
            printTitle("WELCOME TO " + dealership.getName().toUpperCase());
            System.out.println("What would you like to do?");
            System.out.println();
            System.out.println(ColorCodes.YELLOW + "1) Search Vehicle by Price");
            System.out.println("2) Search Vehicle by Make/Model");
            System.out.println("3) Search Vehicle by Year");
            System.out.println("4) Search Vehicle by Color");
            System.out.println("5) Search Vehicle by Mileage");
            System.out.println("6) Search Vehicle by Type");
            System.out.println(ColorCodes.CYAN + "7) List All Vehicles");
            System.out.println(ColorCodes.GREEN + "8) Add a Vehicle");
            System.out.println(ColorCodes.RED + "9) Remove a Vehicle");
            System.out.println(ColorCodes.PURPLE + "0) Exit" + ColorCodes.RESET);
            System.out.println();

            int option;
            while(true)
            {
                try
                {
                    System.out.print("Enter an option: ");
                    option = Integer.parseInt(scanner.nextLine().strip());
                    break;
                }
                catch(Exception e)
                {
                    printInvalid();
                }
            }

            switch(option)
            {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    // Price
                    processGetByPriceRequest();
                    break;
                case 2:
                    // Make/Model
                    processGetByMakeModelRequest();
                    break;
                case 3:
                    // Year
                    processGetByYearRequest();
                    break;
                case 4:
                    // Color
                    processGetByColorRequest();
                    break;
                case 5:
                    // Mileage
                    processGetByMileageRequest();
                    break;
                case 6:
                    // Type
                    processGetByVehicleTypeRequest();
                    break;
                case 7:
                    // List all
                    processGetAllVehiclesRequest();
                    break;
                case 8:
                    // Add vehicle
                    processAddVehicleRequest();
                    break;
                case 9:
                    // Remove vehicle
                    break;
            }

        }
    }

    public void printTitle(String title)
    {
        System.out.println("\n" + ColorCodes.BLACK_BACKGROUND + "---------- " + title.toUpperCase() +  " ----------" + ColorCodes.RESET + "\n");
    }

    public void printGreenMessage(String message)
    {
        System.out.println("\n" + ColorCodes.BLACK_BACKGROUND + ColorCodes.GREEN + message + ColorCodes.RESET + "\n");
    }

    public void printRedMessage(String message)
    {
        System.out.println("\n" + ColorCodes.BLACK_BACKGROUND + ColorCodes.RED + message + ColorCodes.RESET + "\n");
    }

    public void printInvalid()
    {
        System.out.println("\n" + ColorCodes.BLACK_BACKGROUND + ColorCodes.RED + "INVALID INPUT" + ColorCodes.RESET + "\n");
    }

    public void printLabels()
    {
        System.out.println(ColorCodes.BLACK_BACKGROUND + " VIN    YEAR   MAKE     MODEL      TYPE       COLOR      MILES         PRICE   " + ColorCodes.RESET);
        System.out.println("-------------------------------------------------------------------------------");
    }

    public void printEntry(Vehicle v)
    {
        System.out.printf("%-7d %-6d %-8s %-10s %-10s %-10s %-10d $ %9.2f\n", v.getVin(), v.getYear(), v.getMake(), v.getModel(), v.getVehicleType(), v.getColor(), v.getOdometer(), v.getPrice());
        System.out.println("-------------------------------------------------------------------------------");
    }

    public void displayVehicles(ArrayList<Vehicle> vehicles)
    {
        System.out.println();
        printLabels();
        for(Vehicle v : vehicles)
        {
            printEntry(v);
        }
    }

    public void processGetByPriceRequest()
    {
        printTitle("SEARCH BY PRICE");
        System.out.print("Enter minimum price: ");
        double min = Double.parseDouble(scanner.nextLine().strip());
        System.out.print("Enter maximum price: ");
        double max = Double.parseDouble(scanner.nextLine().strip());
        displayVehicles(dealership.getVehiclesByPrice(min, max));
    }

    public void processGetByMakeModelRequest()
    {
        printTitle("SEARCH BY MAKE/MODEL");
        System.out.print("Enter make: ");
        String make = scanner.nextLine().strip();
        System.out.print("Enter model: ");
        String model = scanner.nextLine().strip();
        displayVehicles(dealership.getVehiclesByMakeModel(make, model));
    }

    public void processGetByYearRequest()
    {
        printTitle("SEARCH BY YEAR");
        System.out.print("Enter minimum year: ");
        int min = Integer.parseInt(scanner.nextLine().strip());
        System.out.print("Enter maximum year: ");
        int max = Integer.parseInt(scanner.nextLine().strip());
        displayVehicles(dealership.getVehiclesByYear(min, max));
    }

    public void processGetByColorRequest()
    {
        printTitle("SEARCH BY COLOR");
        System.out.print("Enter color: ");
        String color = scanner.nextLine().strip();
        displayVehicles(dealership.getVehiclesByColor(color));
    }

    public void processGetByMileageRequest()
    {
        printTitle("SEARCH BY MILEAGE");
        System.out.print("Enter minimum miles: ");
        int min = Integer.parseInt(scanner.nextLine().strip());
        System.out.print("Enter maximum miles: ");
        int max = Integer.parseInt(scanner.nextLine().strip());
        displayVehicles(dealership.getVehiclesByMileage(min, max));
    }

    public void processGetByVehicleTypeRequest()
    {
        printTitle("SEARCH BY VEHICLE TYPE");
        System.out.print("Enter type: ");
        String type = scanner.nextLine().strip();
        displayVehicles(dealership.getVehiclesByType(type));
    }

    public void processGetAllVehiclesRequest()
    {
        displayVehicles(dealership.getAllVehicles());
    }

    public void processAddVehicleRequest()
    {
        printTitle("ADD A VEHICLE");
        int vin;
        int year;
        int odometer;
        double price;

        while(true)
        {
            try
            {
                System.out.print("Enter VIN: ");
                vin = Integer.parseInt(scanner.nextLine().strip());
                break;
            } catch (Exception e)
            {
                printInvalid();
            }
        }
        while(true)
        {
            try
            {
                System.out.print("Enter year: ");
                year = Integer.parseInt(scanner.nextLine().strip());
                break;
            }
            catch(Exception e)
            {
                printInvalid();
            }
        }
        System.out.print("Enter make: ");
        String make = scanner.nextLine().strip();
        System.out.print("Enter model: ");
        String model = scanner.nextLine().strip();
        System.out.print("Enter type: ");
        String type = scanner.nextLine().strip();
        System.out.print("Enter color: ");
        String color = scanner.nextLine().strip();
        while(true)
        {
            try
            {
                System.out.print("Enter mileage: ");
                odometer = Integer.parseInt(scanner.nextLine().strip());
                break;
            }
            catch(Exception e)
            {
                printInvalid();
            }
        }
        while(true)
        {
            try
            {
                System.out.print("Enter price: $");
                price = Double.parseDouble(scanner.nextLine().strip());
                break;
            }
            catch(Exception e)
            {
                printInvalid();
            }
        }

        Vehicle vehicle = new Vehicle(vin, year, make.toUpperCase(), model.toUpperCase(), type.toUpperCase(), color.toUpperCase(), odometer, price);
        dealership.addVehicle(vehicle);

        printGreenMessage("VEHICLE ADDED");
    }

    public void processRemoveVehicleRequest()
    {

    }

}
