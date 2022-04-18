package com.springrest.prodectapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.prodectapi.beans.prodectwrapper;
import com.springrest.prodectapi.erpository.prodectrepository;
import com.springrest.prodectapi.model.prodect;
import com.springrest.prodectapi.exception.recordnotfoundException;



import net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Optional;

@Service

public class prodectservice {
	@Autowired
	private prodectrepository repository;
	
	public prodectwrapper saveProdect(prodectwrapper inputprodect) {
		prodect prodect=new prodect();
		//student.setId(inputprodect.getId());
		prodect.setName(inputprodect.getName());
		
	prodect= repository.save(prodect);
		inputprodect.setId(prodect.getId());
		inputprodect.setName(prodect.getName());
		return inputprodect;
		}

	
	public prodectwrapper getProdectById(Long id) throws recordnotfoundException {
		prodectwrapper prodectWrapperOutput= null;
		java.util.Optional<prodect> prodectOptionalData = repository.findById(id);
		
		if(prodectOptionalData.isPresent()) {
			
			prodectWrapperOutput=new prodectwrapper();
			prodect Prodect=prodectOptionalData.get();
			 prodectWrapperOutput.setId(Prodect.getId());
			 prodectWrapperOutput.setName(Prodect.getName());
			 
			
		}
		else
		{
		throw new recordnotfoundException("prodect record not found ");
		}
		return prodectWrapperOutput;
	}
	
	
	public prodectwrapper updateProdectDetails(prodectwrapper inputstudent) throws recordnotfoundException {
		
		java.util.Optional<prodect> prodectOptionalData = repository.findById(inputstudent.getId());
		
		if(prodectOptionalData.isPresent()) {
			
			prodect Prodect=prodectOptionalData.get();
			
			Prodect.setName(inputstudent.getName());
			repository.save(Prodect);
			prodectwrapper prodectwrapper=new prodectwrapper();
			 prodectwrapper.setId(Prodect.getId());
			 prodectwrapper.setName(Prodect.getName());
			 
			 return prodectwrapper;
		}
		else
		{
		throw new recordnotfoundException("prodect record not found ");
		}
		
	}
	public void deleteById(Long id) throws recordnotfoundException{
		java.util.Optional<prodect> prodectOptionalData = repository.findById(id);
		if(prodectOptionalData.isPresent()) {
			prodect Prodect=prodectOptionalData.get();
			repository.delete(Prodect);
		}else
		{
			throw new  recordnotfoundException("prodect record not found ");
		}
		
		
		
	}


	
	
		
		
}		
		


