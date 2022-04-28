package by.bsuir.fanficsbackend.service.assembler;

import by.bsuir.fanficsbackend.service.dto.RequestDTO;
import by.bsuir.fanficsbackend.service.dto.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class AssemblerRegistry {
    private static Map<Class<? extends ResponseDTO>, AbstractResponseDTOAssembler<?, ?>> dtoResponseAssemblerMap = new HashMap<>();
    private static Map<Class<? extends RequestDTO>, AbstractRequestDTOAssembler<?, ?, ?>> dtoCreateRequestAssemblerMap = new HashMap<>();
    private static Map<Class<? extends RequestDTO>, AbstractRequestDTOAssembler<?, ?, ?>> dtoUpdateRequestAssemblerMap = new HashMap<>();

    @Autowired
    private AssemblerRegistry(List<AbstractResponseDTOAssembler<?, ?>> dtoResponseAssemblers,
                              List<AbstractRequestDTOAssembler<?, ?, ?>> dtoRequestAssemblers) {
        dtoResponseAssemblers.forEach(d -> dtoResponseAssemblerMap.put(d.getResponseType(), d));
        dtoRequestAssemblers.forEach(d -> {
            dtoCreateRequestAssemblerMap.put(d.getCreateDTOType(), d);
            dtoUpdateRequestAssemblerMap.put(d.getUpdateDTOType(), d);
        });
    }

    public static AbstractResponseDTOAssembler<?, ?> getResponseDTOAssembler(Class<? extends ResponseDTO> responseType) {
        return dtoResponseAssemblerMap.get(responseType);
    }

    public static AbstractRequestDTOAssembler<?, ?, ?> getCreateRequestDtoAssembler(Class<? extends RequestDTO> createType){
        return dtoCreateRequestAssemblerMap.get(createType);
    }

    public static AbstractRequestDTOAssembler<?, ?, ?> getUpdateRequestDtoAssembler(Class<? extends RequestDTO> updateType) {
        return dtoUpdateRequestAssemblerMap.get(updateType);
    }
}
