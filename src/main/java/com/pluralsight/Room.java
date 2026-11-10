
package com.pluralsight;

public class Room {

    private int numberOfBeds;
    private double price;
    private boolean occupied;
    private boolean dirty;

    public Room(int numberOfBeds, double price,
                boolean occupied, boolean dirty) {

        this.numberOfBeds = numberOfBeds;
        this.price = price;
        this.occupied = occupied;
        this.dirty = dirty;
    }

    // Getters
    public int getNumberOfBeds() {
        return numberOfBeds;
    }

    public double getPrice() {
        return price;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public boolean isDirty() {
        return dirty;
    }

    public boolean isAvailable() {
        return !occupied && !dirty;
    }

    // Check in guest
    public void checkIn() {
        if (!occupied && !dirty) {
            occupied = true;
            dirty = true;
            System.out.println("Guest checked in.");
        } else {
            System.out.println("Room is not available.");
        }
    }

    // Check out guest
    public void checkOut() {
        if (occupied) {
            occupied = false;
            dirty = true;
            System.out.println("Guest checked out. Room needs cleaning.");
        } else {
            System.out.println("Room is already vacant.");
        }
    }

    // Clean room
    public void cleanRoom() {
        if (!occupied) {
            dirty = false;
            System.out.println("Room has been cleaned.");
        } else {
            System.out.println("Cannot clean an occupied room.");
        }
    }
}
