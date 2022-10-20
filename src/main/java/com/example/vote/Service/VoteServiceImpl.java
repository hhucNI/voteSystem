package com.example.vote.Service;

import com.example.vote.Dao.VoteDao;
import com.example.vote.entity.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoteServiceImpl implements VoteService{


    @Autowired
    private VoteDao voteDao;
    public Boolean addSingleVote(List<Integer> params){
        for (int id : params) {
//            if(voteDao.queryExistenceById(s)==0){
//                voteDao.insertById(s);
//            }else{
                voteDao.addSingleVote(id);
        }
        return true;
    }

    public List<Video> selectAll(){
        return voteDao.selectAll();
    }


}
