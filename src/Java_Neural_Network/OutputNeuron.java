/*
 *   Represents a Neuron in the Output Layer
 *   
 *   Is able to hold a target or expected value that can
 *   be used by the back propagation process to train the
 *   network.
 *   
 */ 

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
