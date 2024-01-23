package org.example.Temperature;



public class Temperature {
    private double value;

    private TemperatureUnit unit;

    public Temperature(double value, TemperatureUnit unit)
    {
        this.value = value;
        this.unit = unit;
    }

    public int compareTo(Temperature temperatureToCompareTo)
    {

        double convertedValue = unit.convertValue(this.value,temperatureToCompareTo.unit);
        return Double.compare(convertedValue, temperatureToCompareTo.value);
    }

    @Override
    public boolean equals(Object obj) {

        if(obj == this)
            return true;

        if(!(obj instanceof Temperature))
            return false;

        Temperature temperature = (Temperature) obj;

        double convertedValue = unit.convertValue(this.value,temperature.unit);
        return convertedValue==temperature.value;

    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((unit == null) ? 0 : unit.hashCode());
        result = (int) (prime * result + value);
        return result;
    }
}
