package Java_Neural_Network;

public class Network {
	
    InputLayer inputLayer;
    HiddenLayer[] hiddenLayers;
    OutputLayer outputLayer;
    Activation activation;
    
    int inputSize;
    public int getInputSize(){ return inputSize; }
    
    int[] hiddenSizes;
    public int[] getHiddenSizes() { return hiddenSizes; }
    
    int outputSize;
    public int getOutputSize() { return outputSize; }
    
    
	public Network(int inputSize, int[] hiddenSizes, int outputSize, double learnRate){
		this(Activation.Sigmoid, new TrainingInfo(learnRate), inputSize, hiddenSizes, outputSize)
	}
	
    public Network(Activation activation, TrainingInfo trainInfo, int inputSize, int[] hiddenSizes, int outputSize)
    {
    }
}
