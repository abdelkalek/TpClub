package com.example.tpclub.Controller;

import com.example.tpclub.Entity.Club;
import com.example.tpclub.Entity.Student;
import com.example.tpclub.Service.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/club")
public class ClubController {
    @Autowired
    private ClubService clubService;

    @PostMapping("add")
    @ResponseBody
    public int addClub(@RequestBody Club c) {
        return clubService.ajouterClub(c);
    }

    @DeleteMapping("/remove/{Club-id}")
    @ResponseBody
    public void removeClub(@PathVariable("Club-id") Integer clubId) {
        clubService.deleteClub(clubId);
    }

    @PutMapping("/modify-Club")
    @ResponseBody
    public Club modifyOrders(@RequestBody Club club) {
        return clubService.updateClub(club, club.getId());
    }

    @GetMapping("/retrieve-all")
    @ResponseBody
    public List<Club> getStudent() {
        return clubService.retrieveAllClubs();
    }

    @GetMapping("/retrieve/{Club-id}")
    @ResponseBody
    public Club retrieveStudent(@PathVariable("Club-id") Integer id) {

        return clubService.retrieveClub(id);
    }

    @GetMapping("/nbrclub")
    private long nbrclub() {
        return clubService.nbrClub();
    }

    @GetMapping("/nbrStudentInClub")
    @ResponseBody
    private Iterable<String> superclub() {
        return clubService.superClub();
    }

    @GetMapping("/bestClub")
    private Iterable<Club> bestClub() {
        return clubService.bestClub();
    }

    @GetMapping("/worstClub")
    private Iterable<Club> worstClub() {
        return clubService.worstClub();
    }

    @GetMapping("/bestStudentInClub")
    private Iterable<Student> bestStudent() {
        return clubService.bestStudent();
    }

    @GetMapping("/findstudent")
    @ResponseBody
    private  Iterable<Club> findstudent(@RequestBody Student s) {
        return clubService.findStudent(s);
    }

}

