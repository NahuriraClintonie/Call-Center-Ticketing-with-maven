package org.pahappa.systems.ticketing.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.pahappa.systems.ticketing.config.SessionConfiguration;
import org.pahappa.systems.ticketing.constants.TicketStatus;
import org.pahappa.systems.ticketing.models.Ticket;

public class TicketDAO {
    public List<Ticket> getAllTickets(){
        Session session = SessionConfiguration.getSessionFactory().openSession();
        return session.createCriteria(Ticket.class).list();
    }
    
    public List<Ticket> getTickets(){
        Session session = SessionConfiguration.getSessionFactory().openSession();
        return session.createCriteria(Ticket.class).list();
    }

    public void save(Ticket ticket) {
        Session session = SessionConfiguration.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            session.save(ticket);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
    public List<Ticket> getTicketsOfStatus(TicketStatus ticketStatus) {
        Session session = SessionConfiguration.getSessionFactory().openSession();
        Query query = session.createQuery("FROM Ticket WHERE status = :status");
        query.setParameter("status", ticketStatus.toString());
        return query.list();
    }

    public void updateTicket(Ticket updatedTicket) {
        Session session = SessionConfiguration.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            session.update(updatedTicket);
            transaction.commit();
            System.out.println("Ticket updated successfully!");
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

        public void deleteTicket(String ticketId) {
            Session session = SessionConfiguration.getSessionFactory().openSession();
            Transaction transaction = null;
    
            try {
                transaction = session.beginTransaction();
    
                // Load the ticket to be deleted
                Ticket ticket = (Ticket)session.get(Ticket.class, ticketId);
    
                if (ticket != null) {
                    // Delete the ticket
                    session.delete(ticket);
                    transaction.commit();
                    System.out.println("Ticket deleted successfully.");
                } else {
                    System.out.println("Ticket not found.");
                }
            } catch (Exception e) {
                if (transaction != null) {
                    transaction.rollback();
                }
                e.printStackTrace();
            } finally {
                session.close();
            }
        }
}
