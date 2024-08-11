package com.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import com.app.dto.TurfDTO;
import com.app.service.TurfService;



@RestController
@RequestMapping("/turfs")
public class TurfController {
	
	@Autowired
    private TurfService turfService;

    @GetMapping
    public ResponseEntity<?> getAllTurfs() {
        return ResponseEntity.ok(turfService.getAllTurfs());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTurfById(@PathVariable Long id) {
    	return ResponseEntity.ok(turfService.getTurfById(id));
    }

    @PostMapping
    public ResponseEntity<?> createTurf(@Valid @RequestBody TurfDTO turf) {
    	System.out.println(turf.getName());
        return ResponseEntity.status(HttpStatus.CREATED).body(turfService.createTurf(turf));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTurf(@PathVariable Long id) {
    	return ResponseEntity.ok(turfService.deleteTurf(id));
    }

}
