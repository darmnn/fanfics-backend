package by.bsuir.fanficsbackend.service.impl;

import by.bsuir.fanficsbackend.persistence.entity.Chapter;
import by.bsuir.fanficsbackend.persistence.repository.ChapterRepository;
import by.bsuir.fanficsbackend.service.ChapterService;
import by.bsuir.fanficsbackend.service.assembler.ChapterResponseDTOAssembler;
import by.bsuir.fanficsbackend.service.dto.ChapterResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ChapterServiceImpl implements ChapterService {
    @Autowired
    private ChapterRepository repository;
    @Autowired
    private ChapterResponseDTOAssembler responseAssembler;

    @Override
    public List<ChapterResponseDTO> get(Long id) {
        List<Chapter> entities = new ArrayList<>();
        entities.addAll(repository.findByBookId(id));
        return entities.stream().map(e -> responseAssembler.toModel(e)).collect(Collectors.toList());
    }
}
