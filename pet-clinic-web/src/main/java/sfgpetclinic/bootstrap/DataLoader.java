package sfgpetclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import sfgpetclinic.map.OwnerMapService;
import sfgpetclinic.map.VetMapService;
import sfgpetclinic.model.Owner;
import sfgpetclinic.model.Vet;
import sfgpetclinic.services.OwnerService;
import sfgpetclinic.services.VetService;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Devon");
        owner1.setLastName("Morrison");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner1.setId(2L);
        owner1.setFirstName("Sam");
        owner1.setLastName("Naples");

        ownerService.save(owner2);

        System.out.println("Loaded Owners!");


        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Ryan");
        vet1.setLastName("Sundberg");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet1.setId(2L);
        vet1.setFirstName("Vernon");
        vet1.setLastName("Lalone");

        vetService.save(vet2);

        System.out.println("Loaded Vets!");
    }
}
