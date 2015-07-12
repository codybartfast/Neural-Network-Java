/*
 *   Represents a Bias Neuron.
 *   
 *   A neurons evaluation needs to have  constant factor  (e.g. 
 *   so there can non-zero output when there is all inputs
 *   are zero).
 *   
 *   Rather adding an explicit constant factor to a given 
 *   neuron we instead add a constant (or bias) neuron to the
 *   previous layer and so evaluation and training of the 
 *   constant factor can be done using exactly the same 
 *   algorithm we use to evaluate and train the values from
 *   other 'regular' neurons.
 *   
 */

package Java_Neural_Network;

public class BiasNeuron extends ValueNeuron {

	public BiasNeuron()
	{
	    super.SetValue(1);
	}
	
	@Override
	public void SetValue(double value)
	{
	    assert false; // this should never be called for a BiasNeuron
	}

}
