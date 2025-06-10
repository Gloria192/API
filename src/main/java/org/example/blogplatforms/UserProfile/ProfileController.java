package org.example.blogplatforms.UserProfile;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profile")
public class ProfileController {

    private final ProfileService profileService;

    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }
    @GetMapping("/profiles")
    @Operation(summary = "Get all profiles")
    public List<Profile> getAllProfiles() {
        return profileService.getAllProfiles();
    }

    @PostMapping
    @Operation
            (summary = "Create profile")
    public Profile createProfile(@RequestBody ProfileCreationDto profileCreationDto) {
     var profile=new Profile();
     profile.setBio(profileCreationDto.getBio());
     profile.setFullname(profileCreationDto.getFullname());
     profile.setId(profileCreationDto.getUser_id());
     profile.setDob(profile.getDob());
     return profileService.createProfile(profile);
    }
    @PutMapping("/{id}")
    @Operation
            (summary = "Update profile")
    public Profile updateProfile(@PathVariable long id, @RequestBody ProfileCreationDto profileCreationDto)
    {
        var profile=new Profile();
        profile.setId(id);
        profile.setId(profileCreationDto.getUser_id());
        profile.setBio(profileCreationDto.getBio());
        profile.setFullname(profileCreationDto.getFullname());
        profile.setDob(profile.getDob());
        return profileService.updateProfile(profile);
    }
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a profile by ID")
    public void deleteProfile(@PathVariable long id) {
        profileService.deleteUserById(id);
    }
    @GetMapping("/profile/{id}")
    @Operation(summary = "Get profile by ID")
    public Profile getProfileById(@PathVariable long id) {
        return profileService.getProfileRepository().stream().filter(profile -> profile.getId() == id).findFirst().orElseThrow(() -> new IllegalArgumentException("Profile not found"));
    }


}
