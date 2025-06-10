package org.example.blogplatforms.UserProfile;

import org.springframework.stereotype.Service;
import java.util.List;

import static org.antlr.v4.runtime.tree.xpath.XPath.findAll;

@Service
public class ProfileService {

    private final ProfileRepository profileRepository;

    public ProfileService(ProfileRepository profileRepository){
        this.profileRepository = profileRepository;
    }

    public List<Profile> getProfileRepository() {
        return profileRepository.findAll() ;
    }

    public Profile createProfile(Profile profile) {
        return profileRepository.save(profile);
    }

    public void deleteUserById(long id) {

        profileRepository.deleteById(id);
    }

    public List<Profile> getAllProfiles() {
        return profileRepository.findAll();
    }

    public Profile updateProfile(Profile profile) {
        Profile profile1 = profileRepository.findById(profile.getId()).orElseThrow(() -> new IllegalArgumentException("Profile not found"));

        profile1.setBio(profile.getBio());
        profile1.setFullname(profile.getFullname());
        profile1.setDob(profile.getDob());

        return profileRepository.save(profile1);
    }
}
