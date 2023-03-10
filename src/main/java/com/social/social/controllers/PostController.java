package com.social.social.controllers;
import com.social.social.entities.Post;
import com.social.social.requests.PostCreateRequest;
import com.social.social.requests.PostUpdateRequest;
import org.springframework.web.bind.annotation.*;
import com.social.social.services.PostService;
import java.util.Optional;
import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

  private PostService postService;

  public PostController(PostService postService) {
    this.postService = postService;
  }

  @GetMapping
  public List<Post> getAllPosts(@RequestParam Optional<Long> userId){
      return postService.getAllPosts(userId);
  }

  @GetMapping("/{postId}")
  public Post getOnePost(@PathVariable Long postId) {
    return postService.getOnePostById(postId);
  }


  @PostMapping
  public Post createOnePost(@RequestBody PostCreateRequest newPostRequest) {
    return postService.createOnePost(newPostRequest);
  }

  @PutMapping("/{postId}")
  public Post updateOnePost(@PathVariable Long postId, @RequestBody PostUpdateRequest updatePost) {
    return postService.updateOnePostById(postId,updatePost);
  }

  @DeleteMapping("/{postId}")
  public void deleteOnePost(@PathVariable Long postId) {
    postService.deleteOnePostById(postId);
  }





}
