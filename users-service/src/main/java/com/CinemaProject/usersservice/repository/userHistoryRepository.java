package com.CinemaProject.usersservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CinemaProject.usersservice.model.usersHistory;

@Repository
public interface userHistoryRepository extends JpaRepository<usersHistory,Long>{

	List<usersHistory> findByUserId(Long id);
}
