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


public class TicketingSystem {
    public static Queue<Integer> queue = new LinkedList<>();
    
    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new SalesAssisstantTask(), 0, 5000); //run code in the SalesAssistantTask run() method every 3 seconds
        timer.schedule(new CustomerAdd(), 0, 3000);
    }
    public static class SalesAssisstantTask extends TimerTask { //inner class
       
        public void run() {
            System.out.println("\nSales Assistant is ready to see the next customer."); 
            System.out.println("The customer with ticket number " + queue.peek() + " will be seen.");
            queue.poll();
            System.out.println("The customers with the following tickets are in the queue" + queue +"\n");
            
        }
    }
    
    public static class CustomerAdd extends TimerTask { //inner class
       public int num = 1;
       
        public void run() {
            queue.add(num);
            System.out.println("Customer with ticket " + num + " is added to the queue.");
            num++;
        }
    }
   
    
}