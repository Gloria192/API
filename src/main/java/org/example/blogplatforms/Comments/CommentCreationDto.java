package org.example.blogplatforms.Comments;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CommentCreationDto {
    private String Commenter_name;
    private String Content;
    private Long post_id;
}
