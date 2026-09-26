package ua.epam;

import ua.epam.model.Appliance;
import ua.epam.model.Client;
import ua.epam.model.Employee;
import ua.epam.model.Manufacturer;
import ua.epam.model.Order;

public interface Add {

    void addClient(Client client);

    void addEmployee(Employee employee);

    void addAppliance(Appliance appliance);

    void addOrder(Order order);

    void addManufacturer(Manufacturer manufacturer);
}
