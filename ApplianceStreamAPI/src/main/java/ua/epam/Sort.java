package ua.epam;

import ua.epam.model.Appliance;
import ua.epam.model.Manufacturer;
import ua.epam.model.Order;

import java.util.List;

public interface Sort {

    List<Manufacturer> sortManufacturersByName();

    List<Order> sortOrderByClientId();

    List<Appliance> sortAppliancesByCategory();

    List<Order> sortOrderByAmount();
}
