package com.springrest.prodectapi.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.springrest.prodectapi.service.prodectservice;
import com.springrest.prodectapi.beans.prodectwrapper;
import com.springrest.prodectapi.exception.recordnotfoundException;


@Controller
public class prodectcontroller  {
	@Autowired
	private prodectservice prodectService;
	@PostMapping("/saveProdect")
	public ResponseEntity<prodectwrapper> saveProdect(@RequestBody prodectwrapper prodectWrapper){
		prodectWrapper = prodectService.saveProdect(prodectWrapper);
		return ResponseEntity.ok(prodectWrapper);
		
	}
	@GetMapping("/getProdect/{id}")
	public ResponseEntity<prodectwrapper> getProdectById(@PathVariable Long id) throws recordnotfoundException
	{
		prodectwrapper prodectWrapper= prodectService.getProdectById(id);
		return ResponseEntity.ok(prodectWrapper);
	}
@PutMapping("/updateProdect")

	public ResponseEntity<prodectwrapper> updateProdect(@RequestBody prodectwrapper prodectWrapper)throws recordnotfoundException
{
		prodectWrapper = prodectService.updateProdectDetails(prodectWrapper);
		
		
		return ResponseEntity.ok(prodectWrapper);

}
	@DeleteMapping("/deleteProdect/{id}")
	public ResponseEntity<prodectwrapper> deleteProdectById(@PathVariable Long id) throws recordnotfoundException
	{
		 prodectService.deleteById(id);
		 return ResponseEntity.noContent().build();
	
	}
}