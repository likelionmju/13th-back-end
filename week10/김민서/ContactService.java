package com.example.demo.service;

import com.example.demo.member.Contact;
import com.example.demo.repository.ContactRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ContactService {
    private final ContactRepository contactRepository;

    public Contact save(Contact contact) {
        return contactRepository.save(contact);
    }

    public List<Contact> findAll() {
        return contactRepository.findAll();
    }

    public Contact findById(Long id) {
//        Optional<Contact> optional = contactRepository.findById(id);
//        if(optional.isPresent()) {
//            return optional.get();
//        } else throw new RuntimeException(id+"가 존재하지 않습니다.");

        return contactRepository.findById(id).orElse(new Contact());
    }

    public Contact findByName(String name) {
        return contactRepository.findByName(name).orElse(new Contact());
    }

    public Contact update(Contact request) {
        Optional<Contact> Optional = contactRepository.findById(request.getId());
        if (Optional.isPresent()) {
            Contact contact = Optional.get();
            contact.setStudentNumber(request.getStudentNumber());
            contactRepository.save(contact);
            return contact;
        } else  throw new RuntimeException(request.getId() + "가 존재하지 않습니다.");

    }

    public void delete(Long id) {
        contactRepository.deleteById(id);
    }
}
