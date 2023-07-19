package org.pahappa.systems.ticketing;

/**
 * Developed by Dev Clintonie @clintonnahurira24@gmail.com
 *
 */

 import org.pahappa.systems.ticketing.views.TicketView;
public class App 
{
    public static void main(String[] args) {
        TicketView ticketView = new TicketView();
        ticketView.displayMenu();
    }
}
