package com.example.serveurhorscote.Repositry.SourceRepository;

import com.example.serveurhorscote.Entity.OrderOrigin;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderOriginSourceRepository extends MongoRepository<OrderOrigin,String > {
}
