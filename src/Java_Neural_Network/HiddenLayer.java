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
