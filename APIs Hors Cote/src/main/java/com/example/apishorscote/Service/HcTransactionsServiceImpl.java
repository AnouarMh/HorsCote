package com.example.apishorscote.Service;



import com.example.apishorscote.Entity.HcTransactionsRealis;
import com.example.apishorscote.Repository.HcTransactionsRealisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class HcTransactionsServiceImpl implements HcTransactionsService {
    @Autowired
    HcTransactionsRealisRepository hcTransactionsRealisRepository;


    @Override
    public List<HcTransactionsRealis> getHcTransactionsRealisByDate(Date startDate, Date endDate) {
        return hcTransactionsRealisRepository.findHcTransactionsRealisDestinationBy_idBetween(startDate, endDate);
    }


}
