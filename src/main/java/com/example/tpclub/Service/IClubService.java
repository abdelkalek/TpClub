package com.example.tpclub.Service;
import com.example.tpclub.Entity.Club;
import java.util.List;

public interface IClubService {
    List<Club> retrieveAllClubs();
    int ajouterClub(Club c);
    void deleteClub(Integer id);
    Club updateClub(Club c, int clubId);
    Club retrieveClub(Integer id);
    long nbrClub();
    Iterable<Object[]> superClub();
    long nbrStudents();
}
