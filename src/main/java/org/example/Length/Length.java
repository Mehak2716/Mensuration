package org.example.Length;

public class Length {

    private double value;

    private LengthUnit unit;

    public Length(double value, LengthUnit unit)
    {
        this.value = value;
        this.unit = unit;
    }

    public int compareTo(Length lengthToCompare)
    {
       if(this.equals(lengthToCompare))
           return 0;

       double convertByParameter = unit.convertBy(lengthToCompare.unit);
       double updatedValue = this.value*convertByParameter;

       return Double.compare(updatedValue, lengthToCompare.value);
    }

    public Length add(Length lengthToAdd){
        double convertByParameter = unit.convertBy(lengthToAdd.unit);
        double updatedValue = this.value*convertByParameter;

        double addResult = updatedValue + lengthToAdd.value;
        return new Length(addResult, lengthToAdd.unit);
    }

    public Length subtract(Length lengthToSubtract){

        double convertByParameter = unit.convertBy(lengthToSubtract.unit);
        double updatedValue = this.value*convertByParameter;

        if(updatedValue > lengthToSubtract.value)
            throw new IllegalArgumentException("Larger Value Cannot Be Subtracted From Smaller Value");

        double subtractResult =  lengthToSubtract.value - updatedValue;
        return new Length(subtractResult, lengthToSubtract.unit);
    }

    @Override
    public boolean equals(Object obj) {

        if(obj == this)
            return true;

        if(!(obj instanceof Length))
            return false;

        Length length = (Length)obj;

        return Double.compare(this.value, length.value) == 0 && this.unit== length.unit;

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
