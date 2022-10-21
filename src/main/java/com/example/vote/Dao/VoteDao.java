package com.example.vote.Dao;


import com.example.vote.entity.Video;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface VoteDao {
    public void addSingleVote(int video);

    public int queryExistenceById(int video);

    public void insertById(String video);

    public List<Video> selectAll();

    public int queryIP(String ip);

    public void insertIP(String ip);
}
