package org.example.Volume;



public class Volume {

    private double value;

    private VolumeUnit unit;

    public Volume(double value, VolumeUnit unit)
    {
        this.value = value;
        this.unit = unit;
    }

    public int compareTo(Volume volumeToCompare)
    {
        if(this.equals(volumeToCompare))
            return 0;

        double convertByParameter = unit.convertBy(volumeToCompare.unit);
        double updatedValue = this.value*convertByParameter;

        return Double.compare(updatedValue, volumeToCompare.value);
    }

    public Volume add(Volume VolumeToAdd){
        double convertByParameter = unit.convertBy(VolumeToAdd.unit);
        double updatedValue = this.value*convertByParameter;

        double addResult = updatedValue + VolumeToAdd.value;
        return new Volume(addResult,VolumeToAdd.unit);
    }

    public Volume subtract(Volume VolumeToSubtract){

        double convertByParameter = unit.convertBy(VolumeToSubtract.unit);
        double updatedValue = this.value*convertByParameter;

        if(updatedValue > VolumeToSubtract.value)
            throw new IllegalArgumentException("Larger Value Cannot Be Subtracted From Smaller Value");

        double subtractResult =  VolumeToSubtract.value - updatedValue;
        return new Volume(subtractResult,VolumeToSubtract.unit);
    }

    @Override
    public boolean equals(Object obj) {

        if(obj == this)
            return true;

        if(!(obj instanceof Volume))
            return false;

        Volume volume = (Volume)obj;

        return Double.compare(this.value, volume.value) == 0 && this.unit==volume.unit;

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
