package Java_Neural_Network;

public abstract class Layer {

    public abstract Neuron[] getNeurons();

    public void feedForward()
    {
        for (Neuron neuron : getNeurons())
            neuron.feedForward();
    }

    public void propagateBack()
    {
        for (Neuron neuron : getNeurons())
            neuron.propagateBack();
    }

}
