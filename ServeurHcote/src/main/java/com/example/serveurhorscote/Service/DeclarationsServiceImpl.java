package com.example.serveurhorscote.Service;

import com.example.serveurhorscote.Entity.Declarations;
import com.example.serveurhorscote.Entity.DeclarationsDestination;
import com.example.serveurhorscote.Entity.Instruments;
import com.example.serveurhorscote.Repositry.DestinationRepository.DeclarationsDestinationRepository;
import com.example.serveurhorscote.Repositry.SourceRepository.DeclarationsSourceRepository;
import com.example.serveurhorscote.Repositry.SourceRepository.InstrumentsSourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeclarationsServiceImpl implements DeclarationsService{

    @Autowired
    private DeclarationsSourceRepository sourceDeclarationsRepository;

    @Autowired
    private DeclarationsDestinationRepository destinationDeclarationsRepository;


    @Autowired
    private InstrumentsSourceRepository instrumentsSourceRepository;

    @Override
    @Scheduled(fixedRate = 5000)
    public void TransferDeclarationsData() {
        List<Declarations> declarationsSource = sourceDeclarationsRepository.findAll();

        declarationsSource.forEach(declarations -> {
            Optional<Instruments> instruments=instrumentsSourceRepository.findById(declarations.getCodeIsin());

            DeclarationsDestination declarationsDestination=new DeclarationsDestination();
            declarationsDestination.set_id(declarations.get_id());
            declarationsDestination.setInstrument(declarations.getInstrument());
            declarationsDestination.setBuyersNationality(declarations.getBuyersCostumers().get(0).getNationality());
            declarationsDestination.setBrokerBuyer(declarations.getBrokerBuyer());
            declarationsDestination.setSellersNationality(declarations.getSellersCostumers().get(0).getNationality());
            declarationsDestination.setBrokerSeller(declarations.getBrokerSeller());
            declarationsDestination.setQuantityExchanged(declarations.getQuantityExchanged());
            declarationsDestination.setDecisionDate(declarations.getDecisionDate());
            declarationsDestination.setDepositDate(declarations.getDepositDate());
            declarationsDestination.setLastNominal(instruments.get().getLastNominal());
            declarationsDestination.setUnitPrice(declarations.getUnitPrice());
            declarationsDestination.setGlobalVolume(declarations.getGlobalVolume());
            declarationsDestination.setStatus(declarations.getLastStatus().getStatusFrName());
            declarationsDestination.setBis(declarations.getBis());
            destinationDeclarationsRepository.save(declarationsDestination);
        });


    }



}
