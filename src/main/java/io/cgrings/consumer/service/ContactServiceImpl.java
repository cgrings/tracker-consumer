package io.cgrings.consumer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
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

    @Autowired
    private PageViewService pageViewService;

    @Override
    @Transactional
    public Contact save(final Contact contact) {
        final Contact result = this.contactRepository.save(contact);
        logger.info("Contact with id '{}' saved!", result.getId());
        return result;
    }

    @Override
    public Contact convertAndSave(final ContactInput contactInput) {
        Contact contact = new Contact();
        contact.setName(contactInput.getName());
        contact.setEmail(contactInput.getEmail());
        try {
        contact = this.save(contact);
        } catch (DuplicateKeyException e) {
            logger.warn("Duplicated contact discarted: '{}'", contactInput.getEmail());
        }
        pageViewService.updateUserBySession(contactInput.getUid(), contactInput.getSid());
        return contact;
    }

}
