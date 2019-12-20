package learn.avinash.spring.msscbrewy.web.controller;

import learn.avinash.spring.msscbrewy.services.BeerService;
import learn.avinash.spring.msscbrewy.web.model.BeerDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;
@Deprecated
@RequestMapping("/api/v1/beer")
@RestController
public class BeerController {

    private final BeerService beerService;

    public BeerController(BeerService beerService) {
        this.beerService = beerService;
    }

    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDto> getBeer(@PathVariable UUID beerId){

        return new ResponseEntity<>(beerService.getBeerById(beerId), HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity handlePost(@Valid BeerDto beerDTO){
        BeerDto saveDto = beerService.saveNewBeer(beerDTO);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location","http://localhost:8080/api/v1/beer/"+ saveDto.getId().toString());
        return  new ResponseEntity(headers, HttpStatus.CREATED);

    }

    @PutMapping("/{beerId}")
    public ResponseEntity handleUpdate(@PathVariable UUID beerId,@Valid BeerDto beerDTO){
         beerService.updateBeer(beerId,beerDTO);

        return  new ResponseEntity( HttpStatus.NO_CONTENT);

    }


    @DeleteMapping("/{beerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBeer(@PathVariable UUID beerId){

        beerService.deleteById(beerId);
    }
}
