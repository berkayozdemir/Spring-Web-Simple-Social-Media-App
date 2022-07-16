package com.example.demo.rest;

import com.example.demo.model.PostModel;
import com.example.demo.model.Response;
import com.example.demo.repository.PostRepository;

import com.example.demo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path="/api/post")
public class PostRestController {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private PostService postService;

    //get all values
    @GetMapping(value = "/getPosts")
    public List<PostModel> getPosts() {
        return postRepository.getAll();

    }

    //get al values according to a condition, condition is existing in the body
    @GetMapping(value = "/getPostsWithBody")
    public List<PostModel> getPostsWithBody(@RequestBody PostModel postModel) {
        if(postModel!=null && postModel.getPersonId()>0)
        {
            return postRepository.getAllById(postModel.getPersonId());
        }
        else
        {return  List.of();}

    }
    //get all values according to a condition, condition has given as parameter
    @GetMapping(value = "/getPostsWithParam")
    public List<PostModel> getPostsWithParam(@RequestParam(name="personId") int id) {

            return postRepository.getAllById(id);


    }

    //save an object. object is giving as body
    @PostMapping("/savePost")
    public ResponseEntity<Response> savePost(@RequestBody PostModel postModel) {
        postService.addPost(postModel);
        Response response=new Response();
        response.setStatuscode("200");
        response.setStatusMessage("Saved succesfully");
        return ResponseEntity.status(HttpStatus.CREATED).body(response);



    }




}
