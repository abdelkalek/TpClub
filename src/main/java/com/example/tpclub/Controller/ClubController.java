package com.example.tpclub.Controller;
import com.example.tpclub.Entity.Club;
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
        return  clubService.ajouterClub(c);
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
    private long nbrclub(){
        return clubService.nbrClub();
    }

    @GetMapping("/maxStuperClub")
    @ResponseBody
    private  Iterable<Object[]> superclub(){
        return clubService.superClub();
    }
    @GetMapping("/nbrStudent")
    private long nbrStudent(){
        return clubService.nbrStudents();   }
}

