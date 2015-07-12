/*
 *   Represents a connection between a neuron ('from') in one layer 
 *   and a neuron ('to') the next layer.
 *   
 *   It maintains a 'weight' value that decides the influence of the 
 *   'from' neuron the 'to' neuron.
 *   
 *   It provides Weighted Value when feeding forward (evaluating) and
 *   updates it's weight during BackPropogation (training).
 */

package Java_Neural_Network;

public class Connection {

    final Neuron from;
    final Neuron to;
    double weight;

    public Connection(Neuron from, Neuron to, double weight)
    {
        from.addOutboundConnection(this);
        this.from = from;

        to.addInboundConnection(this);
        this.to = to;

        this.weight = weight;
    }

    public double getWeightedValue()
    {
         return from.getValue() *  weight; 
    }

    double weightedError;
    public double getWeightedError() { return weightedError; }

    public void propagateBack(double learnRate, double error)
    {
        weightedError = error * weight; 

        double weightDelta = learnRate * error * from.getValue();
        weight += weightDelta;
    }

}
