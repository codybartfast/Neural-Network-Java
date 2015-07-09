package Java_Neural_Network;

public class LogicGates {
	public static void train(){
		
		double learnRate = 0.2;
		
        UI.writeLine("Training Not:");
        UI.writeLine("=============");
        Network net = new Network(1, new int[0], 1, learnRate);
        new Trainer(net, null, null, null).trainUntilDone();
        
//        new Trainer(new Network(1, new int[0], 1, learnRate), notCases, CheckCorrect)
//        .TrainUntilDone();
//
//        UI.writeLine("Training Or:");
//        UI.writeLine("============");
//        new Trainer(Create21Network(), orCases, CheckCorrect)
//            .TrainUntilDone();
//
//        UI.writeLine("Training And:");
//        UI.writeLine("=============");
//        new Trainer(Create21Network(), andCases, CheckCorrect)
//            .TrainUntilDone();
//
//        UI.writeLine("Training Nand:");
//        UI.writeLine("==============");
//        new Trainer(Create21Network(), nandCases, CheckCorrect)
//            .TrainUntilDone();
//
//        UI.writeLine("Training Xor:");
//        UI.writeLine("=============");
//        new Trainer(new Network(2, new []{2} , 1, learnRate), xorCases, CheckCorrect)
	}
}
