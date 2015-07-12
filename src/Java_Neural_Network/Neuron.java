/*
 *   Represents a neuron with a neural network. It provides
 *   the core functions "feedForward" for evaluation and 
 *   "propagateBack" for training.  It maintains the value
 *   of the last calculated value and last calculated error.
 *   
 *   'Delta' is the difference between expected and actual
 *   values.
 *   
 *   'Error' is a calculated term dependent on the
 *   activation function and is used to determine
 *   the adjustments to the weights given to the values
 *   in the previous layers.
 */

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
