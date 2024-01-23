package org.example.Temperature;

import org.example.Units.ValueAndUnit;

public enum TemperatureUnit implements ValueAndUnit {
    F{
        @Override
        public double convertValue(double value, Enum e) {
            TemperatureUnit tempUnit = (TemperatureUnit) e;
            if(tempUnit == TemperatureUnit.C){
                return (value - 32) * (5/(double)9);
            }

            return value;
        }

    },
    C {
        @Override
        public double convertValue(double value, Enum e) {
            TemperatureUnit tempUnit = (TemperatureUnit) e;
            if(tempUnit == TemperatureUnit.F){
                return (value *  (9/(double)5))+32;
            }
            return value;
        }

    };

}
