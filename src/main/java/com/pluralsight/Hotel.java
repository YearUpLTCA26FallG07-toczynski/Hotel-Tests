
package com.pluralsight;

public class Hotel {

    private String name;
    private int numberOfSuites;
    private int numberOfRooms;
    private int bookedSuites;
    private int bookedBasicRooms;

    // Constructor 1
    public Hotel(String name, int numberOfSuites, int numberOfRooms) {
        this.name = name;
        this.numberOfSuites = numberOfSuites;
        this.numberOfRooms = numberOfRooms;
        this.bookedSuites = 0;
        this.bookedBasicRooms = 0;
    }

    // Constructor 2
    public Hotel(String name, int numberOfSuites, int numberOfRooms,
                 int bookedSuites, int bookedBasicRooms) {

        if (numberOfSuites < 0 || numberOfRooms < 0
                || bookedSuites < 0 || bookedBasicRooms < 0
                || bookedSuites > numberOfSuites
                || bookedBasicRooms > numberOfRooms) {
            throw new IllegalArgumentException("Invalid room numbers.");
        }

        this.name = name;
        this.numberOfSuites = numberOfSuites;
        this.numberOfRooms = numberOfRooms;
        this.bookedSuites = bookedSuites;
        this.bookedBasicRooms = bookedBasicRooms;
    }

    // Book a room
    public boolean bookRoom(int roomCount, boolean suite) {

        if (roomCount <= 0) {
            return false;
        }

        if (suite) {
            if (getAvailableSuites() >= roomCount) {
                bookedSuites += roomCount;
                return true;
            }
        } else {
            if (getAvailableRooms() >= roomCount) {
                bookedBasicRooms += roomCount;
                return true;
            }
        }

        return false;
    }

    // Get available suites
    public int getAvailableSuites() {
        return numberOfSuites - bookedSuites;
    }

    // Get available basic rooms
    public int getAvailableRooms() {
        return numberOfRooms - bookedBasicRooms;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getNumberOfSuites() {
        return numberOfSuites;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public int getBookedSuites() {
        return bookedSuites;
    }

    public int getBookedBasicRooms() {
        return bookedBasicRooms;
    }
}