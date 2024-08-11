package com.app.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entities.Turf;
import com.app.repository.TurfRepository;
@Service
@Transactional
public class TurfServiceImpl implements TurfService {

	@Autowired
    private TurfRepository turfRepository;

	@Override
	public List<Turf> getAllTurfs() {
		
		return turfRepository.findAll();
	}

	@Override
	public Optional<Turf> getTurfById(Long id) {
		
		return turfRepository.findById(id);
	}

	@Override
	public Turf createTurf(Turf turf) {
		
		return turfRepository.save(turf);
	}

	@Override
	public Turf updateTurf(Long id, Turf turf) {
		Optional<Turf> existingTurf = turfRepository.findById(id);
        if (existingTurf.isPresent()) {
            turf.setTurfId(id);
            return turfRepository.save(turf);
        }
        return null;
		
	}

	@Override
	public void deleteTurf(Long id) {
		turfRepository.deleteById(id);

	}

}
