/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pldp_thesis;

import java.io.BufferedReader;
import java.io.FileReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

/**
 *
 * @author Mousumi
 */
public class ReadData {
    public ArrayList<User> userList;
    public double tau_max=0;
    public double tau_min=0;
    public int total_user=0;
    public double actual_total_salary=0;
    public ReadData()
    {
        userList= new ArrayList<>();
        
    }
    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
    public void readFile()
    {
        double max=Double.MIN_VALUE;
        double min=Double.MAX_VALUE ;
        BufferedReader br = null;
        String line = "";
        try {
            //br = new BufferedReader(new FileReader("RealData.txt"));
            br = new BufferedReader(new FileReader("ipum_data.txt"));
            int id=1;
            while ((line = br.readLine()) != null)
            {
                //each user is added to list
                User user=new User();
                //String [] s= line.split(" ");
                //user.userID=Integer.parseInt(s[0]);
                user.id=id;
                /* //for real data
                
                line=line.replace(line.charAt(0), '\0');
                line=line.replace(line.charAt(0), '\0');
                line=line.trim();
                line=line.replace(line.charAt(0), '\0');
                line=line.replaceAll(",", "");
                        */
                //System.out.println(line);
                user.salary=Double.parseDouble(line);
                id++;
                if(user.salary<=0.0) continue;
                    
                //System.out.println(user.salary);
                else
                {
                    userList.add(user);
                    //System.out.println("ID "+user.userID+" salary "+user.salary);
                    //id++;
                    total_user++;
                    actual_total_salary+=user.salary;
                    max=Math.max(max, user.salary);            
                    min=Math.min(min,user.salary); 
                    
                }
                
                
            }
            
            //System.out.println("total "+totalUser);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        //System.out.println("min salary "+min);
        //System.out.println("max salary "+max);
        tau_max=max;
        tau_min=min;
        //System.out.println("maximum salary "+max);
    }
    void show()
    {
        for(int i=0;i<userList.size();i++)
        {
            userList.get(i).show();
        }
    }
    
    double normalise_salary(double range,double salary)
    {
        double t=range/2;
        double n = 0;
        if(salary>t)
        {
            n=(1/t)*(salary-t);
        }
        if(salary<=t)
        {
            n=(1/t)*salary;
            n=-(1-n);
        }
        //System.out.println("normalize value "+n);
        return n;
    }
    
    double randomize_response(double tau,int p)
    {
        double max=Double.MIN_VALUE;
        double min=Double.MAX_VALUE ;
        double []epsilon = {0.05,0.10,0.15,0.2,0.25,0.3,0.35,0.37,0.4,0.45,0.47,0.5,0.55,0.6,0.65,0.7,0.75,0.8,0.85,0.9,0.95,1.0};
        double sum_rand_response=0.0;
        for(int i=0;i<p;i++)
        {
           
            double r_salary=0;
            double salary=userList.get(i).salary;
            double n_salary=normalise_salary(tau,salary);
            //double per_epsilon=0.5;
            Double  toBeTruncated= RandomGeneration.zeroToOneRand();

            Double truncatedDouble = BigDecimal.valueOf(toBeTruncated)
                .setScale(2, RoundingMode.HALF_UP)
                .doubleValue();
            //System.out.println(per_epsilon);
            //double x=Math.exp(per_epsilon);
            double per_epsilon=truncatedDouble*1.0;  //PLDP
            //int m=RandomGeneration.randInt(0, epsilon.length-1);
            //double per_epsilon=epsilon[m];
            //double per_epsilon=1.0;  //LDP
            
            double x=Math.exp(per_epsilon);
            //System.out.println("epsilon "+per_epsilon+" x "+x);
            double pr=(x/1+x);
            double r=RandomGeneration.zeroToOneRand();
            if(r<=pr)
            {
                r_salary=(x+1)/(x-1);
            }
            else
            {
                r_salary=-1*(x+1)/(x-1);
            }
            
            r_salary=round(r_salary,2);
            max=Math.max(max, r_salary);
            min=Math.min(min, r_salary);
            //System.out.println(r_salary);
            sum_rand_response+=r_salary; 
            sum_rand_response=round(sum_rand_response,2);
            //System.out.println("");
            //System.out.println(sum_rand_response);
            //System.out.println( String.format( "%.2f", sum_rand_response ) );
        }
        
        //System.out.println(" sum "+sum_rand_response);
        
        //for sum
        //return sum_rand_response;
        //for max
        //return max;
        //for min
        return min;
        
    }
    
}
