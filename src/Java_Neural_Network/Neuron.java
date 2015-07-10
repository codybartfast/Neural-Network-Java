package Java_Neural_Network;

import java.util.ArrayList;
import java.util.List;

public abstract class Neuron {
	
    protected Activation activation;
    protected TrainingInfo trainInfo;
    
    public Neuron(Activation activation, TrainingInfo trainInfo)
    {
        this.activation = activation;
        this.trainInfo = trainInfo;
    }

    protected List<Connection> inboundConnections = new ArrayList<Connection>();
    public void AddInboundConnection(Connection connection)
    {    	
        inboundConnections.add(connection);
    }

    protected List<Connection> outboundConnections = new ArrayList<Connection>();
    public void AddOutboundConnection(Connection connection)
    {
        outboundConnections.add(connection);
    }
    
    double value;
    public double getValue() { return value; }

    double error;
    public double getError() { return error; }

    public void FeedForward()
    {
        double sum = 0;
        for  (Connection conn : inboundConnections)
            sum += conn.getWeightedValue();
        value = activation.CalcValue(sum);
    }

    public void PropagateBack() throws Exception
    {
        double valueDelta = CalcValueDelta();
        error = valueDelta * activation.CalcDerivative(value);

        for (Connection conn : inboundConnections)
            conn.propagateBack(trainInfo.getLearnRate(), error);
    }

    abstract protected double CalcValueDelta() throws Exception;
}
