package org.example.Metric;

import org.example.Temperature.Temperature;
import org.example.Units.Unit;

class Metric<T extends Unit>{

    private double value;
    private T unit;

    public Metric(double value, T unit)
    {
        this.value = value;
        this.unit = unit;
    }

    public int compareTo(Metric ToCompare)
    {
        if(!unit.getClass().equals(ToCompare.unit.getClass())){
            throw new IllegalArgumentException("Unit Parameters are not same");
        }


        if(this.equals(ToCompare))
            return 0;

        double convertByParameter = unit.convertBy((Enum) ToCompare.unit);
        double updatedValue = this.value*convertByParameter;

        return Double.compare(updatedValue, ToCompare.value);
    }

    public Metric add(Metric metricToAdd){

        if(!unit.getClass().equals(metricToAdd.unit.getClass())){
            throw new IllegalArgumentException("Unit Parameters are not same");
        }

        double convertByParameter = unit.convertBy((Enum) metricToAdd.unit);
        double updatedValue = this.value*convertByParameter;

        double addResult = updatedValue + metricToAdd.value;
        return new Metric(addResult, metricToAdd.unit);
    }

    public Metric subtract(Metric metricToSubtract){

        if(!unit.getClass().equals(metricToSubtract.unit.getClass())){
            throw new IllegalArgumentException("Unit Parameters are not same");
        }

        double convertByParameter = unit.convertBy((Enum) metricToSubtract.unit);
        double updatedValue = this.value*convertByParameter;

        if(updatedValue > metricToSubtract.value)
            throw new IllegalArgumentException("Larger Value Cannot Be Subtracted From Smaller Value");

        double subtractResult =  metricToSubtract.value - updatedValue;
        return new Metric(subtractResult, metricToSubtract.unit);
    }

    @Override
    public boolean equals(Object obj) {

        if(obj == this)
            return true;

        if(!(obj instanceof Metric))
            return false;

        Metric metric = (Metric) obj;

        if(!unit.getClass().equals(metric.unit.getClass())){
            throw new IllegalArgumentException("Unit Parameters are not same");
        }

        double convertByParameter = unit.convertBy((Enum) metric.unit);
        double updatedValue = this.value*convertByParameter;

        return updatedValue == metric.value;

    }
}