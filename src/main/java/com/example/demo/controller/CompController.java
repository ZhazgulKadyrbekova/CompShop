package com.example.demo.controller;

import com.example.demo.dto.CompDTO;
import com.example.demo.entity.CompEntity;
import com.example.demo.repository.CompRepository;
import com.example.demo.service.CompService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/comp")
public class CompController {

    @Autowired
    private CompService compService;

    @PostMapping
    public CompEntity create(@RequestBody CompDTO comp) {
        return compService.create(comp);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        return compService.delete(id);
    }

    /*
    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<CompEntity> update(@PathVariable("id") int id,
                                               @RequestBody CompEntity comp) {

        return compRepository.findById(id)
                .map(record -> {
                    record.setName(comp.getName());
                    record.setHdd(comp.getHdd());
                    record.setRam(comp.getRam());
                    record.setCpu(comp.getCpu());
                    CompEntity put = compRepository.save(comp);
                    return ResponseEntity.ok().body(put);
                }).orElse(ResponseEntity.notFound().build());
    }
*/

    @GetMapping("/all")
    public List<CompEntity> getAll() {
        return compService.getAll();
    }

    @GetMapping("/{id}")
    public CompEntity getComp(@PathVariable Long id) {
        return compService.getComp(id);
    }
}