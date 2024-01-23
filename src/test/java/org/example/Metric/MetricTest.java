package org.example.Metric;

import org.example.Length.Length;
import org.example.Length.LengthUnit;
import org.example.Volume.VolumeUnit;
import org.example.Weight.WeightUnit;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MetricTest {

    @Test
    public void compareForLengthMetric1MMWith1MMExpects0()
    {
        Metric metric1 = new Metric<LengthUnit>(1, LengthUnit.MM);
        Metric metric2 = new Metric<LengthUnit>(1,LengthUnit.MM);
        int result = metric1.compareTo(metric2);
        assertEquals(0,result);
    }

    @Test
    public void compareForWeightMetric1MGWith1MGExpects0()
    {
        Metric metric1 = new Metric<WeightUnit>(1, WeightUnit.MG);
        Metric metric2 = new Metric<WeightUnit>(1,WeightUnit.MG);
        int result = metric1.compareTo(metric2);
        assertEquals(0,result);
    }

    @Test
    public void compareForVolumeMetric1MLWith1MLExpects0()
    {
        Metric metric1 = new Metric<VolumeUnit>(1, VolumeUnit.ML);
        Metric metric2 = new Metric<VolumeUnit>(1,VolumeUnit.ML);
        int result = metric1.compareTo(metric2);
        assertEquals(0,result);
    }

    @Test
    public void compareForVolumeMetric1MLWithLengthMetric1MM_ExpectsException()
    {
        Metric metric1 = new Metric<VolumeUnit>(1.0, VolumeUnit.ML);
        Metric metric2 = new Metric<LengthUnit>(1.0, LengthUnit.MM);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            metric1.compareTo(metric2);
        });

        String expectedMessage = "Unit Parameters are not same";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage,actualMessage);
    }

    @Test
    public void addForLengthMetric1MMWith1MMExpects2MM()
    {
        Metric metric1 = new Metric<LengthUnit>(1, LengthUnit.MM);
        Metric metric2 = new Metric<LengthUnit>(1,LengthUnit.MM);
        Metric<LengthUnit> result = metric1.add(metric2);
        assertEquals(new Metric<LengthUnit>(2,LengthUnit.MM),result);
    }

    @Test
    public void addForWeightMetric1MGWith1MGExpects2MG()
    {
        Metric metric1 = new Metric<WeightUnit>(1, WeightUnit.MG);
        Metric metric2 = new Metric<WeightUnit>(1,WeightUnit.MG);
        Metric<WeightUnit> result = metric1.add(metric2);
        assertEquals(new Metric<WeightUnit>(2,WeightUnit.MG),result);
    }

    @Test
    public void addForVolumeMetric1MLWith1MLExpects2ML()
    {
        Metric metric1 = new Metric<VolumeUnit>(1, VolumeUnit.ML);
        Metric metric2 = new Metric<VolumeUnit>(1,VolumeUnit.ML);
        Metric<VolumeUnit> result = metric1.add(metric2);
        assertEquals(new Metric<VolumeUnit>(2,VolumeUnit.ML),result);
    }

    @Test
    public void addForVolumeMetric1MLWithLengthMetric1MM_ExpectsException()
    {
        Metric metric1 = new Metric<VolumeUnit>(1.0, VolumeUnit.ML);
        Metric metric2 = new Metric<LengthUnit>(1.0, LengthUnit.MM);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            metric1.add(metric2);
        });

        String expectedMessage = "Unit Parameters are not same";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage,actualMessage);
    }

    @Test
    public void subtractForLengthMetric1MMWith1MMExpects0MM()
    {
        Metric metric1 = new Metric<LengthUnit>(1, LengthUnit.MM);
        Metric metric2 = new Metric<LengthUnit>(1,LengthUnit.MM);
        Metric<LengthUnit> result = metric1.subtract(metric2);
        assertEquals(new Metric<LengthUnit>(0,LengthUnit.MM),result);
    }

    @Test
    public void subtractForWeightMetric1MGWith1MGExpects0MG()
    {
        Metric metric1 = new Metric<WeightUnit>(1, WeightUnit.MG);
        Metric metric2 = new Metric<WeightUnit>(1,WeightUnit.MG);
        Metric<WeightUnit> result = metric1.subtract(metric2);
        assertEquals(new Metric<WeightUnit>(0,WeightUnit.MG),result);
    }

    @Test
    public void subtractForVolumeMetric1MLWith1MLExpects0ML()
    {
        Metric metric1 = new Metric<VolumeUnit>(1, VolumeUnit.ML);
        Metric metric2 = new Metric<VolumeUnit>(1,VolumeUnit.ML);
        Metric<VolumeUnit> result = metric1.subtract(metric2);
        assertEquals(new Metric<VolumeUnit>(0,VolumeUnit.ML),result);
    }

    @Test
    public void subtractForVolumeMetric1MLWithLengthMetric1MM_ExpectsException()
    {
        Metric metric1 = new Metric<VolumeUnit>(1.0, VolumeUnit.ML);
        Metric metric2 = new Metric<LengthUnit>(1.0, LengthUnit.MM);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            metric1.subtract(metric2);
        });

        String expectedMessage = "Unit Parameters are not same";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage,actualMessage);
    }

    @Test
    public void subtractForVolumeMetric2MLWithVolumeMetric1ML_ExpectsException()
    {
        Metric metric1 = new Metric<VolumeUnit>(2.0, VolumeUnit.ML);
        Metric metric2 = new Metric<VolumeUnit>(1.0, VolumeUnit.ML);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            metric1.subtract(metric2);
        });

        String expectedMessage = "Larger Value Cannot Be Subtracted From Smaller Value";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage,actualMessage);
    }
}
