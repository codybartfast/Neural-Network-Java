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
		this(Activation.getSigmoid(), new TrainingInfo(learnRate), inputSize, hiddenSizes, outputSize);
	}
	
    public Network(Activation activation, TrainingInfo trainInfo, int inputSize, int[] hiddenSizes, int outputSize)
    {
        this.inputSize = inputSize;
        this.hiddenSizes = hiddenSizes;
        this.outputSize = outputSize;

        this.activation = activation;
        this.inputLayer = new InputLayer(inputSize);
        this.hiddenLayers = hiddenSizes
            .Select(size => new HiddenLayer(activation, trainInfo, size))
            .ToArray();
        this.outputLayer = new OutputLayer(activation, trainInfo, outputSize);
        ConnectLayers();    }
}
