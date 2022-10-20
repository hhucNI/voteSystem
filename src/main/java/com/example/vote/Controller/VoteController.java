package com.example.vote.Controller;


import com.example.vote.Service.VoteService;
import com.example.vote.Utils.Util;
import com.example.vote.entity.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("vote")
//@RequestMapping("product/attrattrgrouprelation")
public class VoteController {

    @Autowired
    private VoteService voteService;

    @RequestMapping("/queryAll")
//    public String addSingleVote(@RequestParam List<String> params) {
    public List<Video> queryAll() {
        return voteService.selectAll();
    }

    @RequestMapping("/singleVote")
//    public String addSingleVote(@RequestParam List<String> params) {
    public String addSingleVote() {
        List<Integer> voted=new ArrayList<>(0);
        voted.add(1);
        voted.add(2);
        if(voteService.addSingleVote(voted)){
            Util.triggerAop();
        }
//        List<Video> data = voteService.selectAll();
//        String ret="-------------------------\n";
//        for (Video item : data) {
//            ret+=item.toString();
//        }
//        return ret;
        return "ok";
    }



}
