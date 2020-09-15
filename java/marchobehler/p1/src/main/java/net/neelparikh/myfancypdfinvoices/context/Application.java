package net.neelparikh.myfancypdfinvoices.context;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.neelparikh.myfancypdfinvoices.service.InvoiceService;
import net.neelparikh.myfancypdfinvoices.service.UserService;

public class Application {
    public static final UserService userService = new UserService();
    public static final InvoiceService invoiceService = new InvoiceService(userService);
    public static final ObjectMapper objectMapper = new ObjectMapper();
}
