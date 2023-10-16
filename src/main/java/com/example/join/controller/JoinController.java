package com.example.join.controller;

import com.example.join.model.JoinRequest;
import com.example.join.service.JoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class JoinController {

    @Autowired
    private JoinService joinService;

    @PostMapping("/join")
    @ResponseBody
    public ResponseEntity requestToJoin(@RequestParam Integer postID, @RequestBody JoinRequest joinRequest){
        joinService.manageJoinRequest(postID, joinRequest);
        return ResponseEntity.ok("Driver has received your request!");
    }

}
