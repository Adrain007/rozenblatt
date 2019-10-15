package NeuralNet;

import Neuron.RNeuron;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;

public class Study {
    private static final long serialVersionUID = 1372545293329104584L;
    private static final double a = 0.5;
    private NeuralNet net;

    public Study(NeuralNet net) {
        this.net = net;
    }

    public void initNet() {
        net.initAW(net.getPatterns()[0]);
        net.initRW(net.countAOut());
    }

    public void study() {
        double[][] patterns = net.getPatterns();
        double[] error = new double[0];
        double E = 0;
        do {
            for (int numOfPatterns = 0; numOfPatterns < patterns.length; numOfPatterns++) {
                net.setAInputs(patterns[numOfPatterns]);
                double[] aOut = net.countAOut();
                net.setRInputs(aOut);
                error = net.countRErr(net.countROut(), net.getAnswers()[numOfPatterns]);
                if(!Arrays.equals(net.getROut(),net.getAnswers()[numOfPatterns])) {
                    ArrayList<RNeuron> rNeurons = net.getRLayer();
                    for (int idx = 0; idx < rNeurons.size(); idx++) {
                        RNeuron rNeuron = rNeurons.get(idx);
                        double[] outWeights = rNeuron.getWeights();
                        double[] newWeights = new double[outWeights.length];
                        for (int idy = 0; idy < rNeuron.getWeights().length; idy++) {
                            newWeights[idy] = outWeights[idy] + a * aOut[idy] * error[idx];
                            rNeuron.setPorog(rNeuron.getPorog() + a * aOut[idy] * error[idx]);
                            //System.out.println("new weight = "+newWeights[idy]);
                        }
                        rNeuron.setWeights(newWeights);
                    }
                }
            }
            net.execute(patterns[2]);
        } while (!Arrays.equals(net.getROut(),net.getAnswers()[2]));
        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("Net2.ser"));
            os.writeObject(net);
        }catch (IOException e){
            e.printStackTrace();
        }
        for(int i = 0; i < 26;i++){
            System.out.print(i+" - ");
            net.execute(net.getPatterns()[i]);
        }
    }
}
