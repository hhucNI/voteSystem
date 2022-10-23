package com.example.vote.Service;

import com.example.vote.Dao.VoteDao;
import com.example.vote.entity.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VoteServiceImpl implements VoteService {


    @Autowired
    private VoteDao voteDao;

    private List<Video> cache = null;


    public boolean existIP(String ip) {
        return voteDao.queryIP(ip) == 1;
    }

    public boolean insertIP(String ip) {
        try {
            voteDao.insertIP(ip);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Transactional(rollbackFor = Exception.class)
    public void addSingleVote(List<Integer> params) {
        for (int id : params) {
//            if(id==2) throw new RuntimeException();
            voteDao.addSingleVote(id);
        }
    }

    public List<Video> selectAll() {
        Object lock=new Object();
        if(cache==null){
            synchronized (lock){
                if(cache==null){
                    cache=voteDao.selectAll();
                }
                return cache;
            }
        }
        return cache;

    }

    public void t() {

    }


}
