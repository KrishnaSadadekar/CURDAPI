package com.example.StudentCrud.Repository;

import com.example.StudentCrud.Models.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address,Integer> {

}
