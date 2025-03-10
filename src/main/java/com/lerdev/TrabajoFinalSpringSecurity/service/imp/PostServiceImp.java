package com.lerdev.TrabajoFinalSpringSecurity.service.imp;

import com.lerdev.TrabajoFinalSpringSecurity.model.Post;
import com.lerdev.TrabajoFinalSpringSecurity.repository.IPostRepository;
import com.lerdev.TrabajoFinalSpringSecurity.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImp implements PostService {

    @Autowired
    private IPostRepository postRepository;
    @Override
    public List<Post> getAll() {
        return postRepository.findAll();
    }

    @Override
    public Post findById(Long id) {
        return  postRepository.findById(id).orElseThrow(null);
    }

    @Override
    public Post findByTittle(String title) {
        return postRepository.findByTittle(title);
    }

    @Override
    public void save(Post post) {
     postRepository.save(post);
    }

    @Override
    public void delete(Long id) {
       postRepository.deleteById(id);
    }

    @Override
    public Post update(Post post) {
        return postRepository.save(post);
    }
}
