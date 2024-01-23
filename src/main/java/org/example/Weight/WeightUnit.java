package org.example.Weight;

import org.example.Units.Unit;

public enum WeightUnit implements Unit {

    MG,
    CG,
    DG,
    G,
    DAG,
    HG,
    KG;

    @Override
    public double convertBy (Enum e)
    {
        WeightUnit convertToUnit = (WeightUnit) e;
        int unitToConvertIndex=-1;
        int convertToUnitIndex=-1;

        for(int i=0;i<WeightUnit.values().length;i++)
        {
            if(this == WeightUnit.values()[i])
            {
                unitToConvertIndex=i;
            }

            if(convertToUnit == WeightUnit.values()[i])
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
