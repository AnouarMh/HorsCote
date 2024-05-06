package com.example.serveurhorscote.Service;


import com.example.serveurhorscote.Entity.HcTransactionsRealis;
import com.example.serveurhorscote.Entity.HcTransactionsRealisDestination;
import com.example.serveurhorscote.Entity.OrderOrigin;
import com.example.serveurhorscote.Repositry.DestinationRepository.HcTransactionsRealisDestinationRepository;
import com.example.serveurhorscote.Repositry.SourceRepository.HcTransactionsRealisSourceRepository;
import com.example.serveurhorscote.Repositry.SourceRepository.OrderOriginSourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;


@Service
public class HcTransactionsServiceImpl implements HcTransactionsService {
    @Autowired
    HcTransactionsRealisSourceRepository hcTransactionsRealisSourceRepository;

    @Autowired
    HcTransactionsRealisDestinationRepository hcTransactionsRealisDestinationRepository;

    @Autowired
    OrderOriginSourceRepository orderOriginSourceRepository;

    @Override
    @Scheduled(fixedRate = 5000)
    public void TransferHcTransactionsRealis() {

        List<HcTransactionsRealis> hcTransactionsRealisSource=hcTransactionsRealisSourceRepository.findAll();

        hcTransactionsRealisSource.forEach(hcTransactionsRealis -> {
         HcTransactionsRealisDestination hcTransactionsRealisDestination=new HcTransactionsRealisDestination();

            Optional<OrderOrigin> orderOriginVt=orderOriginSourceRepository.findById(hcTransactionsRealis.getCatAvoirCliVt());
            Optional<OrderOrigin> orderOriginAch=orderOriginSourceRepository.findById(hcTransactionsRealis.getCatAvoirCliAch());

            Double sellRus=hcTransactionsRealis.getRusAch();
            Double buyRus=hcTransactionsRealis.getRusVt();

            Double sellCnb=hcTransactionsRealis.getCnbAch();
            Double buyCnb=hcTransactionsRealis.getCnbVt();


                hcTransactionsRealisDestination.set_id(hcTransactionsRealis.get_id().getSessionDate());
                hcTransactionsRealisDestination.setInstrument(hcTransactionsRealis.getLibVal());
                hcTransactionsRealisDestination.setNominal(hcTransactionsRealis.getNominal());
                hcTransactionsRealisDestination.setCours(hcTransactionsRealis.getCoursPratiq());
                hcTransactionsRealisDestination.setQuantite(hcTransactionsRealis.getQuantite());

                hcTransactionsRealisDestination.setVolume(hcTransactionsRealis.getVolume());
                hcTransactionsRealisDestination.setLibIntVt(hcTransactionsRealis.getLibIntVt());
                hcTransactionsRealisDestination.setLibIntAch(hcTransactionsRealis.getLibIntAch());
                hcTransactionsRealisDestination.setCatAvoirBuyer(orderOriginVt.get().getOriginFrShortLabel());
                hcTransactionsRealisDestination.setCatAvoirSeller(orderOriginAch.get().getOriginFrShortLabel());

                hcTransactionsRealisDestination.setGroupe(hcTransactionsRealis.getValGp());
                hcTransactionsRealisDestination.setCnbSeller(sellCnb);
                hcTransactionsRealisDestination.setCnbBuyer(buyCnb);
                hcTransactionsRealisDestination.setRusSeller(sellRus);
                hcTransactionsRealisDestination.setRusBuyer(buyRus);

                hcTransactionsRealisDestination.setRusGlobal(sellRus+buyRus);
                hcTransactionsRealisDestination.setCnbGlobal(sellCnb+buyCnb);

                hcTransactionsRealisDestinationRepository.save(hcTransactionsRealisDestination);


        });

    }



}
