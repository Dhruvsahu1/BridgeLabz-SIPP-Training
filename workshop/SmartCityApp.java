import java.time.*;
import java.util.*;
import java.util.stream.*;

public class SmartCityApp {
    public static void main(String[] args) {
        BusService bus = new BusService("BUS-101");
        MetroService metro = new MetroService("METRO-Red");
        TaxiService taxi = new TaxiService("TAXI-Prime");
        AmbulanceService ambulance = new AmbulanceService("AMB-24x7");

        List<TransportService> services = Arrays.asList(bus, metro, taxi, ambulance);

        Location home = new Location("Home", 28.61, 77.23);
        Location office = new Location("Office", 28.64, 77.21);

        bus.addSchedule(new Schedule("B1", "R1", ServiceType.BUS, bus.getId(), home, office, LocalDateTime.now().plusMinutes(30), 20));
        metro.addSchedule(new Schedule("M1", "R2", ServiceType.METRO, metro.getId(), home, office, LocalDateTime.now().plusMinutes(15), 15));
        taxi.addSchedule(new Schedule("T1", "R3", ServiceType.TAXI, taxi.getId(), home, office, LocalDateTime.now().plusMinutes(10), 50));
        ambulance.addSchedule(new Schedule("A1", "R4", ServiceType.AMBULANCE, ambulance.getId(), home, office, LocalDateTime.now().plusMinutes(5), 0));

        System.out.println("\n--- Available Options (sorted by time & fare) ---");
        List<Schedule> options = services.stream()
                .flatMap(s -> s.findSchedules(home, office).stream())
                .sorted(Comparator.comparing((Schedule s) -> s.departure).thenComparingDouble(s -> s.fare))
                .collect(Collectors.toList());

        options.forEach(System.out::println);

        System.out.println("\n--- Dashboard Live Services ---");
        services.forEach(TransportService::printServiceDetails);

        System.out.println("\n--- Revenue Reports ---");
        DoubleSummaryStatistics stats = options.stream()
                .collect(Collectors.summarizingDouble(s -> s.fare));
        System.out.println("Total: " + stats.getSum() + ", Avg: " + stats.getAverage());

        System.out.println("\n--- Adding FerryService ---");
        FerryService ferry = new FerryService("FERRY-1");
        ferry.addSchedule(new Schedule("F1", "R5", ServiceType.FERRY, ferry.getId(), home, office, LocalDateTime.now().plusMinutes(40), 25));
        ferry.printServiceDetails();

        System.out.println("\n--- Prioritized Services (Emergency First) ---");
        services = new ArrayList<>(services);
        services.add(ferry);
        services.stream()
                .sorted(Comparator.comparing(s -> !(s instanceof EmergencyService)))
                .forEach(System.out::println);
    }
}

interface TransportService {
    String getId();
    ServiceType getType();
    List<Schedule> findSchedules(Location from, Location to);
    List<Schedule> getSchedules();
    default void printServiceDetails() {
        System.out.println(getType() + " Service [" + getId() + "]");
    }
}

@FunctionalInterface
interface FareCalculator {
    double calculateFare(double distance);
}

interface EmergencyService {}

enum ServiceType { BUS, METRO, TAXI, AMBULANCE, FERRY }

class Location {
    String name; double lat, lon;
    Location(String name, double lat, double lon) { this.name = name; this.lat = lat; this.lon = lon; }
    @Override public String toString() { return name; }
}

class Schedule {
    String id, routeId, serviceId;
    ServiceType type;
    Location from, to;
    LocalDateTime departure;
    double fare;

    Schedule(String id, String routeId, ServiceType type, String serviceId, Location from, Location to, LocalDateTime departure, double fare) {
        this.id = id; this.routeId = routeId; this.type = type; this.serviceId = serviceId;
        this.from = from; this.to = to; this.departure = departure; this.fare = fare;
    }

    @Override
    public String toString() {
        return type + " [" + id + "] " + from + " -> " + to + " dep=" + departure.toLocalTime() + " fare=" + fare;
    }
}

abstract class BaseService implements TransportService {
    String id; ServiceType type; List<Schedule> schedules = new ArrayList<>();
    BaseService(ServiceType type, String id) { this.type = type; this.id = id; }

    public String getId() { return id; }
    public ServiceType getType() { return type; }
    public List<Schedule> getSchedules() { return schedules; }
    public void addSchedule(Schedule s) { schedules.add(s); }

    public List<Schedule> findSchedules(Location from, Location to) {
        return schedules.stream()
                .filter(s -> s.from.equals(from) && s.to.equals(to))
                .collect(Collectors.toList());
    }

    @Override public String toString() { return type + "-" + id; }
}

class BusService extends BaseService { BusService(String id) { super(ServiceType.BUS, id); } }
class MetroService extends BaseService { MetroService(String id) { super(ServiceType.METRO, id); } }
class TaxiService extends BaseService { TaxiService(String id) { super(ServiceType.TAXI, id); } }
class AmbulanceService extends BaseService implements EmergencyService { AmbulanceService(String id) { super(ServiceType.AMBULANCE, id); } }
class FerryService extends BaseService { FerryService(String id) { super(ServiceType.FERRY, id); } }