package net.javaguides.personnalmanagement.Mappers;

import net.javaguides.personnalmanagement.Dtos.DcpDto;
import net.javaguides.personnalmanagement.Entities.Dcp;
import org.springframework.stereotype.Component;

public class DCPMapper {


        public DcpDto toDTO(Dcp dcp) {
            DcpDto dto = new DcpDto();
            dto.setId(dcp.getId());
            dto.setNom(dcp.getNom());
            dto.setDescription(dcp.getDescription());
            dto.setPosteValide(dcp.isPosteValide());
            return dto;
        }

        public Dcp toEntity(DcpDto dto) {
            Dcp dcp = new Dcp();
            dcp.setId(dto.getId());
            dcp.setNom(dto.getNom());
            dcp.setDescription(dto.getDescription());
            dcp.setPosteValide(dto.isPosteValide());
            return dcp;
        }
    }

