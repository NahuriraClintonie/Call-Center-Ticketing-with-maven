package org.pahappa.systems.ticketing.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * A ticket refers to a unit of work or a request that is submitted
 * by a user or customer to seek assistance, report an issue, or request a service.
 * It serves as a record or a container that captures all the relevant information
 * related to the user's request or issue.
 */
@Entity
@Table(name = "ticket")
public class Ticket {
    
    private String ticketId;
    private String customerName;
    private String contactInfo;
    private String ticketCategory;
    private String description;
    private String status;
    private String priority;

    
    public Ticket() {
        // No-argument constructor
    }
    
    public Ticket(String ticketId, String customerName, String contactInfo, String ticketCategory, String description, String status, String priority) {
        this.ticketId = ticketId;
        this.customerName = customerName;
        this.contactInfo = contactInfo;
        this.ticketCategory = ticketCategory;
        this.description = description;
        this.status = status;
        this.priority = priority;
    }

    @Id
    @Column(updatable = false, name = "ticket_id", nullable = false, length=10)
    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    @Column(updatable = true, name = "customer_name", nullable = false, length=50)
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    @Column(updatable = true, name = "contact", nullable = false, length=50)
    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    @Column(updatable = true, name = "category", nullable = false, length=50)
    public String getTicketCategory() {
        return ticketCategory;
    }

    public void setTicketCategory(String ticketCategory) {
        this.ticketCategory = ticketCategory;
    }

    @Column(updatable = true, name = "description", nullable = false, length=500)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Enumerated(EnumType.ORDINAL)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    @Column(updatable = false, name = "priority", nullable = false, length=50)
    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }
}