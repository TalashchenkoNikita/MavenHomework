package org.example;

import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {
    Calendar inspectionDateCar1 = new GregorianCalendar(2019, Calendar.APRIL, 30);
    Calendar inspectionDateCar2 = new GregorianCalendar(2021, Calendar.AUGUST, 25);
    Car car1 = new Car(0, 10, inspectionDateCar1);
    Car car2 = new Car(10,10, inspectionDateCar2);

    @Test
    void isAbleToDrive() {
        assertFalse(car1.isAbleToDrive(car1.getFuelInTheBank()));
        assertTrue(car2.isAbleToDrive(car2.getFuelInTheBank()));
    }

    @Test
    void isReadyForUse() {
        assertFalse(car1.isReadyForUse(car1.getInspectionDate()));
        assertTrue(car2.isReadyForUse(car2.getInspectionDate()));
    }

    @Test
    void howFarCanDrive() {
        assertEquals(0, car1.howFarCanDrive(car1.getFuelInTheBank(),
                car1.getConsumptionPer100Km()));
        assertEquals(100, car1.howFarCanDrive(car2.getFuelInTheBank(),
                car2.getConsumptionPer100Km()));
    }
}