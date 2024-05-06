package com.example.apishorscote.Service;


import com.example.apishorscote.Entity.HcTransactionsRealis;

import java.util.Date;
import java.util.List;

public interface HcTransactionsService {

    List<HcTransactionsRealis> getHcTransactionsRealisByDate(Date startDate, Date endDate);


}
