/*
 *   Represents the Input layer of a neural network.  It
 *   contains value neurons that simply 'hold' an input 
 *   value.
 *   
 *   Provides a function to allow the value of the input
 *   neurons to be set.
 * 
 */

package Java_Neural_Network;

public class InputLayer extends Layer {
    
    public InputLayer(int size)
    {
        ValueNeuron[] neurons = new ValueNeuron[size + 1];
        for (int i = 0; i < size; i++)
            neurons[i] =  new ValueNeuron();
        neurons[size] = new BiasNeuron();
        this.neurons = neurons;
    }

    ValueNeuron[] neurons; // inputNeurons + Bias
    @Override
    public Neuron[] getNeurons(){ return neurons; }
    

    public void setInputValues(double[] input)
    {
        for (int i = 0; i < input.length; i++)
            neurons[i].SetValue(input[i]);
    }

}
