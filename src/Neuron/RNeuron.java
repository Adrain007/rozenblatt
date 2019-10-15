package Neuron;

import Neuron.Neuron;

import java.io.Serializable;

public class RNeuron extends Neuron implements Serializable {
    private static final long serialVersionUID = 1372545293329104584L;
    private double porog;

    public void setPorog(double porog) {
        this.porog = porog;
    }

    public double getPorog() {
        return porog;
    }

    public RNeuron(double[] inputs, double[] weights){
        super(inputs,weights);
    }
    public int activate(){
        //System.out.println("porog = "+porog);
        return out()>=porog? 1 : 0;
    }
    public double error(double out, double goal){
        //System.out.println("Err  = "+( goal - out));
        return goal - out;
    }
}
