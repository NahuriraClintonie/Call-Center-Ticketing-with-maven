package org.pahappa.systems.ticketing.services.impl;

import org.pahappa.systems.ticketing.DAO.TicketDAO;
import org.pahappa.systems.ticketing.constants.TicketStatus;
import org.pahappa.systems.ticketing.models.Ticket;
import org.pahappa.systems.ticketing.services.TicketService;

import java.util.ArrayList;
import java.util.List;

public class TicketServiceImpl implements TicketService {
    private List<Ticket> ticketList = new ArrayList<>();
    private final TicketDAO dao;

    public TicketServiceImpl(){
        this.dao = new TicketDAO();
    }

    public TicketServiceImpl(List<Ticket> ticketList) {
        this.ticketList = ticketList;
        this.dao = new TicketDAO();
    }

    @Override
    public void createTicket(Ticket ticket) {
        dao.save(ticket);
        // ticketList.add(ticket);
    }

    @Override
    public List<Ticket> getAllTickets() {
        // return ticketList;
        return dao.getAllTickets();
    }

@Override
public List<Ticket> getTicketsOfStatus(TicketStatus ticketStatus) {
    return dao.getTicketsOfStatus(ticketStatus);
}

    @Override
    public void updateTicket(Ticket updatedTicket) {
    dao.updateTicket(updatedTicket);
    
    }

    @Override
    public void deleteTicket(String ticketId) {
        dao.deleteTicket(ticketId);
    }
    }
