package Java_Neural_Network;

public class ValueNeuron extends Neuron {

    public ValueNeuron() { 
    	super(null, null); 
    }

    public void FeedForward()
    {
        // do nothing
    }

    public void PropagateBack()
    {
        // do nothing
    }

    public void SetValue(double value)
    {
        super.value = value;
    }


    protected double CalcValueDelta() throws Exception 
    {
        throw new Exception("Don't expect CalcValueDelta to be called on a Value neuron because PropagateBack does nothing");
    }
	
}
