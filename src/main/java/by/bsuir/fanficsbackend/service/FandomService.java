package by.bsuir.fanficsbackend.service;

import by.bsuir.fanficsbackend.service.dto.FandomResponseDTO;
import by.bsuir.fanficsbackend.service.dto.SearchDTO;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/fandoms")
public interface FandomService extends ReadService<FandomResponseDTO, SearchDTO> {
}
