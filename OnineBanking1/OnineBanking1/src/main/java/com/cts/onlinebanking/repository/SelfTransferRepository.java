package com.cts.onlinebanking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cts.onlinebanking.model.SelfTransfer;

public interface SelfTransferRepository extends JpaRepository<SelfTransfer, Integer> {

}
