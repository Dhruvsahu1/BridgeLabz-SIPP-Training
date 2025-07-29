
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PetAdoptionPortal {
    private List<pet> pets;

    public PetAdoptionPortal() {
        this.pets = new ArrayList<>();
    }

    public void addPet(pet pet) {
        pets.add(pet);
    }

    public List<pet> filterAvailablePetsByType(String type) {
        return pets.stream()
                .filter(pet -> pet.getType().equalsIgnoreCase(type) && !pet.isAdopted())
                .collect(Collectors.toList());
    }

    public List<pet> filterAvailablePetsByAge(int age) {
        return pets.stream()
                .filter(pet -> pet.getAge() == age && !pet.isAdopted())
                .collect(Collectors.toList());
    }

    public List<pet> filterAvailablePetsByTypeAndAge(String type, int age) {
        return pets.stream()
                .filter(pet -> pet.getType().equalsIgnoreCase(type) && pet.getAge() == age && !pet.isAdopted())
                .collect(Collectors.toList());
    }

    public void displayPets(List<pet> pets) {
        if (pets.isEmpty()) {
            System.out.println("No pets available.");
        } else {
            pets.forEach(System.out::println);
        }
    }

    public static void main(String[] args) {
        PetAdoptionPortal portal = new PetAdoptionPortal();

        portal.addPet(new pet("Cat", 2, true));
        portal.addPet(new pet("Dog", 5, false));
        portal.addPet(new pet("Bird", 1, false));
        portal.addPet(new pet("Reptile", 4, true));
        portal.addPet(new pet("Dog", 3, false));

    
        System.out.println("Available Dogs:");
        portal.displayPets(portal.filterAvailablePetsByType("Dog"));

        System.out.println("\nAvailable Cats:");
        portal.displayPets(portal.filterAvailablePetsByType("Cat"));

        System.out.println("\nAvailable Pets of Age 3:");
        portal.displayPets(portal.filterAvailablePetsByAge(3));

        System.out.println("\nAvailable Dogs of Age 3:");
        portal.displayPets(portal.filterAvailablePetsByTypeAndAge("Dog", 3));
    }
}
