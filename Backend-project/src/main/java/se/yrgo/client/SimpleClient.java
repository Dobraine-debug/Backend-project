package se.yrgo.client;


import jakarta.persistence.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import se.yrgo.domains.Customer;
import se.yrgo.domains.Invoice;
import se.yrgo.services.customers.CustomerService;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.List;

public class SimpleClient {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext container = new ClassPathXmlApplicationContext("application.xml");
        try  {

        }

        finally {
            container.close();
        }

    }
}