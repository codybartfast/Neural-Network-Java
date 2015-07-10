package Java_Neural_Network;

public class Sample {
	
    public final double[] input;
    public final double[] target;

    public Sample(double[] input, double[] target)
    {
        this.input = input;
        this.target = target;
    }

    public static Sample create(String input, String targets)
    {
        double[] inValues = getValues(input);
        double[] targetValues = getValues(targets);
        return new Sample(inValues, targetValues);
    }

    public static double[] getValues(String text)
    {
        String[] parts = text.split("[\\s,]+");
        double[] values = new double[parts.length];
        for(int i = 0; i < parts.length; i++)
        	values[i] = 	Double.parseDouble(parts[i]);
        return values;
    }

}
