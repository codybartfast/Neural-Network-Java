/*
 *   Represents the Output layer of a neural network. 
 *   
 *   Contains Output Neurons.
 *   
 *   Provides a GetValues function for represents output of
 *   the Neural network.
 *   
 *   Provides a SetTargetValues function to set the expected
 *   out put of the network for a given input. These values 
 *   can then be used by back propagation (training)
 *   process to train the network.
 * 
 */

package Java_Neural_Network;

public class OutputLayer extends Layer{

    public OutputLayer(Activation activation, TrainingInfo trainInfo, int size)
    {
        OutputNeuron[] neurons = new OutputNeuron[size];
        for (int i = 0; i < size; i++)
            neurons[i] = new OutputNeuron(activation, trainInfo);
        this.neurons = neurons;
    }

    final OutputNeuron[] neurons;
    public Neuron[] getNeurons() { return neurons; }
    
    public double[] getValues()
    {
    	int size = neurons.length;
    	double[] values = new double[size];
    	for(int i = 0; i < size; i++)
    		values[i] = neurons[i].getValue();
    	return values;
    }

    public void setTargetValues(double[] targetValues)
    {  	
        for (int i = 0; i < targetValues.length; i++)
            neurons[i].setTargetValue( targetValues[i] );
    }
    
}
