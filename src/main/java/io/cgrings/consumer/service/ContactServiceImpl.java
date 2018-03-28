package io.cgrings.consumer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.cgrings.consumer.model.Contact;
import io.cgrings.consumer.repository.ContactRepository;
import io.cgrings.tracker.model.ContactInput;

@Service
public class ContactServiceImpl implements ContactService {

	private Logger logger = LoggerFactory.getLogger(ContactService.class);

	@Autowired
	private ContactRepository contactRepository;

    @Override
    @Transactional
    public Contact save(final Contact contact) {
        final Contact result = this.contactRepository.save(contact);
        logger.info("Contact with id '{}' saved!", result.getId());
        return result;
    }

    @Override
    public Contact convertAndSave(final ContactInput contactInput) {
        final Contact contact = new Contact();
        contact.setName(contactInput.getName());
        contact.setEmail(contactInput.getEmail());
        contact.setTracker(contactInput.getTracker());
        return this.save(contact);
    }

}
