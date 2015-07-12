/*
 *   Represents the Hidden Layer of a neural network 
 *   and contains 1 or more Hidden Neurons and a Bias
 *   neuron.
 *   
 *   FeedForward (evaluation) and BackPropagation (training)
 *   functions are provided by the Layer class.
 */

package Java_Neural_Network;

public class HiddenLayer extends Layer{
	
    public HiddenLayer(Activation activation, TrainingInfo trainInfo, int size)
    {
        Neuron[] neurons = new Neuron[size + 1];
        for (int i = 0; i < size; i++)
            neurons[i] = new HiddenNeuron(activation, trainInfo);
        neurons[size] = new BiasNeuron();
        this.neurons = neurons;
    }

    Neuron[] neurons;
    @Override
    public Neuron[] getNeurons() { return neurons; }

}
