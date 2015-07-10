package Java_Neural_Network;

public class LogicGates {
	public static void train(){
        
		double learnRate = 0.2;
		ICheck check = new CheckLogic();
		
        UI.writeLine("Training Not:");
        UI.writeLine("=============");
        Network net = new Network(1, new int[0], 1, learnRate);
        new Trainer(net, LogicCases.notCases, check, null).trainUntilDone();
        
        UI.writeLine("Training Or:");
        UI.writeLine("============");
        new Trainer(create21Network(learnRate), LogicCases.orCases, check, null)
            .trainUntilDone();

        UI.writeLine("Training And:");
        UI.writeLine("=============");
        new Trainer(create21Network(learnRate), LogicCases.andCases, check, null)
            .trainUntilDone();

        UI.writeLine("Training Nand:");
        UI.writeLine("==============");
        new Trainer(create21Network(learnRate), LogicCases.nandCases, check, null)
            .trainUntilDone();

        UI.writeLine("Training Xor:");
        UI.writeLine("=============");
        new Trainer(create21Network(learnRate), LogicCases.xorCases, check, null)
        	.trainUntilDone();
	}
	
    static Network create21Network(double learnRate)
    {
        return new Network(2, new int[0], 1, learnRate);
    }

}

class CheckLogic implements ICheck{

	@Override
	public boolean isCorrect(double[] target, double[] output) {
        double t = target[0];
        double o = output[0];
        return (t == 1 && o > 0.7) || (t == 0 && o < 0.3);
	}
	
}
