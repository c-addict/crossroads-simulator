package com.zelenev.controllers.implementations;

import com.zelenev.controllers.ICrudController;
import com.zelenev.data.dto.RoadDto;
import com.zelenev.services.ICrudService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(
        path = "/road"
)
@CrossOrigin("*")
public class RoadController implements ICrudController<RoadDto> {

    @Qualifier("roadService")
    private final ICrudService<RoadDto> roadService;

    public RoadController(ICrudService<RoadDto> roadService) {
        this.roadService = roadService;
    }

    @Override
    @GetMapping(
            path = "/{id}"
    )
    public RoadDto read(@PathVariable Integer id) {
        return roadService.read(id);
    }

    @Override
    @GetMapping(
            path = "/all"
    )
    public List<RoadDto> readAll() {
        return roadService.readAll();
    }

    @Override
    @PostMapping
    public void create(@RequestBody RoadDto roadDto) {
        roadService.create(roadDto);
    }

    @Override
    @PutMapping
    public void update(@RequestBody RoadDto roadDto, @RequestBody RoadDto newT) {
        roadService.update(roadDto, newT);
    }

    @Override
    @DeleteMapping
    public void delete(@RequestBody RoadDto roadDto) {
        roadService.delete(roadDto);
    }
}
