package Neuron;

import java.io.Serializable;

public class ANeuron extends Neuron implements Serializable {
    private static final long serialVersionUID = 1372545293329104584L;
    public ANeuron(double[] inputs, double[] weights) {
        super(inputs, weights);
    }
    public int activate(){
        //System.out.println("A out = "+out());
        return out()>=0? 1 : -1;
    }

}
