/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pldp_thesis;

/**
 *
 * @author Mousumi
 */
public class PLDP_thesis {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ReadData r=new ReadData();
        r.readFile();
        //System.out.println("min salary "+r.tau_min);
        //System.out.println("max salary "+r.tau_max);
//sum query start        
//%user change korle avg er jonno absolute error kototuku hoy         
//        double i=0.2;
//        while(i<=1)
//        {
//            
//            double safe_region=r.tau_max;
//            int s = r.total_user;
//            int p=(int)(i*s);
//            
//            double rand_result=r.randomize_response(safe_region,p);
//            rand_result=rand_result*safe_region;
//            //System.out.println("rand_result "+rand_result);
//            //System.out.println("actual toatal salary "+r.actual_total_salary);
//            double abs_error=Math.abs(r.actual_total_salary-rand_result)/r.actual_total_salary;
//            System.out.println(i+" "+abs_error);
//            i+=0.2;
//        }
        
 
//change safe range      
//            double safe_region=r.tau_max;
//            int s = r.total_user;
//            int p=(int)(0.5*s);  //% of user
//            
//            for(double i=(double) 1.0;i<=1.5;i+=0.1)
//            {
//                double rand_result=r.randomize_response(i*safe_region,p);
//                rand_result=rand_result*safe_region*i;
//                //System.out.println("rand_result "+rand_result);
//                //System.out.println("actual total salary "+r.actual_total_salary);
//                double abs_error=Math.abs(r.actual_total_salary-rand_result)/r.actual_total_salary;
//                System.out.println(i+" "+abs_error);
//                
//            }
            
//change privacy level           
//            double safe_region=r.tau_max;
//            int s = r.total_user;
//            int p=(int)(0.5*s);  //% of user
//            
//            for(double i=1;i<=1;i+=2)
//            {
//                double rand_result=r.randomize_response(i*safe_region,p);
//                rand_result=rand_result*safe_region*i;
//                //System.out.println("rand_result "+rand_result);
//                //System.out.println("actual total salary "+r.actual_total_salary);
//                double abs_error=Math.abs(r.actual_total_salary-rand_result)/r.actual_total_salary;
//                System.out.println(i+" "+abs_error);
//                
//            }
            
//sum query ends           

//max query starts
// %user change korle max er jonno absolute error kototuku hoy         
        double i=0.2;
        while(i<=1)
        {
            
            double safe_region=r.tau_max;
            int s = r.total_user;
            int p=(int)(0.5*s);
            
            double rand_result=r.randomize_response(safe_region,p);
            rand_result=rand_result*safe_region;
            //System.out.println("rand_result "+rand_result);
            //System.out.println("actual max salary "+r.tau_max);
            //double abs_error=Math.abs(r.tau_max-rand_result)/(r.tau_max-r.tau_min);
            double abs_error=Math.abs(r.tau_min-rand_result)/(r.tau_max-r.tau_min);
            System.out.println(i+" "+abs_error);
            i+=0.9;
        }        
        
//   
//            double safe_region=r.tau_max;
//            int p=(int)(0.5*r.total_user);  //% of user
//            
//            for(double i=(double) 1.0;i<=1.51;i+=0.1)
//            {
//                double rand_result=r.randomize_response(i*safe_region,p);
//                rand_result=rand_result*safe_region*i;
//                //System.out.println("rand_result "+rand_result);
//                //System.out.println("actual max salary "+r.tau_max);
//                //double abs_error=Math.abs(r.tau_max-rand_result)/(r.tau_max-r.tau_min);
//                double abs_error=Math.abs(r.tau_min-rand_result)/(r.tau_max-r.tau_min);
//                System.out.println(i+" "+abs_error);
//                
//            }
    }
//max query ends    
}
