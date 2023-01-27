/**
 * @author Nolan Tremelling
 * @version 1.0
 * 23 January 2023
 *
 * A project that produces numerical values for statistical multiplexing
 * for both circuit switching and packet switching applications.
 */

import java.lang.Math;
import java.math.BigDecimal;
import java.math.BigDecimal;

public class statisticalMultiplexingCalculator {
    static int circuitSwitching(int L, int r){
        int MC = L/r;
        return MC;
    }

    static BigDecimal factorial(BigDecimal x){
        if(x.equals(BigDecimal.ONE) || x.equals(BigDecimal.ZERO)){
            return BigDecimal.valueOf(1);
        }
        else{
            x = x.multiply(factorial(x.subtract(BigDecimal.ONE)));
        }
        return x;
    }

    static BigDecimal binomialCoefficient(BigDecimal MP, BigDecimal N){
        return factorial(MP).divide((factorial(N).multiply(factorial(MP.subtract(N)))));
    }

    static BigDecimal packetSwitching(BigDecimal MP, BigDecimal N, BigDecimal p){
        BigDecimal binomialCoefficient = binomialCoefficient(MP, N);

        return binomialCoefficient.multiply((p.pow(N.intValue())).multiply((BigDecimal.ONE.subtract(p)).pow((MP.subtract(N)).intValue())));
    }

    public static void main(String[] args){
        System.out.println("MC = " + circuitSwitching(1000000, 64000));

        BigDecimal probability = new BigDecimal(String.valueOf(0));
        BigDecimal MP = new BigDecimal(String.valueOf(60));
        BigDecimal p = new BigDecimal(String.valueOf(.1));

        for(int i = 0; i <= 15; i++){
            BigDecimal N = new BigDecimal(String.valueOf(i));
            probability = probability.add(packetSwitching(MP, N, p));
        }
        System.out.println(BigDecimal.ONE.subtract(probability));
    }
}
