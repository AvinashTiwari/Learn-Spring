package learn.avinash.spring.springit.controller;

import learn.avinash.spring.springit.domain.Link;
import learn.avinash.spring.springit.repository.LinkRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/links")
public class LinkController {

    private LinkRepository linkedRepository;

    public LinkController(LinkRepository linkedRepository) {
        this.linkedRepository = linkedRepository;
    }

    @GetMapping("/")
    public List<Link> list(){
        return linkedRepository.findAll();
    }

    @PostMapping("/create")
    public Link create(@ModelAttribute Link link){
        return linkedRepository.save(link);
    }

    @GetMapping("/{id}")
    public Optional<Link> read(@PathVariable Long id){
        return linkedRepository.findById(id);
    }

    @PutMapping("/{id}")
    public  Link update(@PathVariable Long id, @ModelAttribute Link link){
        return linkedRepository.save(link);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
         linkedRepository.deleteById(id);
    }
}
