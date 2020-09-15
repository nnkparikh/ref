package net.neelparikh.myfancypdfinvoices.service;

import net.neelparikh.myfancypdfinvoices.context.Application;
import net.neelparikh.myfancypdfinvoices.model.Invoice;
import net.neelparikh.myfancypdfinvoices.model.User;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class InvoiceService {
    List<Invoice> invoices = new CopyOnWriteArrayList<>();
    private final UserService userService;

    public InvoiceService(UserService userService){
        this.userService = userService;
    }

    public List<Invoice> findAll(){
        return invoices;
    }

    public Invoice create(String userId, Integer amount){
        User user = userService.findById(userId);
        if (user == null){
            throw new IllegalStateException();
        }
        Invoice invoice = new Invoice(userId, amount, "http://www.africau.edu/images/default/sample.pdf");
        invoices.add(invoice);
        return invoice;
    }
}
