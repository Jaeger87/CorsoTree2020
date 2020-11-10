package module_08.supermarket;

import java.util.*;

public class Supermarket {
    //Queue<Customer> queue = new PriorityQueue<>(); //queue version
    TreeSet<Customer> queue = new TreeSet<>();

    public void addCustomer(Customer customer) {
        //queue.offer(customer); //queue version
        queue.add(customer);
    }

    public void removeCustomer(Customer customer) {
        queue.remove(customer);
    }

    public Customer getNextCustomer() {
        return queue.pollFirst();
        //return queue.poll(); //queue version
    }

    public int getTotalCustomersCount() {
        return queue.size();
    }

    public static void main(String[] args) {
        Customer c1 = new Customer("123", "mario", "rossi",18);
        Customer c2 = new Customer("112", "maria", "rossi",88);
        Customer c3 = new Customer("133", "marione", "rossi",25);
        Customer c4 = new Customer("134", "marco", "bianchi",18);
        Supermarket supermarket = new Supermarket();
        supermarket.addCustomer(c1);
        supermarket.addCustomer(c2);
        supermarket.addCustomer(c3);
        supermarket.addCustomer(c4);
        System.out.println(supermarket.getTotalCustomersCount() == 4);
        Customer next = supermarket.getNextCustomer();
        System.out.println(next.getName().equals("maria"));
        next = supermarket.getNextCustomer();
        System.out.println(next.getName().equals("marione"));
        next = supermarket.getNextCustomer();
        System.out.println(next.getName().equals("mario"));
        System.out.println(supermarket.getTotalCustomersCount() == 1);
    }
}
