package com.example.vote.Controller;


import com.example.vote.Service.VoteService;
import com.example.vote.Utils.AopTrigger;
import com.example.vote.Utils.IpUtil;
import com.example.vote.Utils.Util;
import com.example.vote.entity.Video;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Slf4j
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
    public String addSingleVote(@RequestParam List<Integer> voted) {
//    public String addSingleVote() {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = servletRequestAttributes.getRequest();
//        HttpServletResponse response = servletRequestAttributes.getResponse();
        String remoteAddr = IpUtil.getIpAddr(request);
        log.error("iip  :     {}     urI  :  {}   ,URL   ;{}",remoteAddr,request.getRequestURI(),request.getRequestURL().toString());
        if(!voteService.existIP(remoteAddr)){
//            List<Integer> voted=new ArrayList<>(0);
//            voted.add(1);
//            voted.add(2);
            try{
                voteService.addSingleVote(voted);
                //投票成功后，加入ip
                voteService.insertIP(remoteAddr);
                return "ok";
            }catch (Exception e){
                //投票未成功，不加入ip，可重新投
                return "投票失败，清重新投票";

            }

        }

        return "您今天已经投过票，请勿重新投票";

    }



}
