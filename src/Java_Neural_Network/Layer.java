/*
 *   Base class for representing a Layer within a neural.
 *   
 *   It contains the layer's neurons and provides helper
 *   functions for calling feedForward and propagateBack
 *   on the neurons it contains.
 *   
 */

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
