package com.zelenev.controllers.implementations;

import com.zelenev.controllers.ICrudController;
import com.zelenev.data.dto.CrossroadDto;
import com.zelenev.services.implementations.CrossroadService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(
        path = "/crossroad"
)
@CrossOrigin("*")
public class CrossroadController implements ICrudController<CrossroadDto> {

    @Qualifier("crossroadService")
    private final CrossroadService crossroadService;

    public CrossroadController(CrossroadService crossroadService) {
        this.crossroadService = crossroadService;
    }

    @Override
    @GetMapping(
            path = "/{id}"
    )
    public CrossroadDto read(@PathVariable Integer id) {
        return crossroadService.read(id);
    }

    @Override
    @GetMapping(
            path = "/all"
    )
    public List<CrossroadDto> readAll() {
        return crossroadService.readAll();
    }

    @Override
    @PostMapping
    public void create(@RequestBody CrossroadDto crossroadDto) {
        crossroadService.create(crossroadDto);
    }

    @Override
    @PutMapping
    public void update(@RequestBody CrossroadDto crossroadDto, @RequestBody CrossroadDto newT) {
        crossroadService.update(crossroadDto, newT);
    }

    @Override
    @DeleteMapping
    public void delete(@RequestBody CrossroadDto crossroadDto) {
        crossroadService.delete(crossroadDto);
    }
}
