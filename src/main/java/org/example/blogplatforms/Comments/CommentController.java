package org.example.blogplatforms.Comments;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comment")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @GetMapping("/post/{postId}/comment/{id}")
    @Operation(summary = "Get a comment by ID")
    public Comment getCommentById(@PathVariable Long postId, @PathVariable Long id) {
     return commentService.getCommentById(postId);
    }

    @PostMapping("/post/{postId}/comment")
    @Operation(summary="Create a new comment")
    public Comment createComment(@PathVariable Long postId, @RequestBody CommentCreationDto dto) {
        Comment comment = new Comment();
        comment.setCommenter_name(dto.getCommenter_name());
        comment.setContent(dto.getContent());
        comment.setPost_id(postId);

        return commentService.createComment(comment);
    }

}
