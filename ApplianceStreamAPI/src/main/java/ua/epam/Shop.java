package ua.epam;

import ua.epam.model.Appliance;
import ua.epam.model.Client;
import ua.epam.model.Employee;
import ua.epam.model.Manufacturer;
import ua.epam.model.Order;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class Shop implements Add, Find, Sort {

    private Set<Client> clients;
    private Set<Employee> employees;
    private Set<Order> orders;
    private Set<Appliance> appliances;
    private Set<Manufacturer> manufacturers;

    public Shop() {
        this.clients = new HashSet<>();
        this.employees = new HashSet<>();
        this.orders = new HashSet<>();
        this.appliances = new HashSet<>();
        this.manufacturers = new HashSet<>();
    }

    public Shop(Set<Client> clients, Set<Employee> employees, Set<Order> orders,
                Set<Appliance> appliances, Set<Manufacturer> manufacturers) {
        this.clients = clients;
        this.employees = employees;
        this.orders = orders;
        this.appliances = appliances;
        this.manufacturers = manufacturers;
    }

    public Set<Client> getClients() {
        return clients;
    }

    public void setClients(Set<Client> clients) {
        this.clients = clients;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    public Set<Appliance> getAppliances() {
        return appliances;
    }

    public void setAppliances(Set<Appliance> appliances) {
        this.appliances = appliances;
    }

    public Set<Manufacturer> getManufacturers() {
        return manufacturers;
    }

    public void setManufacturers(Set<Manufacturer> manufacturers) {
        this.manufacturers = manufacturers;
    }

    // ---------- Add ----------

    @Override
    public void addClient(Client client) {
        clients.add(client);
    }

    @Override
    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    @Override
    public void addAppliance(Appliance appliance) {
        appliances.add(appliance);
    }

    @Override
    public void addOrder(Order order) {
        orders.add(order);
    }

    @Override
    public void addManufacturer(Manufacturer manufacturer) {
        manufacturers.add(manufacturer);
    }

    // ---------- Find ----------

    @Override
    public Manufacturer findManufacturerById(long id) {
        return manufacturers.stream()
                .filter(manufacturer -> manufacturer.getId() == id)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Manufacturer with id=" + id + " was not found"));
    }

    @Override
    public Manufacturer findManufacturerByName(String name) {
        return manufacturers.stream()
                .filter(manufacturer -> Objects.equals(manufacturer.getName(), name))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Manufacturer with mane=" + name + " was not found"));
    }

    @Override
    public List<Order> findOrderByEmployee(Employee employee) {
        return orders.stream()
                .filter(order -> Objects.equals(order.getEmployee(), employee))
                .collect(Collectors.toList());
    }

    @Override
    public Order findCheapestOrder() {
        return orders.stream()
                .min(Comparator.comparing(this::calculateOrderAmount))
                .orElseThrow(() -> new RuntimeException("Order not found"));
    }

    @Override
    public Order findMostExpensiveOrder() {
        return orders.stream()
                .max(Comparator.comparing(this::calculateOrderAmount))
                .orElseThrow(() -> new RuntimeException("Order not found"));
    }

    // ---------- Sort ----------

    @Override
    public List<Manufacturer> sortManufacturersByName() {
        return manufacturers.stream()
                .sorted(Comparator.comparing(Manufacturer::getName,
                        Comparator.nullsLast(Comparator.naturalOrder())))
                .collect(Collectors.toList());
    }

    @Override
    public List<Order> sortOrderByClientId() {
        return orders.stream()
                .sorted(Comparator.comparing(order -> order.getClient().getId()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Appliance> sortAppliancesByCategory() {
        return appliances.stream()
                .sorted(Comparator.comparing(Appliance::getCategory))
                .collect(Collectors.toList());
    }

    @Override
    public List<Order> sortOrderByAmount() {
        return orders.stream()
                .sorted(Comparator.comparing(this::calculateOrderAmount))
                .collect(Collectors.toList());
    }

    // ---------- helpers ----------

    private BigDecimal calculateOrderAmount(Order order) {
        return order.getAppliances().values().stream()
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    @Override
    public String toString() {
        return "Shop{" +
                "clients=" + clients +
                ", employees=" + employees +
                ", orders=" + orders +
                ", appliances=" + appliances +
                ", manufacturers=" + manufacturers +
                '}';
    }
}
