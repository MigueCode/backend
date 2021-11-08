package com.usa.retos.crud;

import com.usa.retos.model.Boat;
import org.springframework.data.repository.CrudRepository;

public interface BoatCrud extends CrudRepository<Boat, Integer> {
}
