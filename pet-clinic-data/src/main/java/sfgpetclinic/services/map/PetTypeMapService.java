package sfgpetclinic.services.map;

import org.springframework.stereotype.Service;
import sfgpetclinic.model.PetType;
import sfgpetclinic.services.PetTypeService;
import sfgpetclinic.services.VetService;
import sfgpetclinic.services.map.AbstractMapService;

import java.util.Set;

@Service
public class PetTypeMapService extends AbstractMapService<PetType, Long> implements PetTypeService {

    @Override
    public Set<PetType> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(PetType object) {
        super.delete(object);
    }

    @Override
    public PetType save(PetType object) {
        return super.save(object);
    }

    @Override
    public PetType findById(Long id) {
        return super.findById(id);
    }

}
