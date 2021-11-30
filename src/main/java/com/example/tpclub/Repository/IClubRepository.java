package com.example.tpclub.Repository;

import com.example.tpclub.Entity.Club;
import org.springframework.data.repository.CrudRepository;

public interface IClubRepository extends CrudRepository<Club,Integer> {
}
