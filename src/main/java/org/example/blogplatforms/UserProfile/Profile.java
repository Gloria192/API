package org.example.blogplatforms.UserProfile;

import jakarta.persistence.*;
import lombok.Data;
import org.example.blogplatforms.userss.Users;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@Data
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String bio;
    private Date dob;
    private String fullname;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", updatable = false)
    private Date createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Date updatedAt;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false, unique = true) // FK to users_blog.user_id
    private Users users;
}
