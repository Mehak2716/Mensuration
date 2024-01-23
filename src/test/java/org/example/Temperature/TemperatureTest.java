package org.example.Temperature;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TemperatureTest {

    @Test
    public void compare1Fto1FExpects0()
    {
        Temperature temperature1 = new Temperature(1,TemperatureUnit.F);
        Temperature temperature2 = new Temperature(1,TemperatureUnit.F);
        int result = temperature1.compareTo(temperature2);
        assertEquals(0,result);
    }

    @Test
    public void compare41Fto12CExpectsMinus1()
    {
        Temperature temperature1 = new Temperature(41,TemperatureUnit.F);
        Temperature temperature2 = new Temperature(12,TemperatureUnit.C);
        int result = temperature1.compareTo(temperature2);
        assertEquals(-1,result);
    }

    @Test
    public void conmpare1Cto1CExpects0()
    {
        Temperature temperature1 = new Temperature(1,TemperatureUnit.C);
        Temperature temperature2 = new Temperature(1,TemperatureUnit.C);
        int result = temperature1.compareTo(temperature2);
        assertEquals(0,result);
    }

    @Test
    public void conmpare12Cto41FExpects1()
    {
        Temperature temperature1 = new Temperature(12,TemperatureUnit.C);
        Temperature temperature2 = new Temperature(50,TemperatureUnit.F);
        int result = temperature1.compareTo(temperature2);
        assertEquals(1,result);
    }

}
