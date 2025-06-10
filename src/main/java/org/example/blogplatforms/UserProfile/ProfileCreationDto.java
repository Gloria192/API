package org.example.blogplatforms.UserProfile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProfileCreationDto {

    private String bio;
    private String fullname;
    private String dob;
     private long user_id;

}
