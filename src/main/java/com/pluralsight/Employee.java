
package com.pluralsight;

import java.time.LocalDateTime;
import java.time.Duration;

public class Employee {

    private int employeeId;
    private String name;
    private String department;
    private double payRate;
    private double hoursWorked;

    private int startTime;
    private LocalDateTime clockInTime;

    public Employee(int employeeId, String name,
                    String department, double payRate,
                    double hoursWorked) {

        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.payRate = payRate;
        this.hoursWorked = hoursWorked;
    }

    // Original punch in method
    public void punchIn(int time) {
        startTime = time;
        System.out.println(name + " punched in at " + time + ":00");
    }

    // Original punch out method
    public void punchOut(int time) {
        int hours = time - startTime;

        if (hours > 0) {
            hoursWorked += hours;
            System.out.println(name + " worked " + hours + " hours.");
        } else {
            System.out.println("Invalid punch out time.");
        }
    }

    // Overloaded punch in method using current time
    public void punchIn() {
        clockInTime = LocalDateTime.now();

        int hour = clockInTime.getHour();
        int minute = clockInTime.getMinute();

        System.out.println("Punched in at " + hour + ":" + minute);
    }

    // Overloaded punch out method using current time
    public void punchOut() {

        if (clockInTime == null) {
            System.out.println("You must punch in first.");
            return;
        }

        LocalDateTime clockOutTime = LocalDateTime.now();

        long minutesWorked = Duration.between(
                clockInTime, clockOutTime).toMinutes();

        double hours = minutesWorked / 60.0;

        hoursWorked += hours;

        System.out.println("Hours worked: " + hours);

        clockInTime = null;
    }

    public double getRegularHours() {
        return Math.min(hoursWorked, 40);
    }

    public double getOvertimeHours() {
        return Math.max(hoursWorked - 40, 0);
    }

    public double getTotalPay() {
        return (getRegularHours() * payRate)
                + (getOvertimeHours() * payRate * 1.5);
    }

    public double getHoursWorked() {
        return hoursWorked;
    }
}