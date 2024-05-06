package com.example.serveurhorscote.Service;


import com.example.serveurhorscote.Entity.Instruments;
import com.example.serveurhorscote.Entity.Registrations;
import com.example.serveurhorscote.Entity.RegistrationsDestination;
import com.example.serveurhorscote.Repositry.DestinationRepository.RegistrationsDestinationRepository;
import com.example.serveurhorscote.Repositry.SourceRepository.InstrumentsSourceRepository;
import com.example.serveurhorscote.Repositry.SourceRepository.RegistrationsSourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class RegistrationsServiceImpl implements RegistrationsService{
   @Autowired
   RegistrationsSourceRepository registrationsSourceRepository;

   @Autowired
    RegistrationsDestinationRepository registrationsDestinationRepository;

   @Autowired
    InstrumentsSourceRepository instrumentsSourceRepository;

    @Override
    @Scheduled(fixedRate = 5000)
    public void TransferRegistrations() {
        List<Registrations> registrationsSource=registrationsSourceRepository.findAll();

        registrationsSource.forEach(registrations -> {
            Optional<Instruments> instrument=instrumentsSourceRepository.findById(registrations.getCodeIsin());
                RegistrationsDestination registrationsDestination = new RegistrationsDestination();

                Double sellRus=registrations.getGlobalRus();
                Double buyRus=registrations.getGlobalRus();

                Double sellCeb=registrations.getSellCeb();
                Double buyCeb=registrations.getBuyCeb();


                registrationsDestination.setNOrdre(registrations.get_id());
                registrationsDestination.setInstrument(registrations.getInstrument());
                registrationsDestination.setSellerNationality(registrations.getSellersCostumers().get(0).getNationality());
                registrationsDestination.setBrokerSeller(registrations.getBrokerSeller());
                registrationsDestination.setBuyerNationality(registrations.getBuyersCostumers().get(0).getNationality());

                registrationsDestination.setBrokerBuyer(registrations.getBrokerBuyer());
                registrationsDestination.setQuantityExchanged(registrations.getQuantityExchanged());
                registrationsDestination.setDecisionDate(registrations.getDecisionDate());
                registrationsDestination.setDepositDate(registrations.getDepositDate());
                registrationsDestination.setLastNominal(instrument.get().getLastNominal());

                registrationsDestination.setUnitPrice(registrations.getUnitPrice());
                registrationsDestination.setGlobalVolume(registrations.getGlobalVolume());
                registrationsDestination.setGroup(instrument.get().getIdentities().get(0).getCodeGroup());
                registrationsDestination.setSellCeb(sellCeb);
                registrationsDestination.setBuyCeb(buyCeb);

                registrationsDestination.setSellRus(sellRus);
                registrationsDestination.setBuyRus(buyRus);
                registrationsDestination.setGlobalCeb(sellCeb+buyCeb);
                registrationsDestination.setGlobalRus(sellRus+buyRus);
                registrationsDestination.setStatus(registrations.getLastStatus().getStatusFrName());

                registrationsDestination.setBis(registrations.getBis());

                registrationsDestinationRepository.save(registrationsDestination);

        });

    }


}
