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
