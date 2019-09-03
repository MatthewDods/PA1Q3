/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticketingsystem;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Timer;
import java.util.TimerTask;

/**
 * TicketingSystem, runs method on time schedule demonstrates queue usage
 * @author Matthew Dods 420190038
 */
public class TicketingSystem {
    public static Queue<Integer> queue = new LinkedList<>();
     
    /**
      * 
      * @param args 
      */
    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new SalesAssisstantTask(), 0, 5000); // every 5 seconds do this method.
        timer.schedule(new CustomerAdd(), 0, 3000); // every 3 seconds do this method.
    }
    
    /**
     * SalesAssistantTask, Says what customer is seeing and removes top from queue (first in first out)
     */
    public static class SalesAssisstantTask extends TimerTask { //inner class
       
        public void run() {
            System.out.println("\nSales Assistant is ready to see the next customer."); 
            System.out.println("The customer with ticket number " + queue.peek() + " will be seen.");
            queue.poll();
            System.out.println("The customers with the following tickets are in the queue" + queue +"\n");
            
        }
    }
    
    /**
     * CustomerAdd, adds a new customer to the queue.
     */
    public static class CustomerAdd extends TimerTask { //inner class
       public int num = 1; // so that num will properly increment instead of being reinitialised each call
       
        public void run() {
            queue.add(num);
            System.out.println("Customer with ticket " + num + " is added to the queue.");
            num++;
        }
    }
   
    
}