package com.CinemaProject.usersservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CinemaProject.usersservice.model.users;

@Repository
public interface usersRepository extends JpaRepository<users,Long>{

}
