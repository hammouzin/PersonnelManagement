package net.javaguides.personnalmanagement.Mappers;

import net.javaguides.personnalmanagement.Dtos.AgentDto;
import net.javaguides.personnalmanagement.Dtos.DcpDto;
import net.javaguides.personnalmanagement.Entities.Agent;
import net.javaguides.personnalmanagement.Entities.Dcp;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

public class DCPMapper {


    public static Dcp mapDcpDtoToDcp(DcpDto dcpDto) {
        Dcp dcp = new Dcp(
                dcpDto.getId(),
                dcpDto.getNom(),
                dcpDto.getDescription(),
                dcpDto.isPosteValide()
        );

        return dcp;
    }

    public static DcpDto mapDcpToDcpDTO(Dcp dcp) {
        DcpDto dcpDto = new DcpDto(
                dcp.getId(),
                dcp.getNom(),
                dcp.getDescription(),
                dcp.isPosteValide()
        );



        return dcpDto;
    }
}

