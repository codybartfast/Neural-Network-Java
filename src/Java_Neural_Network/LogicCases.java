package Java_Neural_Network;

public class LogicCases {

	static Sample[] notCases = new Sample[]{
            Sample.create("0", "1"),
            Sample.create("1", "0"),
    };
	
	static Sample[] orCases = new Sample[]{
        Sample.create("0 0", "0"),
        Sample.create("0 1", "1"),
        Sample.create("1 0", "1"),
        Sample.create("1 1", "1"),
    };

	static Sample[] andCases = new Sample[]{
        Sample.create("0 0", "0"),
        Sample.create("0 1", "0"),
        Sample.create("1 0", "0"),
        Sample.create("1 1", "1"),
    };

	static Sample[] nandCases = new Sample[]{
	Sample.create("0 0", "1"),
        Sample.create("0 1", "1"),
        Sample.create("1 0", "1"),
        Sample.create("1 1", "0"),
    };

	static Sample[] xorCases = new Sample[]{
        Sample.create("0 0", "0"),
        Sample.create("0 1", "1"),
        Sample.create("1 0", "1"),
        Sample.create("1 1", "0"),
    };	
	
}
