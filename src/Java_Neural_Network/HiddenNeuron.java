/*
 *  Represents a neuron in the Hidden Layer with no 
 *  'special' features.
 */

package Java_Neural_Network;

class HiddenNeuron extends Neuron
{
    public HiddenNeuron(Activation activation, TrainingInfo trainInfo) {
    	super(activation, trainInfo);
    }
   
    @Override
    protected double calcValueDelta()
    {
    	double delta = 0;
    	for(Connection conn : outboundConnections){
    		delta += conn.weightedError;
    	}
        return delta;
    }
}	