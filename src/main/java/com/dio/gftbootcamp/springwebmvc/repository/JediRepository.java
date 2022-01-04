package com.dio.gftbootcamp.springwebmvc.repository;

import com.dio.gftbootcamp.springwebmvc.model.Jedi;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class JediRepository {

    private ArrayList<Jedi> jediList = new ArrayList<>();

    JediRepository(){
        this.jediList.add(new Jedi("Luke","Skywalker"));
    }

    public List<Jedi> getAllJedi(){
        return jediList;
    }

    public void save(Jedi jedi){
        jediList.add(jedi);
    }
}
