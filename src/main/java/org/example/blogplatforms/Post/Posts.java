package org.example.blogplatforms.Post;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "User_posts")
@Data
public class Posts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String title;
  private String content;

  private Long user_id;
  @CreationTimestamp
  private String created_at;
  @UpdateTimestamp
  private String updated_at;


}
