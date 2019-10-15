package NeuralNet;

import Neuron.ANeuron;
import Neuron.RNeuron;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

public class NeuralNet implements Serializable{
    private static final long serialVersionUID = 1372545293329104584L;
    private double[] SLayer;
    private double[] AOut;
    private double[] ROut;
    private double[] RErr;
    private ArrayList<ANeuron> ALayer;
    private ArrayList<RNeuron> RLayer;
    private double[][] patterns = {
            {0,1,0,1,0,1,1,1,1,1,0,1,1,0,1},//A
            {1,1,0,1,0,1,1,1,0,1,0,1,1,1,0},//B
            {0,1,1,1,0,0,1,0,0,1,0,0,0,1,1},//C
            {1,1,0,1,0,1,1,0,1,1,0,1,1,1,0},//D
            {1,1,1,1,0,0,1,1,1,1,0,0,1,1,1},//E
            {1,1,1,1,0,0,1,1,0,1,0,0,1,0,0},//F
            {0,1,1,1,0,0,1,0,0,1,0,1,0,1,1},//G
            {1,0,1,1,0,1,1,1,1,1,0,1,1,0,1},//H
            {1,1,1,0,1,0,0,1,0,0,1,0,1,1,1},//I
            {1,1,1,0,0,1,0,0,1,1,0,1,0,1,1},//J
            {1,0,1,1,1,0,1,1,0,1,1,0,1,0,1},//K
            {1,0,0,1,0,0,1,0,0,1,0,0,1,1,1},//L
            {1,0,1,1,1,1,1,0,1,1,0,1,1,0,1},//M
            {1,0,1,1,0,1,1,0,1,1,1,1,1,0,1},//N
            {0,1,0,1,0,1,1,0,1,1,0,1,0,1,0},//0
            {1,1,0,1,0,1,1,1,0,1,0,0,1,0,0},//P
            {0,1,0,1,0,1,1,0,1,1,1,1,0,1,0},//Q
            {1,1,0,1,0,1,1,1,0,1,0,1,1,0,1},//R
            {1,1,1,1,0,0,1,1,1,0,0,1,1,1,1},//S
            {1,1,1,0,1,0,0,1,0,0,1,0,0,1,0},//T
            {1,0,1,1,0,1,1,0,1,1,0,1,1,1,1},//U
            {1,0,1,1,0,1,1,0,1,1,0,1,0,1,0},//V
            {1,0,1,1,0,1,1,1,1,1,1,1,0,1,0},//W
            {1,0,1,1,0,1,0,1,0,1,0,1,1,0,1},//X
            {1,0,1,1,0,1,1,1,1,0,1,0,0,1,0},//Y
            {1,1,1,0,0,1,0,1,0,1,0,0,1,1,1}//Z
    };
    private double[][] answers = {
            /*{1,0,0,0,0,0},
            {0,1,0,0,0,0},
            {0,0,1,0,0,0},
            {0,0,0,1,0,0},
            {0,0,0,0,1,0},
            {0,0,0,0,0,1},*/
            {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1}
    };

    public NeuralNet(int S, int A, int R) {
        SLayer = new double[S];
        AOut = new double[A];
        ROut = new double[R];
        RErr = new double[R];
    }

    public double[] getROut() {
        return ROut;
    }

    public double[][] getPatterns() {
        return patterns;
    }

    double[][] getAnswers() {
        return answers;
    }

    private double[] initWeight(int numOfEl) {
        double[] weight = new double[numOfEl];
        for (int i = 0; i < weight.length; i++) {
            weight[i] = Math.random() * (-2) + 1;
        }
        return weight;
    }

    void initAW(double[] input){
        ALayer = new ArrayList<>();
        for ( double Aout: AOut ) {
            ALayer.add(new ANeuron(input,initWeight(input.length)));
        }
    }

    void initRW(double[] input){
        RLayer = new ArrayList<>();
        for ( double Rout: ROut ) {
            RLayer.add(new RNeuron(input,initWeight(input.length)));
        }
    }

    double[] countAOut(){
        int index = 0;
        for (ANeuron aNeuron: ALayer) {
            AOut[index] = aNeuron.activate();
            index++;
        }
        return AOut;
    }
    double[] countROut(){
        int index = 0;
        for (RNeuron rNeuron: RLayer) {
            ROut[index] = rNeuron.activate();
            index++;
        }
        return ROut;
    }
    void setAInputs(double[] in){
        for (ANeuron aNeuron: ALayer) {
            aNeuron.setInputs(in);
        }
    }

    void setRInputs(double[] in){
        for (RNeuron rNeuron: RLayer) {
            rNeuron.setInputs(in);
        }
    }

    public ArrayList<ANeuron> getALayer() {
        return ALayer;
    }

    ArrayList<RNeuron> getRLayer() {
        return RLayer;
    }

    double[] countRErr(double[] out, double[] goal){
        int index = 0;
        for (RNeuron rNeuron: RLayer) {
            RErr[index] = rNeuron.error(out[index],goal[index]);
            index++;
        }
        return RErr;
    }

    public void execute(double[] in){
        setAInputs(in);
        setRInputs(countAOut());
        countROut();
        System.out.println(Arrays.toString(ROut));
    }

}
