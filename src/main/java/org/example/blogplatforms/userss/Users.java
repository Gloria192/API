package org.example.blogplatforms.userss;

import jakarta.persistence.*;
import lombok.Data;
import org.example.blogplatforms.UserProfile.Profile;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@Table(name = "users_blog")
@Data
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private long id;

    private String Username;

    @Column(unique = true, nullable = false)
    private String email;

    @CreationTimestamp
    private Date createdAt;

    @UpdateTimestamp
    private Date updatedAt;

//    @OneToOne(mappedBy = "users") // Non-owning side of relationship
//    private Profile profile;
@OneToOne(cascade = CascadeType.ALL)
private Profile profile;

}

