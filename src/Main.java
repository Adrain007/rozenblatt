import NeuralNet.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Arrays;

public class Main {
    public static void main(String[] args){
        /*NeuralNet net = new NeuralNet(15,300,26);
        Study study = new Study(net);
        study.initNet();
        study.study();*/
        try{
            ObjectInputStream is = new ObjectInputStream(new FileInputStream("Net2.ser"));
            NeuralNet net = (NeuralNet) is.readObject();
            for(int i = 0; i < 26;i++){
                net.execute(net.getPatterns()[i]);
            }
            //net.execute(net.getPatterns()[22]);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
