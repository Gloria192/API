package org.example.blogplatforms.Comments;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CommentService {
    private static CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public Comment getById(Long postId) {
        return commentRepository.findById(postId).orElse(null);
    }

    public Comment getCommentById(Long id) {
        return commentRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Comment not found"));
    }

    public Comment createComment(Comment comment) {
        return commentRepository.save(comment);
    }

    public static Comment updateComment(Long id, Comment comment) {
        Comment existingComment = commentRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Comment not found"));

        existingComment.setCommenter_name(comment.getCommenter_name());
        existingComment.setContent(comment.getContent());
        existingComment.setPost_id(comment.getPost_id());

        return commentRepository.save(existingComment);
    }
}
