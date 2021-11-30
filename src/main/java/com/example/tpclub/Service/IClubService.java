package com.example.tpclub.Service;


import com.example.tpclub.Entity.Club;
import com.example.tpclub.Entity.Student;

import java.util.List;

public interface IClubService {
    public List<Club> retrieveAllClubs();
    public int ajouterClub(Club c);
    public void deleteClub(Integer id);
    public Club updateClub(Club c, int clubId);
    public Club retrieveClub(Integer id);
}
