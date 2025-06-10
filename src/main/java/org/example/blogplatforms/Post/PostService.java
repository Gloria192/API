package org.example.blogplatforms.Post;

import org.springframework.stereotype.Service;

@Service
public class PostService {
    private final PostRepository postRepository;
    public PostService(PostRepository postRepository) {

        this.postRepository = postRepository;
    }
    public Posts createPost(Posts posts){
       
        return postRepository.save(posts);
    }


    public void deletePost(long id){

        postRepository.deleteById(id);
    }
    public Iterable<Posts> getAllPosts(){

        return postRepository.findAll();
    }
    public Posts updatedPost(  Posts posts){
        var post =postRepository.findById(posts.getId()).orElseThrow (() ->new IllegalArgumentException("the post not found"));
          post.setTitle(posts.getTitle());
          post.setContent(posts.getContent());
          post.setUser_id(post.getUser_id());
        return postRepository.save(posts);
        }



    }

