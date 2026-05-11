package se.yrgo.client;


import jakarta.persistence.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import se.yrgo.domains.Customer;
import se.yrgo.domains.Employee;
import se.yrgo.domains.Invoice;
import se.yrgo.domains.Schedule;
import se.yrgo.domains.RestaurantTable;
import se.yrgo.services.bookings.BookingService;
import se.yrgo.services.customers.CustomerService;
import se.yrgo.services.employees.EmployeeNotFoundException;
import se.yrgo.services.employees.EmployeeService;
import se.yrgo.domains.*;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.List;

public class SimpleClient {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext container = new ClassPathXmlApplicationContext("application.xml");

        try {

        } finally {
            container.close();
        }
    }
}