package by.bsuir.fanficsbackend.service.assembler;

import by.bsuir.fanficsbackend.service.dto.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class AssemblerRegistry {
    private static Map<Class<? extends ResponseDTO>, AbstractResponseDTOAssembler<?, ?>> dtoResponseAssemblerMap = new HashMap<>();

    @Autowired
    private AssemblerRegistry(List<AbstractResponseDTOAssembler<?, ?>> dtoResponseAssemblers) {
        dtoResponseAssemblers.forEach(d -> dtoResponseAssemblerMap.put(d.getResponseType(), d));
    }

    public static AbstractResponseDTOAssembler<?, ?> getResponseDTOAssembler(Class<? extends ResponseDTO> responseType) {
        return dtoResponseAssemblerMap.get(responseType);
    }
}
