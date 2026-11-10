
package com.pluralsight;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    @Test
    void testPunchIn() {
        Employee employee = new Employee(
                1, "John", "Housekeeping", 15.00, 0
        );

        employee.punchIn(9);
        employee.punchOut(17);

        assertEquals(8.0, employee.getHoursWorked());
    }

    @Test
    void testPunchOut() {
        Employee employee = new Employee(
                2, "Mike", "Maintenance", 20.00, 0
        );

        employee.punchIn(8);
        employee.punchOut(16);

        assertEquals(8.0, employee.getHoursWorked());
    }

    @Test
    void testMultipleShifts() {
        Employee employee = new Employee(
                3, "Sam", "Front Desk", 18.00, 0
        );

        employee.punchIn(9);
        employee.punchOut(17);

        employee.punchIn(9);
        employee.punchOut(13);

        assertEquals(12.0, employee.getHoursWorked());
    }
}
