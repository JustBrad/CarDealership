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
        return null;
    }

    public ArrayList<Vehicle> getVehiclesByMakeModel(String make, String model)
    {
        return null;
    }

    public ArrayList<Vehicle> getVehiclesByYear(int min, int max)
    {
        return null;
    }

    public ArrayList<Vehicle> getVehiclesByColor(String color)
    {
        return null;
    }

    public ArrayList<Vehicle> getVehiclesByMileage(int min, int max)
    {
        return null;
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
