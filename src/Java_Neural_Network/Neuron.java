package Java_Neural_Network;

import java.util.ArrayList;
import java.util.List;

public abstract class Neuron {
	
    final protected Activation activation;
    final protected TrainingInfo trainInfo;
    
    public Neuron(Activation activation, TrainingInfo trainInfo)
    {
        this.activation = activation;
        this.trainInfo = trainInfo;
    }

    protected List<Connection> inboundConnections = new ArrayList<Connection>();
    public void addInboundConnection(Connection connection)
    {    	
        inboundConnections.add(connection);
    }

    protected List<Connection> outboundConnections = new ArrayList<Connection>();
    public void addOutboundConnection(Connection connection)
    {
        outboundConnections.add(connection);
    }
    
    double value;
    public double getValue() { return value; }

    double error;
    public double getError() { return error; }

    public void feedForward()
    {
        double sum = 0;
        for  (Connection conn : inboundConnections)
            sum += conn.getWeightedValue();
        value = activation.CalcValue(sum);
    }

    public void propagateBack()
    {
        double valueDelta = calcValueDelta();
        error = valueDelta * activation.CalcDerivative(value);

        for (Connection conn : inboundConnections)
            conn.propagateBack(trainInfo.getLearnRate(), error);
    }

    abstract protected double calcValueDelta();
}
