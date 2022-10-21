package com.example.vote.Service;

import com.example.vote.entity.Video;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VoteService {
    public void addSingleVote(List<Integer> params);

    public List<Video> selectAll();
    public void t();

    public boolean existIP(String ip);

    public boolean insertIP(String ip);

}
