package sfgpetclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import sfgpetclinic.model.Owner;
import sfgpetclinic.model.Pet;
import sfgpetclinic.model.PetType;
import sfgpetclinic.model.Vet;
import sfgpetclinic.services.OwnerService;
import sfgpetclinic.services.PetTypeService;
import sfgpetclinic.services.VetService;

import java.time.LocalDate;


@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Devon");
        owner1.setLastName("Morrison");
        owner1.setAddress("123 Louis St");
        owner1.setCity("Lansing");
        owner1.setTelephone("2111111111");

        Pet devonsPet = new Pet();
        devonsPet.setPetType(savedDogPetType);
        devonsPet.setOwner(owner1);
        devonsPet.setBirthDate(LocalDate.now());
        devonsPet.setName("Rosco");
        owner1.getPets().add(devonsPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Sam");
        owner2.setLastName("Naples");
        owner2.setAddress("Where?");
        owner2.setCity("Ypsilanti");
        owner2.setTelephone("3333333333");

        Pet samsCat = new Pet();
        samsCat.setName("Sprinkles");
        samsCat.setOwner(owner2);
        samsCat.setBirthDate(LocalDate.now());
        samsCat.setPetType(savedCatPetType);
        owner2.getPets().add(samsCat);

        ownerService.save(owner2);

        System.out.println("Loaded Owners!");

        Vet vet1 = new Vet();
        vet1.setFirstName("Ryan");
        vet1.setLastName("Sundberg");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Vernon");
        vet2.setLastName("Lalone");

        vetService.save(vet2);

        System.out.println("Loaded Vets!");
    }
}
