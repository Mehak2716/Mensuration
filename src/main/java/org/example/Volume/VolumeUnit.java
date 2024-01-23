package org.example.Volume;


import org.example.Units.Unit;

public enum VolumeUnit implements Unit {
    ML,
    CL,
    DL,
    L,
    DAL,
    HL,
    KL;

    @Override
    public double convertBy (Enum e)
    {
        VolumeUnit convertToUnit = (VolumeUnit) e;
        int unitToConvertIndex=-1;
        int convertToUnitIndex=-1;

        for(int i=0;i<VolumeUnit.values().length;i++)
        {
            if(this == VolumeUnit.values()[i])
            {
                unitToConvertIndex=i;
            }

            if(convertToUnit == VolumeUnit.values()[i])
            {
                convertToUnitIndex=i;
            }

        }

        if(unitToConvertIndex==-1 || convertToUnitIndex==-1 )
            throw new IllegalArgumentException("WeightUnit is invalid");


        int size = Math.abs(convertToUnitIndex-unitToConvertIndex);
        double coversionParameter= Math.pow(10,size);

        if(unitToConvertIndex<convertToUnitIndex)
        {
            return 1/coversionParameter;
        }

        return 1*coversionParameter;
    }
}
