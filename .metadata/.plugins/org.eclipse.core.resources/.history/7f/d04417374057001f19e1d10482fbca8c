package com.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entities.Turf;
import com.app.service.TurfService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/turfs")
public class TurfController {
	
	@Autowired
    private TurfService turfService;

    @GetMapping
    public List<Turf> getAllTurfs() {
        return turfService.getAllTurfs();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Turf> getTurfById(@PathVariable Long id) {
        Optional<Turf> turf = turfService.getTurfById(id);
        return turf.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Turf createTurf(@RequestBody Turf turf) {
        return turfService.createTurf(turf);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Turf> updateTurf(@PathVariable Long id, @RequestBody Turf turf) {
        Turf updatedTurf = turfService.updateTurf(id, turf);
        return updatedTurf != null ? ResponseEntity.ok(updatedTurf) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTurf(@PathVariable Long id) {
        turfService.deleteTurf(id);
        return ResponseEntity.noContent().build();
    }

}
