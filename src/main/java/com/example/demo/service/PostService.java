package com.example.demo.service;

import com.example.demo.model.PostModel;
import com.example.demo.repository.PersonRepository;
import com.example.demo.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class PostService {

@Autowired
private HttpServletRequest httpServletRequest;

@Autowired
private PostRepository postRepository;

@Autowired
private PersonRepository personRepository;


public List<PostModel> getAllPosts() {

List<PostModel> liste=postRepository.getAll();
return liste;

}

//adding remaining values of post like username, id of person who posted and post time, and sends to the repository
public void addPost(PostModel postModel) {
    postModel.setSharedDate(LocalDateTime.now());
    String currentUsername=httpServletRequest.getUserPrincipal().getName();
    postModel.setUsername(currentUsername);
    postModel.setPersonId(findUserIdFromCurrentUser());
    postRepository.savePost(postModel);


}

//getting userid with current user's username
public int findUserIdFromCurrentUser() {
    String currentUsername=httpServletRequest.getUserPrincipal().getName();

    return personRepository.findPersonFromUsername(currentUsername).getId();

}

//finding count of how many posted by current user
public int findPostCountFromCurrentUser()
{
    int id=findUserIdFromCurrentUser();



    return  postRepository.findPostCount(id);
}




}




