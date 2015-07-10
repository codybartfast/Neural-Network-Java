package Java_Neural_Network;

public class Connection {

    Neuron from;
    Neuron to;
    double weight;

    public Connection(Neuron from, Neuron to, double weight)
    {
        from.AddOutboundConnection(this);
        this.from = from;

        to.AddInboundConnection(this);
        this.to = to;

        this.weight = weight;
    }

    public double getWeightedValue()
    {
         return from.Value *  weight; 
    }

    double weightedError;
    public double getWeightedError() { return weightedError; }

    public void PropagateBack(double learnRate, double error)
    {
        weightedError = error * weight; 

        double weightDelta = learnRate * error * from.Value;
        weight += weightDelta;
    }

}
