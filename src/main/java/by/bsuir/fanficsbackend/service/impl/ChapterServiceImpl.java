package by.bsuir.fanficsbackend.service.impl;

import by.bsuir.fanficsbackend.persistence.entity.Chapter;
import by.bsuir.fanficsbackend.persistence.repository.ChapterRepository;
import by.bsuir.fanficsbackend.service.AbstractReadService;
import by.bsuir.fanficsbackend.service.ChapterService;
import by.bsuir.fanficsbackend.service.assembler.ChapterResponseDTOAssembler;
import by.bsuir.fanficsbackend.service.dto.ChapterResponseDTO;
import by.bsuir.fanficsbackend.service.dto.ChapterSearchDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ChapterServiceImpl extends AbstractReadService<ChapterResponseDTO, ChapterSearchDTO, Chapter, ChapterRepository>
        implements ChapterService {
    @Autowired
    public ChapterServiceImpl(ChapterResponseDTOAssembler responseAssembler) {
        super(responseAssembler, Chapter.class);
    }

    @Override
    protected List<Predicate> buildSearchPredicates(ChapterSearchDTO dto, Root<Chapter> root) {
        List<Predicate> predicateList = new ArrayList<>();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        predicateList.add(criteriaBuilder.equal(root.get("book").get("name"), dto.getBookName()));
        return predicateList;
    }
}
