package com.usa.retos.service;

import com.usa.retos.model.Boat;
import com.usa.retos.repository.BoatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BoatService {
    @Autowired
    private BoatRepository boatRepository;

    public List<Boat> getAll() {
        return boatRepository.getAll();
    }

    public Optional<Boat> getMachine(int id) {
        return boatRepository.getMachine(id);
    }

    public Boat save(Boat boat){
        if(boat.getId()==null){
            return boatRepository.save(boat);
        }else{
            Optional<Boat> e= boatRepository.getMachine(boat.getId());
            if(e.isEmpty()){
                return boatRepository.save(boat);
            }else{
                return boat;
            }
        }
    }

    public Boat update(Boat boat){
        if(boat.getId()!=null){
            Optional<Boat> tmpMachine = boatRepository.getMachine(boat.getId());
            if(!tmpMachine.isEmpty()){
                if(boat.getName()!=null){
                    tmpMachine.get().setName(boat.getName());
                }
                if(boat.getBrand()!=null){
                    tmpMachine.get().setBrand(boat.getBrand()); ;
                }
                if(boat.getYear() !=null){
                    tmpMachine.get().setYear(boat.getYear());
                }
                if(boat.getDescription()!=null){
                    tmpMachine.get().setDescription(boat.getDescription());
                }
                if(boat.getCategory()!=null){
                    tmpMachine.get().setCategory(boat.getCategory());
                }
                boatRepository.save(tmpMachine.get());
                return tmpMachine.get();
            }else{
                return boat;
            }
        }else{
            return boat;
        }
    }

    public boolean deleteMachine(int id) {
        Boolean aBoolean = getMachine(id).map(machine -> {
            boatRepository.delete(machine);
            return true;
        }).orElse(false);
        return aBoolean;
    }

}
