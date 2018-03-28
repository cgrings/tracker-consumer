package io.cgrings.consumer.service;

import io.cgrings.consumer.model.Contact;
import io.cgrings.tracker.model.ContactInput;

public interface ContactService {

    Contact convertAndSave(final ContactInput contactInput);

    Contact save(final Contact contact);
}
