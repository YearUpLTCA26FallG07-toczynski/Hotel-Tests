
package com.pluralsight;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RoomTest {

    @Test
    void testCheckIn() {
        Room room = new Room(2, 100.0, false, false);

        room.checkIn();

        assertTrue(room.isOccupied());
        assertTrue(room.isDirty());
    }

    private void assertTrue(boolean occupied) {
    }

    @Test
    void testCheckOut() {
        Room room = new Room(2, 100.0, true, false);

        room.checkOut();

        assertFalse(room.isOccupied());
        assertTrue(room.isDirty());
    }

    @Test
    void testCleanRoom() {
        Room room = new Room(2, 100.0, false, true);

        room.cleanRoom();

        assertFalse(room.isDirty());
    }

    @Test
    void testCannotCheckInOccupiedRoom() {
        Room room = new Room(2, 100.0, true, false);

        room.checkIn();

        assertTrue(room.isOccupied());
    }

    @Test
    void testCannotCheckInDirtyRoom() {
        Room room = new Room(2, 100.0, false, true);

        room.checkIn();

        assertFalse(room.isOccupied());
        assertTrue(room.isDirty());
    }

    @Test
    void testCannotCleanOccupiedRoom() {
        Room room = new Room(2, 100.0, true, true);

        room.cleanRoom();

        assertTrue(room.isOccupied());
        assertTrue(room.isDirty());
    }
}
