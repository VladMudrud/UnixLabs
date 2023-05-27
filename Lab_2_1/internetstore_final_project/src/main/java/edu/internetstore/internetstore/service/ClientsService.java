package edu.internetstore.internetstore.service;

import edu.internetstore.internetstore.dto.ClientsDto;
import edu.internetstore.internetstore.repository.ClientsRepository;
import edu.internetstore.internetstore.util.EntityToDto;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ClientsService implements InternetStoreService<ClientsDto> {

    @Autowired
    private ClientsRepository clientsRepository;

    @Override
    public List<ClientsDto> getAllData() {
        return null;
    }

    @Override
    public ClientsDto getDataById(String id) {
        return EntityToDto.clientsEntityToDto(clientsRepository.findById(UUID.fromString(id))
                .orElseThrow(() -> new EntityNotFoundException("Client was not found")));
    }

    @Override
    public void insertData(ClientsDto element) {

    }

    @Override
    public void updateData(ClientsDto element) {

    }

    @Override
    public ClientsDto getData(ClientsDto element) {
        return null;
    }
}
