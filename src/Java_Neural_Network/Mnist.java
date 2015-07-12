/*
 *   Creates and trains a network to recognise hand written
 *   numbers from the MNIST data set.
 *   
 *   MNIST Dataset: http://yann.lecun.com/exdb/mnist/
 *   Sample Images: http://www.dmi.usherb.ca/~larocheh/images/nade_on_mnist.jpg
 *   
 */

package Java_Neural_Network;

public class Mnist {

    public static void train(int trainingCount, double learnRate)
    {
    	UI.writeLine("Starting MNIST training");
    	UI.write("Loading samples... ");
        MnistSamples mnistSamples = new MnistSamples();
        UI.writeLine("done");

        UI.write("Creating network... ");
        Network net = new Network(784, new int[] { 500, 100 }, 10, learnRate);
        UI.writeLine("done");

        Sample[] training = Take (mnistSamples.training, trainingCount);
        Sample[] testing = Take (mnistSamples.testing, training.length);

        Trainer trainer = new Trainer(net, training, new CheckMnist(), testing);
        trainer.trainUntilDone(true);
    }
       
    static Sample[] Take(Sample[] array, int count){
    	int len = Math.min(count, array.length);
        Sample[] taken = new Sample[len];
    	System.arraycopy(array, 0, taken, 0, taken.length);
    	return taken;    	
    }
}

class CheckMnist implements ICheck{
	
	@Override
	public boolean isCorrect(double[] target, double[] output) {
        return indexOfMaxValue(target) == indexOfMaxValue(output);
	}
	
    static int indexOfMaxValue(double[] numbers)
    {
        int index = 0;
        double max = numbers[0];
        for(int i = 0; i < numbers.length; i++)
        	if(numbers[i] > max)
        		max = numbers[index = i];
        return index;
    }
	
}