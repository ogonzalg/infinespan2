package org.infinispan.tutorial.simple.spring.remote;

import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@Service
public class BasqueNameService {
	private final BasqueNamesRepository repository;

	public BasqueNameService(BasqueNamesRepository repository) {
		this.repository = repository;
	}

	@HystrixCommand(fallbackMethod = "findByIdFallback", commandProperties = {
			@HystrixProperty(name = "fallback.isolation.semaphore.maxConcurrentRequests", value = "1000") })
	public BasqueName findById(int id) {
		return repository.findById(id);
	}
	
	@SuppressWarnings("unused")
	private BasqueName findByIdFallback(int id) {
		return repository.findByIdWithoutCache(id);
	}

}
