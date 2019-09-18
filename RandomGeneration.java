/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pldp_thesis;

import java.util.Random;

/**
 *
 * @author Mousumi
 */
public class RandomGeneration {
    public static double zeroToOneRand()
    {
        Random r = new Random();
        double zeroToOne = r.nextInt(1001) / 1000.0;
        if(zeroToOne<=0.05)
        {
            return 0.1;
        }
        if(zeroToOne>=0.95)
        {
            return 0.95;
        }
        else return zeroToOne;
               
    }
    public static int randInt(int Min, int Max) {   //(1,5) deya mane 1 theke 4 er modhe random no dibe

    return Min + (int)(Math.random() * ((Max - Min) + 1));
    } 
    
    public static double randPart(double Min, double Max) {   //(1,5) deya mane 1 theke 4 er modhe random no dibe

    return Min + (double)(Math.random() * ((Max - Min) + 1));
    } 
    public static double randdouble(double Min, double deviation) {   //(1,5) deya mane 1 theke 4 er modhe random no dibe
    double p=zeroToOneRand();
    if(p<0.5)
    {
        return Min + (double)(Math.random() * ((deviation/100)*Min + 1));
    }
    else
    {
        return Min - (double)(Math.random() * ((deviation/100)*Min + 1));
        
    }
    
    } 
    public static double[] divideData(double data,int part)
    {
        double[] dataPart=new double[part];
        double d=data;
        
        for(int i=0;i<part-1;i++)
        {
            dataPart[i]=randPart(-d, d);           
            
        }
        
        double val=0;
        for(int i=0;i<part-1;i++)
        {
            val+=dataPart[i];
        }
        //System.out.println("val: "+val );
        dataPart[part-1]=d-val;
        return dataPart;
    }
    
}
