package org.yearup.managers;

import org.yearup.models.Dealership;
import org.yearup.models.Vehicle;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class DealershipFileManager
{
    private static final String fileName = "inventory.csv";

    public static Dealership getDealership()
    {
        Dealership dealership = new Dealership();
        FileInputStream fileStream = null;
        Scanner scanner = null;
        String dealerName;
        String address;
        String phone;
        int vin;
        int year;
        String make;
        String model;
        String vehicleType;
        String color;
        int odometer;
        double price;

        try
        {
            fileStream = new FileInputStream(fileName);
            scanner = new Scanner(fileStream);
            int lineCount = 0;

            // Loop through file
            while(scanner.hasNextLine())
            {
                String line = scanner.nextLine();
                String[] columns = line.split("\\|");

                // First line has Dealership info
                if(lineCount == 0)
                {
                    dealerName = columns[0];
                    address = columns[1];
                    phone = columns[2];
                    dealership = new Dealership(dealerName, address, phone);
                }
                // Rest are vehicles
                else
                {
                    vin = Integer.parseInt(columns[0]);
                    year = Integer.parseInt(columns[1]);
                    make = columns[2];
                    model = columns[3];
                    vehicleType = columns[4];
                    color = columns[5];
                    odometer = Integer.parseInt(columns[6]);
                    price = Double.parseDouble(columns[7]);

                    Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
                    dealership.addVehicle(vehicle);
                }

                lineCount++;
            }
        }
        catch (IOException e)
        {
            e.getMessage();
        }
        finally
        {
            try
            {
                if (fileStream != null)
                {
                    fileStream.close();
                }
            }
            catch (IOException e)
            {
                // If can't close file
            }
            if (scanner != null)
            {
                scanner.close();
            }
        }
        return dealership;
    }

    public static void saveDealership(Dealership dealership)
    {

    }
}
