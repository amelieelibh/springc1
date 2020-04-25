package mx.devhive.store.storemanager.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

import com.google.common.collect.Lists;

import lombok.extern.slf4j.Slf4j;
import mx.devhive.store.storemanager.model.Client;
//import mx.devhive.store.storemanager.model.dto.UserType;
import mx.devhive.store.storemanager.model.dto.CardInfo;
import mx.devhive.store.storemanager.repositories.ClientRepository;
import mx.devhive.store.storemanager.services.ClientService;

@Slf4j
@ExtendWith(MockitoExtension.class)
@TestInstance(Lifecycle.PER_CLASS)
@ContextConfiguration(classes = {ClientService.class, ClientRepository.class})
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ActiveProfiles("dev")
@SpringBootTest(classes = {ClientService.class})
@AutoConfigureMockMvc
public class ClientServiceTest {

    @Autowired
    private ClientService clientService;

    @MockBean
    private ClientRepository clientRepository;
    
    @BeforeEach
    public void init(){
    	final List<Client> clients = Lists.newArrayList();
    	CardInfo cardinfo1 = CardInfo.builder()
    			.cvv("589")
    			.name("MARCO CANALES ROMERO")
    			.number("2356 4578 4512 9865")
    			.expirationMonth("03")
    			.expirationYear("2023")
    			.build();
    	Client client1 = Client.builder()
				.address("Eje central 3765, colonia doctores")
				.cardInfo(cardinfo1)
				.build();
    	
    	CardInfo cardinfo2 = CardInfo.builder()
    			.cvv("236")
    			.name("RAFAEL ROBLEDO PEREZ")
    			.number("2356 4578 4513 9865")
    			.expirationMonth("04")
    			.expirationYear("2024")
    			.build();
    	Client client2 = Client.builder()
				.address("Eje central 3765, colonia doctores")
				.cardInfo(cardinfo2)
				.build();
    	
		clients.add(client1);
		clients.add(client2);
    	
    	Mockito.when(clientRepository.findAll()).thenReturn(clients);
    	Mockito.when(clientRepository.findAllOrderByRfc()).thenReturn(clients);
    	
    }
    
    @Order(1)
    @Test
    public void findAllTest() throws Exception{
    	List<Client> items = clientService.getAllClients();
    	assertNotNull(items, "items were null but not null expected");
    	items.forEach((item) -> log.debug("item :" + item.toString()));
    	Mockito.verify(clientRepository, Mockito.times(1)).findAll();
    	assertEquals(items.size(), 2);
    }
    
    @Order(2)
    @Test
    public void findAllOrderByRfc() throws Exception{
    	List<Client> items = clientService.getAllClientsOrderedDesc();
    	assertNotNull(items, "items were null but not null expected");
    	items.forEach((item) -> log.debug("item :" + item.toString()));
    	Mockito.verify(clientRepository, Mockito.times(1)).findAllOrderByRfc();
    	assertEquals(items.size(), 2);
    }

}
