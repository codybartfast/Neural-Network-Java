package Java_Neural_Network;

import java.util.Random;

public abstract class Activation {
	
    public abstract double CalcValue(double x);
    public abstract double CalcDerivative(double x);
    public abstract double GetRandomWeight();

    class SigmoidActivation extends Activation
    {

        public double CalcValue(double x)
        {
            return 1 / (1 + Math.exp(-x));
        }

        public double CalcDerivative(double x)
        {
            return x * (1 - x);
        }

        Random rnd = new Random();
        public double GetRandomWeight()
        {
            return (rnd.nextDouble() * 2) - 1;
        }
    } 

}
