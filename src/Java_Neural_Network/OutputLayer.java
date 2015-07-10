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
