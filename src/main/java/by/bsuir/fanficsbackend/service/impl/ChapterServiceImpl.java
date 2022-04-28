package by.bsuir.fanficsbackend.service.impl;

import by.bsuir.fanficsbackend.persistence.entity.Chapter;
import by.bsuir.fanficsbackend.persistence.repository.BookRepository;
import by.bsuir.fanficsbackend.persistence.repository.ChapterRepository;
import by.bsuir.fanficsbackend.service.AbstractCrudService;
import by.bsuir.fanficsbackend.service.ChapterService;
import by.bsuir.fanficsbackend.service.assembler.ChapterRequestDTOAssembler;
import by.bsuir.fanficsbackend.service.assembler.ChapterResponseDTOAssembler;
import by.bsuir.fanficsbackend.service.dto.ChapterCreateRequestDTO;
import by.bsuir.fanficsbackend.service.dto.ChapterResponseDTO;
import by.bsuir.fanficsbackend.service.dto.ChapterSearchDTO;
import by.bsuir.fanficsbackend.service.dto.ChapterUpdateRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ChapterServiceImpl extends AbstractCrudService<ChapterResponseDTO, ChapterCreateRequestDTO,
        ChapterUpdateRequestDTO, ChapterSearchDTO, Chapter, ChapterRepository> implements ChapterService {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    public ChapterServiceImpl(ChapterResponseDTOAssembler responseAssembler, ChapterRequestDTOAssembler requestAssembler) {
        super(responseAssembler, requestAssembler, Chapter.class);
    }

    @Override
    public List<ChapterResponseDTO> getBookChapters(Long id) {
        List<Chapter> entities = new ArrayList<>();
        entities.addAll(repository.findByBookId(id));
        return entities.stream().map(e -> responseAssembler.toModel(e)).collect(Collectors.toList());
    }

    @Override
    protected void processAdditionalFieldForCreate(ChapterCreateRequestDTO dto, Chapter entity) {
        super.processAdditionalFieldForCreate(dto, entity);
    }

    @Override
    public boolean hasUpdateAccess(Long id) {
        return false;
    }
}
