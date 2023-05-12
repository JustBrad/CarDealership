package org.yearup.ui;

import org.yearup.ColorCodes;
import org.yearup.managers.DealershipFileManager;
import org.yearup.models.Dealership;

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
        dealership = fileManager.getDealership();
        System.out.println("\n" + dealership.getName() + " has been loaded.");
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
                case 2:
                    // Make/Model
                case 3:
                    // Year
                case 4:
                    // Color
                case 5:
                    // Mileage
                case 6:
                    // Type
                case 7:
                    // List all
                case 8:
                    // Add vehicle
                case 9:
                    // Remove vehicle
            }

        }
    }

    public void processGetByPriceRequest()
    {
        dealership.getVehiclesByPrice(0, 100);
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

    }

    public void processGetByMileageRequest()
    {

    }

    public void processGetByVehicleTypeRequest()
    {

    }

    public void processGetAllVehiclesRequest()
    {

    }

    public void processAddVehicleRequest()
    {

    }

    public void processRemoveVehicleRequest()
    {

    }

}
