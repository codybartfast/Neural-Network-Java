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
