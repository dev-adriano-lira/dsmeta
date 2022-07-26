package com.devsuperior.dsmeta.services;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.repositories.SaleRepository;

@Service
public class SaleService {
	
	@Autowired
	private SaleRepository repository;
	
	public Page<Sale> findSales(String minDate, String maxDate, Pageable pageable) {
		LocalDate max;
		LocalDate min;
		LocalDate today = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());
				
		if (minDate.equals("")) min = today.minusDays(365); 
		else min = LocalDate.parse(minDate);
		
		if (maxDate.equals("")) max = today;
		else max = LocalDate.parse(maxDate);
		
		return repository.findSales(min, max, pageable);
	}
}
