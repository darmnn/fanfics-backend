package by.bsuir.fanficsbackend.service.assembler;

import by.bsuir.fanficsbackend.persistence.entity.Fandom;
import by.bsuir.fanficsbackend.service.dto.FandomResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class FandomResponseDTOAssembler extends AbstractResponseDTOAssembler<Fandom, FandomResponseDTO> {
    public FandomResponseDTOAssembler() {
        super(FandomResponseDTO.class, Fandom.class);
    }
}
