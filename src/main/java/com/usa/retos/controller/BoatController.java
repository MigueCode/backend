package com.usa.retos.controller;

import com.usa.retos.model.Boat;
import com.usa.retos.service.BoatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Boat")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class BoatController {
    @Autowired
    private BoatService boatService;

    @GetMapping("/all")
    public List<Boat> getMachine(){

        return boatService.getAll();
    }

    @GetMapping("/{idMachine}")
    public Optional<Boat> getMachine (@PathVariable("id") int id) {

        return boatService.getMachine(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Boat save(@RequestBody Boat boat) {

        return boatService.save(boat);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)

    public Boat update(@RequestBody Boat boat) {

        return boatService.update(boat);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id) {
        return boatService.deleteMachine(id);
    }

}
