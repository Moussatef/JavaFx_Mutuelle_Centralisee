package com.example.demo1.mpl;

import com.example.demo1.dao.OfficialsDAO;
import com.example.demo1.interfases.OfficialsInterface;
import com.example.demo1.model.Officials;

public class OfficialImp implements OfficialsInterface {

    @Override
    public Officials getOfficialByEmailAndPassword(String Email,String Password){
        return new OfficialsDAO().getOfficialByEmailAndPassword(Email, Password);
    }
}
