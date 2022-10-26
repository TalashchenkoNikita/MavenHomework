package org.example;

import lombok.Data;
import java.util.Calendar;
import java.util.GregorianCalendar;

@Data

public class Car {

    private double fuelInTheBank;
    private int consumptionPer100Km;
    private Calendar inspectionDate;
    private static final int A_HUNDRED_KM = 100;

    public Car(int fuelInTheBank, int consumptionPer100Km, Calendar inspectionDate) {
        this.fuelInTheBank = fuelInTheBank;
        this.inspectionDate = inspectionDate;
        this.consumptionPer100Km = consumptionPer100Km;
    }

    public void setInspectionDate(int year, int month, int day) {
        inspectionDate.set(year,month,day);
    }

    public boolean isAbleToDrive (double fuelInTheBank) {
        return fuelInTheBank > 0;
    }

    public boolean isReadyForUse (Calendar inspectionDate) {
        Calendar twoYearsAgo = new GregorianCalendar();
        twoYearsAgo.toInstant();
        twoYearsAgo.roll(Calendar.YEAR, -2);
        return inspectionDate.after(twoYearsAgo);
    }

    public double howFarCanDrive (double fuelInTheBank, int consumptionPer100Km) {
        return fuelInTheBank / consumptionPer100Km * A_HUNDRED_KM;
    }
}
