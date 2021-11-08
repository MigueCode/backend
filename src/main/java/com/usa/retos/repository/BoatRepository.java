package com.usa.retos.repository;

import com.usa.retos.crud.BoatCrud;
import com.usa.retos.model.Boat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class BoatRepository {
    @Autowired
    private BoatCrud boatCrud;

    public List<Boat> getAll() {
        return (List<Boat>) boatCrud.findAll();
    }

    public Optional<Boat> getMachine(int id) {
        return boatCrud.findById(id);
    }

    public Boat save (Boat boat) {
        return boatCrud.save(boat);
    }

    public void delete (Boat boat) {
        boatCrud.delete(boat);
    }
}
