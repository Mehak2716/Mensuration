package org.example.Weight;

public class Weight {

    private double value;

    private WeightUnit weightUnit;

    public Weight(double value, WeightUnit weightUnit)
    {
        this.value = value;
        this.weightUnit = weightUnit;
    }

    public int compareTo(Weight weightToCompare)
    {
        if(this.equals(weightToCompare))
            return 0;

        double convertByParameter = weightUnit.convertBy(weightToCompare.weightUnit);
        double updatedValue = this.value*convertByParameter;

        return Double.compare(updatedValue, weightToCompare.value);
    }

    public Weight add(Weight weightToAdd){
        double convertByParameter = weightUnit.convertBy(weightToAdd.weightUnit);
        double updatedValue = this.value*convertByParameter;

        double addResult = updatedValue + weightToAdd.value;
        return new Weight(addResult,weightToAdd.weightUnit);
    }

    public Weight subtract(Weight weightToSubtract){

        double convertByParameter = weightUnit.convertBy(weightToSubtract.weightUnit);
        double updatedValue = this.value*convertByParameter;

        if(updatedValue > weightToSubtract.value)
            throw new IllegalArgumentException("Larger Value Cannot Be Subtracted From Smaller Value");

        double subtractResult =  weightToSubtract.value - updatedValue;
        return new Weight(subtractResult,weightToSubtract.weightUnit);
    }

    @Override
    public boolean equals(Object obj) {

        if(obj == this)
            return true;

        if(!(obj instanceof Weight))
            return false;

        Weight weight = (Weight) obj;

        return Double.compare(this.value, weight.value) == 0 && this.weightUnit==weight.weightUnit;

    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((weightUnit == null) ? 0 : weightUnit.hashCode());
        result = (int) (prime * result + value);
        return result;
    }
}
