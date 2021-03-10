package com.fabiotetsuo.hrworker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fabiotetsuo.hrworker.entities.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Long > {

}
