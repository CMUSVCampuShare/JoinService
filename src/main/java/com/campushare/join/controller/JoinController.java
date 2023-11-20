package com.campushare.join.controller;

import com.campushare.join.model.JoinRequest;
import com.campushare.join.service.JoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class JoinController {

    @Autowired
    private JoinService joinService;

    @PostMapping("/join")
    @ResponseBody
    public ResponseEntity requestToJoin(@RequestParam String postID, @RequestBody JoinRequest joinRequest){
        System.out.println("Ride join");
        joinService.manageJoinRequest(postID, joinRequest);
        return ResponseEntity.ok("Driver has received your request!");
    }

    @PostMapping("/request-food")
    @ResponseBody
    public ResponseEntity requestFood(@RequestParam String postID, @RequestBody JoinRequest joinRequest){
        System.out.println("Food join");
        joinService.manageLunchAndFood(postID, joinRequest);
        return ResponseEntity.ok("Driver has received your request!");
    }
}
