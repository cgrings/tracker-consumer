package io.cgrings.consumer.repository;

import org.springframework.data.repository.CrudRepository;

import io.cgrings.consumer.model.Contact;

public interface ContactRepository extends CrudRepository<Contact, String> {

}
