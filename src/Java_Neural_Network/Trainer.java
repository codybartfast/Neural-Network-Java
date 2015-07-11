package Java_Neural_Network;

import java.util.Random;

public class Trainer {

    final Network net;
    final Sample[] cases;
    final int caseCount;
    final ICheck check;
    final Sample[] testCases;

	public Trainer(Network net, Sample[] cases, ICheck check, Sample[] testCases){
        this.net = net;
        this.cases = cases;
        this.caseCount = cases.length;

        assert caseCount > 0;
        Sample sampleSample = cases[0];
        assert net.getInputSize() == sampleSample.input.length;
        assert net.getOutputSize() == sampleSample.target.length;

        this.check = check;
        this.testCases = (testCases != null) ? testCases : new Sample[0];		
	}
	
	public void trainUntilDone(){
		trainUntilDone(false);
	}

    long epochSize;
    long epochCount;
    long currentSampleCount;
    long totalSampleCount;
    
    void trainAllCases(){
        for(Sample sample : cases)
        {
            net.feedForward(sample.input);
            net.propagateBack(sample.target);
            currentSampleCount++;
            totalSampleCount++;
        }
        epochCount++;
        currentSampleCount = 0;
    }
	
	public void trainUntilDone(boolean showEpochStats){
        long start = System.currentTimeMillis();
        wr("Got %d training cases and %d test cases", caseCount, testCases.length);
        Tuple trainingAccuracy = measureAccuracy(cases);
        Tuple testAccuracy = measureAccuracy(testCases);
        writeAccuracy(trainingAccuracy, "Training");
        writeAccuracy(testAccuracy, "    Test");
        wr("Starting first epoch...");
        wr("================================");
        while (trainingAccuracy.item1 != trainingAccuracy.item2)
        {
            long epochStart = System.currentTimeMillis();
            shuffleCases();
            long trainingStart = System.currentTimeMillis();
            trainAllCases();
            long trainingEnd = System.currentTimeMillis();
            trainingAccuracy = measureAccuracy(cases);
            if (showEpochStats || trainingAccuracy.item1 == trainingAccuracy.item2)
            {
                wr("Epoch %d complete:", epochCount);
                testAccuracy = measureAccuracy(testCases);
                writeAccuracy(trainingAccuracy, "Training");
                writeAccuracy(testAccuracy, "    Test");
                wr("Training time: %.3fs", (trainingEnd - trainingStart)/1000f);
                long now = System.currentTimeMillis();
                wr("   Epoch time: %.3fs", (now - epochStart)/1000f);
                wr("     Run time: %.3fs", (now - start)/1000f);
                wr("================================");
            }
        }
        wr("All done.");
        wr("");		
	}
	
    static Random rnd = new Random();
    public void shuffleCases()
    {
        for (int i = 0; i < caseCount; i++)
        {
            int r = (int)(rnd.nextDouble() * caseCount);
            Sample rTemp = cases[r];
            cases[r] = cases[i];
            cases[i] = rTemp;
        }
    }

	
    Tuple measureAccuracy(Sample[] samples)
    {
        int correctCount = 0;        
        for(Sample sample : samples){        	
        	double[] output = net.feedForward(sample.input);
        	if(check.isCorrect(sample.target, output))
        		correctCount++;
        }
        return new Tuple(correctCount, samples.length);
    }

    void writeAccuracy(Tuple t, String sampleName)
    {
        wr("%s: %.2f correct (%d/%d)",
            sampleName, GetPercent(t.item1, t.item2), t.item1, t.item2);
    }

    float GetPercent(int n, int d) { return 100 * (float)n / (float)d; }

    void wr(String text, Object... args)
    {
        UI.writeLine(text, args);
    }

}

class Tuple{
	
	public final int item1;
	public final int item2;
	
	public Tuple(int item1, int item2){
		this.item1 = item1;
		this.item2 = item2;
	}
	
}
