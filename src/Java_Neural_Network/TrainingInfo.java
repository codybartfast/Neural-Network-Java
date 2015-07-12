/*
 *   Contains values that customise the training or back
 *   propagation behaviour.  In theory it allows the 
 *   learn rate to be adjusted during training, e.g., 
 *   reducing the learning rate as the network
 *   approaches a 'correct' solution.  
 * 
 */

package Java_Neural_Network;

public class TrainingInfo {
 
	public TrainingInfo(double learnRate)
    {
        this.learnRate = learnRate;
    }

    double learnRate;
    public double getLearnRate() { return learnRate; }

}
