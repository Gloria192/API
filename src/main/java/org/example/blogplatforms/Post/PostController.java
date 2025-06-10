package org.example.blogplatforms.Post;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/posts")
@RequiredArgsConstructor

public class PostController {
    private final PostService postService;

    @GetMapping
    @Operation(summary = "Get all posts")
    public Iterable<Posts> getAllPosts() {
        return postService.getAllPosts();
    }

    @PostMapping
    @Operation(summary = "the posts created successfuly")
    public Posts createdPost(@RequestBody PostCreationDto postCreationDto) {
        var post = new Posts();
        post.setTitle(postCreationDto.getTitle());
        post.setContent(postCreationDto.getContent());
        post.setUser_id(postCreationDto.getUser_id());
        return postService.createPost(post);
    }

    @PutMapping
    @Operation(summary = "the post updated successfully")
    public Posts UpdatedPost(@PathVariable long id, @RequestBody PostCreationDto postCreationDto) {
        Posts post = new Posts();
        post.setTitle(postCreationDto.getTitle());
        post.setContent(postCreationDto.getContent());
        post.setUser_id(postCreationDto.getUser_id());
        post.setId(id);

    return postService.updatedPost(post);
}
    @DeleteMapping
@Operation(summary = "the post deleted successfully")
  public void deletePost(@PathVariable long id) {
    postService.deletePost(id);
    }
}




