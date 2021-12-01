package com.example.tpclub.Service;
import com.example.tpclub.Entity.Club;
import com.example.tpclub.Entity.Student;
import com.example.tpclub.Repository.IClubRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ClubService implements IClubService {
    @Autowired
    IClubRepository clubrepo;
    private Student Student;

    @Override
    public List<Club> retrieveAllClubs() {
        List<Club> clubs = new ArrayList<>();
        clubrepo.findAll().forEach(clubs::add);
        return clubs;
    }
    @Override
    public int ajouterClub(Club c) {
        clubrepo.save(c);
        return c.getId();
    }
    @Override
    public void deleteClub(Integer id) {
        Club club = clubrepo.findById(id).orElse(null);
        clubrepo.delete(club);
    }
    @Override
    public Club updateClub(Club c, int clubId) {
        Club club = clubrepo.findById(clubId).orElse(null);
        clubrepo.save(c);
        return club;
    }
    @Override
    public Club retrieveClub(Integer id) {
        Club club = clubrepo.findById(id).orElse(null);
        return club;
    }

    @Override
    public long nbrClub() {
        return clubrepo.count();
    }

    @Override
    public  Iterable<Object[]> superClub() {
        return  clubrepo.studentsPerClub();
    }

    @Override
    public long nbrStudents() {
        return clubrepo.nbrStudents();
    }
}
