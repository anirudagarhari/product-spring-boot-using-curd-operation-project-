package com.springrest.prodectapi.erpository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.springrest.prodectapi.model.prodect;
@Repository
public interface prodectrepository extends CrudRepository<prodect, Long> {	

}
