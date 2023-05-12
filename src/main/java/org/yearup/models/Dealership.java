package org.yearup.models;

import java.util.ArrayList;

public class Dealership
{
    // Variables
    private String name;
    private String address;
    private String phone;
    private ArrayList<Vehicle> inventory;

    // Constructors
    public Dealership(){}

    public Dealership(String name, String address, String phone)
    {
        this.name = name;
        this.address = address;
        this.phone = phone;
        inventory = new ArrayList<>();
    }

    // Methods
    public void addVehicle(Vehicle vehicle)
    {
        inventory.add(vehicle);
    }

    public void remove(Vehicle vehicle)
    {

    }
    public ArrayList<Vehicle> getAllVehicles()
    {
        return inventory;
    }

    public ArrayList<Vehicle> getVehiclesByPrice(double min, double max)
    {
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        for(Vehicle v : inventory)
        {
            if(v.getPrice() >= min && v.getPrice() <= max)
            {
                vehicles.add(v);
            }
        }
        return vehicles;
    }

    public ArrayList<Vehicle> getVehiclesByMakeModel(String make, String model)
    {
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        for(Vehicle v : inventory)
        {
            if(v.getMake().equalsIgnoreCase(make) && v.getModel().equalsIgnoreCase(model))
            {
                vehicles.add(v);
            }
        }
        return vehicles;
    }

    public ArrayList<Vehicle> getVehiclesByYear(int min, int max)
    {
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        for(Vehicle v : inventory)
        {
            if(v.getYear() >= min && v.getYear() <= max)
            {
                vehicles.add(v);
            }
        }
        return vehicles;
    }

    public ArrayList<Vehicle> getVehiclesByColor(String color)
    {
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        for(Vehicle v : inventory)
        {
            if(v.getColor().equalsIgnoreCase(color))
            {
                vehicles.add(v);
            }
        }
        return vehicles;
    }

    public ArrayList<Vehicle> getVehiclesByMileage(int min, int max)
    {
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        for(Vehicle v : inventory)
        {
            if(v.getOdometer() >= min && v.getOdometer() <= max)
            {
                vehicles.add(v);
            }
        }
        return vehicles;
    }

    public ArrayList<Vehicle> getVehiclesByType(String vehicleType)
    {
        return null;
    }

    // Getters & setters
    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }
}
