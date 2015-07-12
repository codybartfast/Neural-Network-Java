/*
 *   Creates Neural Networks to represent a number of
 *   different logic gates and repeatedly trains those 
 *   networks until they are 100% correct.
 *   
 *   Includes the XOR gate that cannot be accurately 
 *   represented by a perceptron (i.e. by simple linea 
 *   regression).
 *   
 *   Then starts training a much larger network [784, 500, 
 *   100, 10]  to recognise handwritten characters from the
 *   MNIST dataset.
 *   
 *   MNIST Dataset: http://yann.lecun.com/exdb/mnist/
 *   Sample Images: http://www.dmi.usherb.ca/~larocheh/images/nade_on_mnist.jpg
  
 *   All the logic gates should train within a second or so.
 *   
 *   Each MNIST training cycle may be of the order of 10 minutes.
 * 
 */

package Java_Neural_Network;

class Program {

	public static void main(String[] args) {
    	LogicGates.train();
        Mnist.train(18900, 0.0015);
    	UI.writeLine("Everything done!");
    }

}
