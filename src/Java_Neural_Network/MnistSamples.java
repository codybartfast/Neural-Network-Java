/*
 *   Create samples (inputs and target outputs) from the 
 *   MNIST dataset.
 *   
 *   Each input contains 784 values representing the value
 *   of each pixel in a 28 x 28 image of a hand written 
 *   number.
 *   
 *   The target is 10 values that should have a '1' at the
 *   index of the correct answer.  E.g.:
 *   	0 = 1, 0, 0, 0, 0, 0, 0, 0, 0, 0
 *   	4 = 0, 0, 0, 0, 1, 0, 0, 0, 0, 0
 *   	9 = 0, 0, 0, 0, 0, 0, 0, 0, 0, 1
 */


package Java_Neural_Network;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class MnistSamples {

    public final Sample[] training;
    public final Sample[] testing;

    public MnistSamples()
    {
    	Sample[] allSamples = null;
		
		try {
			List<Sample> sampleList = new ArrayList<Sample>();
			String projectRoot = new File(".").getCanonicalPath();
			Path samplesFile = Paths.get(projectRoot, "data", "mnist-training.csv");
	    	try(BufferedReader br = new BufferedReader(new FileReader(samplesFile.toString()))) {
	    		br.readLine();
	    	    for(String line; (line = br.readLine()) != null; ) {
	    	        double[] values = Sample.getValues(line.substring(2));
	    	        double[] target = getTargetArray(line.substring(0, 1));
		    	    Sample sample = new Sample(values, target);
		    	    sampleList.add(sample);
	    	    }
	    	}
	    	allSamples = new Sample[sampleList.size()];
	    	allSamples = sampleList.toArray(allSamples);
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
    			
        int testCount = allSamples.length / 10;
        training = new Sample[allSamples.length - testCount];
        System.arraycopy(allSamples, 0, training, 0, training.length);
        testing = new Sample[testCount];
        if (testCount > 0)
        	System.arraycopy(allSamples, training.length, testing, 0, testing.length);            
    }

    static double[] getTargetArray(String targetText)
    {
        int targetValue = Integer.parseInt(targetText);
        double[] targetArray = new double[10];
        for (int i = 0; i < 10; i++)
            targetArray[i] = i == targetValue ? 1 : 0;
        return targetArray;
    }
    
}
