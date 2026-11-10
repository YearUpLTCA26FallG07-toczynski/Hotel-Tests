
package com.pluralsight;

public class Main {

    public static void main(String[] args) {

        // Test Room
        Room room = new Room(2, 150.00, false, false);

        System.out.println("Room Beds: " + room.getNumberOfBeds());
        System.out.println("Room Price: $" + room.getPrice());
        System.out.println("Occupied: " + room.isOccupied());
        System.out.println("Dirty: " + room.isDirty());
        System.out.println("Available: " + room.isAvailable());

        // Test Room Check In / Check Out
        System.out.println("\n--- Room Check In/Out ---");

        room.checkIn();
        System.out.println("Occupied: " + room.isOccupied());
        System.out.println("Dirty: " + room.isDirty());

        room.checkOut();
        room.cleanRoom();

        System.out.println("Available: " + room.isAvailable());

        // Test Reservation
        Reservation reservation = new Reservation("king", 3, true);

        System.out.println("\nRoom Type: " + reservation.getRoomType());
        System.out.println("Price Per Night: $" + reservation.getPrice());
        System.out.println("Number of Nights: " + reservation.getNumberOfNights());
        System.out.println("Weekend: " + reservation.isWeekend());
        System.out.println("Reservation Total: $" + reservation.getReservationTotal());

        // Test Employee
        Employee employee = new Employee(101, "John", "IT", 20.00, 45);

        System.out.println("\n--- Employee ---");

        System.out.println("Employee Total Pay: $" + employee.getTotalPay());
        System.out.println("Regular Hours: " + employee.getRegularHours());
        System.out.println("Overtime Hours: " + employee.getOvertimeHours());

        // Test Employee Punch In/Out (24-hour time)
        employee.punchIn(10);
        employee.punchOut(14);

        System.out.println("Hours Worked: " + employee.getHoursWorked());

        // Test current time punch methods
        employee.punchIn();
        employee.punchOut();

        // Test Hotel
        System.out.println("\n--- Hotel ---");

        Hotel hotel = new Hotel("Grand Hotel", 10, 50);

        System.out.println("Hotel Name: " + hotel.getName());
        System.out.println("Available Suites: " + hotel.getAvailableSuites());
        System.out.println("Available Rooms: " + hotel.getAvailableRooms());

        // Book 2 suites
        System.out.println("Booking 2 Suites: " + hotel.bookRoom(2, true));

        // Book 5 basic rooms
        System.out.println("Booking 5 Basic Rooms: " + hotel.bookRoom(5, false));

        // Check updated availability
        System.out.println("Available Suites: " + hotel.getAvailableSuites());
        System.out.println("Available Rooms: " + hotel.getAvailableRooms());
    }
}