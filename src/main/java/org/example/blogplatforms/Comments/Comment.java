package org.example.blogplatforms.Comments;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Data
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String Commenter_name;
    private String Content;
    private Long post_id;
    @CreationTimestamp
    private String created_at;
    @UpdateTimestamp
    private String updated_at;


}
