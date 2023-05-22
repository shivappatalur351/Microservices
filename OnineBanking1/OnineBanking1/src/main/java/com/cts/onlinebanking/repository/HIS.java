package com.cts.onlinebanking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.onlinebanking.model.Withdraw;

public interface HIS extends JpaRepository<Withdraw, Integer> {

	List<Withdraw> findByUserName(String name);

}