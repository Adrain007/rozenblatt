package Neuron;

import java.io.Serializable;

public abstract class Neuron implements Serializable {
    private static final long serialVersionUID = 1372545293329104584L;
    private double [] inputs;
    private double [] weights;

    Neuron(double[] inputs, double[] weights){
        this.inputs = inputs;
        this.weights = weights;
    }

    public double[] getWeights() {
        return weights;
    }

    public void setInputs(double[] inputs) {
        this.inputs = inputs;
    }

    public void setWeights(double[] weights) {
        this.weights = weights;
    }

    double out(){
        double sum = 0;
        for(int j = 0;j<this.inputs.length;j++){
            sum+=this.inputs[j]*this.weights[j];
        }
        return sum;
    }
}
