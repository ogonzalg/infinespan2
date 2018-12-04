package org.infinispan.tutorial.simple.spring.remote;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/basquename")
public class BasqueNameController {
	private final BasqueNameService service;
	
	public BasqueNameController(BasqueNameService service) {
		this.service = service;
	}

    @RequestMapping(value = "/{id}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<BasqueName> get (@PathVariable("id") Integer id) {
        return new ResponseEntity<BasqueName>(service.findById(id), HttpStatus.OK);
    }
}
