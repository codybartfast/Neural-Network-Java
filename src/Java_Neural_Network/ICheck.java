/*
 *   Provides a function to determine if the output of a 
 *   network is considered correct.  Used for providing 
 *   statistics, it does not effect the evaluation or 
 *   training of a network.
 */

package Java_Neural_Network;

public interface ICheck {
	boolean isCorrect(double[] target, double[] output);
}
