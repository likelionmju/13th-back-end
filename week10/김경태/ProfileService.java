package com.example.ll_week10;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProfileService {
    private final ProfileRepository profileRepository;

    public Profile save(Profile profile) {
        return profileRepository.save(profile);
    }

    public Profile findById(Long id) {
        return profileRepository.findById(id).orElse(new Profile());
    }

    public Profile findByName(String name) {
        return profileRepository.findByName(name).orElse(new Profile());
    }

    public List<Profile> findAll() {
        return profileRepository.findAll();
    }

    public List<Profile> findTop3ByOrderByScoreDesc() {
        return profileRepository.findTop3ByOrderByScoreDesc();
    }

    public Profile update(Profile request) {
        Optional<Profile> target = profileRepository.findById(request.getId());
        if(target.isPresent()) {
            Profile profile =  target.get();
            profile.setScore(request.getScore());
            profileRepository.save(profile);
            return profile;
        } else throw new RuntimeException(request.getId() + "가 존재하지 않습니다.");
    }

    public void delete(Long id) {
        if(profileRepository.existsById(id)) {
            profileRepository.deleteById(id);
        } else throw new RuntimeException(id + "가 존재하지 않습니다");
    }
}
