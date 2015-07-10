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
        
        this.hiddenLayers = new HiddenLayer[hiddenSizes.length];
        for(int i = 0; i < hiddenSizes.length; i++){
        	this.hiddenLayers[i] = new HiddenLayer(activation, trainInfo, hiddenSizes[i]);
        }
        
        this.outputLayer = new OutputLayer(activation, trainInfo, outputSize);
        connectLayers();   
    }
    
    void connectLayers()
    {
        if (hiddenLayers.length < 1)
        {
            connectAdjacentLayers(inputLayer, outputLayer);
        }
        else
        {
        	connectAdjacentLayers(inputLayer, hiddenLayers[0]);
            
        	int lastHiddenIndex = hiddenLayers.length - 1;
            for (int i = 0; i < lastHiddenIndex; i++)
                connectAdjacentLayers(hiddenLayers[i], hiddenLayers[i + 1]);
            
            connectAdjacentLayers(hiddenLayers[lastHiddenIndex], outputLayer);
        }
    }
    
    void connectAdjacentLayers(Layer fromLayer, Layer toLayer)
    {
        for (Neuron fromNeuron : fromLayer.getNeurons())
            for (Neuron toNeuron : toLayer.getNeurons())
                new Connection(fromNeuron, toNeuron, activation.GetRandomWeight());
    }

    public double[] feedForward(double[] input)
    {
        inputLayer.setInputValues(input);
        for (HiddenLayer hiddenLayer : hiddenLayers)
            hiddenLayer.feedForward();
        outputLayer.feedForward();
        return outputLayer.getValues();
    }

    public void propagateBack(double[] target)
    {
        outputLayer.setTargetValues(target);
        outputLayer.propagateBack();
        int length = hiddenLayers.length;
        for (int i = length - 1; i >= 0; i--)
            hiddenLayers[i].propagateBack();
    }

}
