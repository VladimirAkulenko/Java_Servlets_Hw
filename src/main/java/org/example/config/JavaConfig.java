package org.example.config;

import org.example.controller.PostController;
import org.example.repository.PostRepository;
import org.example.service.PostService;
import org.springframework.context.annotation.Bean;

public class JavaConfig {

    @Bean
    public PostController postController (PostService service){
        return new PostController(service);
    }

    @Bean
    public PostService postService (PostRepository repository){
        return new PostService(repository);
    }

    @Bean
    public PostRepository postRepository(){
        return new  PostRepository();
    }
}
