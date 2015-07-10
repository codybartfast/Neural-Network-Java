package Java_Neural_Network;

public class OutputNeuron extends Neuron{
	
    public OutputNeuron(Activation activation, TrainingInfo trainInfo)
    { 
    	 super(activation, trainInfo);
    }

    double targetValue;
    public double getTargetValue() { return targetValue; }
    public void setTargetValue(double value) { targetValue = value; }

    @Override
	protected double calcValueDelta()
	{
	    return targetValue - value;
	}

}
