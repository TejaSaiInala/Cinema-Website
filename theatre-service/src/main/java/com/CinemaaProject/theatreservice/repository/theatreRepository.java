package com.CinemaaProject.theatreservice.repository;

import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.CinemaaProject.theatreservice.model.Screen;
import com.CinemaaProject.theatreservice.model.Theatre;

@ComponentScan
@Repository
public interface theatreRepository extends JpaRepository<Theatre, Long>{
	
	
}
