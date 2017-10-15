package com.raj;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;

public interface StudentRepository  extends CrudRepository<StudentDetails, Serializable>{

}
