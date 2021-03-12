package com.fabiotetsuo.hrworker.resources;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fabiotetsuo.hrworker.entities.Worker;
import com.fabiotetsuo.hrworker.repositories.WorkerRepository;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping(value = "/workers")
public class WorkerResource {
	private static Logger logger = LoggerFactory.getLogger(WorkerResource.class);
	@Autowired
	private Environment env;
	@Autowired
	private WorkerRepository workerRepository;
	
	@GetMapping
	public ResponseEntity<List<Worker>> findAll() {
		List<Worker> results = workerRepository.findAll();
		return ResponseEntity.ok().body(results);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Worker> findById (@PathVariable Long id) {
		logger.info("PORT = " + env.getProperty("local.server.port"));
		Worker selectedWorker = workerRepository.findById(id).get();
		return ResponseEntity.ok().body(selectedWorker);
	}
}
