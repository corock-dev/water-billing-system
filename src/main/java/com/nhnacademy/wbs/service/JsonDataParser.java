package com.nhnacademy.wbs.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nhnacademy.wbs.repository.Tariff;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import org.springframework.stereotype.Service;

@Service(value = "jsonDataParser")
public class JsonDataParser implements DataParser {
    @Override
    public Collection<Tariff> parse(String path) {
        URL resource = this.getClass().getClassLoader().getResource(path);
        File jsonFile = new File(Objects.requireNonNull(resource).getFile());

        ObjectMapper mapper = new ObjectMapper();
        List<Tariff> tariffs;

        try {
            tariffs = mapper.readValue(jsonFile, new TypeReference<>() {
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return tariffs;
    }
}
