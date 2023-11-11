package com.campushare.join.controller;

import com.campushare.join.model.JoinRequest;
import com.campushare.join.model.OrderPickupRequest;
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
        joinService.manageJoinRequest(postID, joinRequest);
        return ResponseEntity.ok("Driver has received your request!");
    }

    @PostMapping("/request-order")
    @ResponseBody
    public ResponseEntity requestOrderPickup(@RequestParam String postID, @RequestParam OrderPickupRequest orderPickupRequest){
        joinService.manageFoodOrderRequest(postID, orderPickupRequest);
        return ResponseEntity.ok("Driver has received your request!");
    }

    @PostMapping("/request-lunch-outing")
    @ResponseBody
    public ResponseEntity requestLunchOuting(@RequestParam String postID, @RequestBody JoinRequest joinRequest){
        joinService.manageLunchCarpool(postID, joinRequest);
        return ResponseEntity.ok("Driver has received your request!");
    }
}
