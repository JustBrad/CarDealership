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
        dealership = DealershipFileManager.getDealership();
    }

    // Methods
    public void display()
    {
        while(true)
        {
            System.out.println("\n" + ColorCodes.BLACK_BACKGROUND + "---------- WELCOME TO THE DEALERSHIP ----------" + ColorCodes.RESET + "\n");
            System.out.println("What would you like to do?");
            System.out.println("");

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
