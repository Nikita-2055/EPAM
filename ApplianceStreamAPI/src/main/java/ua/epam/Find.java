package ua.epam;

import ua.epam.model.Employee;
import ua.epam.model.Manufacturer;
import ua.epam.model.Order;

import java.util.List;

public interface Find {

    Manufacturer findManufacturerById(long id);

    Manufacturer findManufacturerByName(String name);

    List<Order> findOrderByEmployee(Employee employee);

    Order findCheapestOrder();

    Order findMostExpensiveOrder();
}
