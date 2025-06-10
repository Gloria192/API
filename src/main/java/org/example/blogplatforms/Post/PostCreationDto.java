package org.example.blogplatforms.Post;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PostCreationDto {
    private String title;
    private String content;
    private Long user_id;

}
