package org.sapient.metalica.referencedataservice;

import org.sapient.metalica.referencedataservice.model.Commodity;
import org.sapient.metalica.referencedataservice.model.CounterParty;
import org.sapient.metalica.referencedataservice.model.Location;
import org.sapient.metalica.referencedataservice.repository.CommodityRepository;
import org.sapient.metalica.referencedataservice.repository.CounterPartyRepository;
import org.sapient.metalica.referencedataservice.repository.LocationRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import javax.annotation.Resource;

@SpringBootApplication
@EnableMongoRepositories
public class BootApplication implements CommandLineRunner {

    @Resource CommodityRepository commodityRepository;
    @Resource CounterPartyRepository counterPartyRepository;
    @Resource LocationRepository locationRepository;

    public static void main(String[] args) {
        SpringApplication.run(BootApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        initializeRefDataDB();
    }

    private void initializeRefDataDB() {
        commodityRepository.save(new Commodity("AL", "Aluminium"));
        commodityRepository.save(new Commodity("FE", "Iron"));
        commodityRepository.save(new Commodity("AU", "Gold"));
        commodityRepository.save(new Commodity("AG", "Silver"));

        counterPartyRepository.save(new CounterParty("Lorem", "Lorem"));
        counterPartyRepository.save(new CounterParty("Ipsum", "Ipsum"));
        counterPartyRepository.save(new CounterParty("Dolor", "Dolor"));
        counterPartyRepository.save(new CounterParty("Sit", "Sit"));
        counterPartyRepository.save(new CounterParty("Amet", "Amet"));
        counterPartyRepository.save(new CounterParty("Consectitor", "Consectitor"));
        counterPartyRepository.save(new CounterParty("Adsiping", "Adsiping"));


        locationRepository.save(new Location("LON", "London"));
        locationRepository.save(new Location("NYC", "New York"));
        locationRepository.save(new Location("TOK", "Tokyo"));
        locationRepository.save(new Location("DUB", "Dubai"));
        locationRepository.save(new Location("HON", "Hong Kong"));
    }

}
