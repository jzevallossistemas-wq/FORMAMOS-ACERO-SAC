package com.example.demo.controller;

import com.example.demo.dto.SolicitudViaticoDTO;
import com.example.demo.entity.SolicitudViatico;
import com.example.demo.service.SolicitudViaticoService;
import com.example.demo.util.MapperUtil;
import com.example.demo.response.ApiResponse;
import com.example.demo.constant.ApiConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(ApiConstants.API_BASE_PATH + "/solicitudes-viatico")
public class SolicitudViaticoController {

    @Autowired
    private SolicitudViaticoService solicitudViaticoService;

    @Autowired
    private MapperUtil mapperUtil;

    @PostMapping
    public ResponseEntity<ApiResponse<SolicitudViaticoDTO>> createSolicitudViatico(
            @Valid @RequestBody SolicitudViaticoDTO solicitudDTO) {
        SolicitudViatico solicitud = mapperUtil.map(solicitudDTO, SolicitudViatico.class);
        SolicitudViatico created = solicitudViaticoService.createSolicitudViatico(solicitud);
        SolicitudViaticoDTO dto = mapperUtil.map(created, SolicitudViaticoDTO.class);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.success(ApiConstants.CREATE_SUCCESS, dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<SolicitudViaticoDTO>> getSolicitudViatico(@PathVariable Long id) {
        SolicitudViatico solicitud = solicitudViaticoService.getSolicitudViaticoById(id);
        if (solicitud == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(ApiResponse.error("Solicitud no encontrada"));
        }
        SolicitudViaticoDTO dto = mapperUtil.map(solicitud, SolicitudViaticoDTO.class);
        return ResponseEntity.ok(ApiResponse.success("Solicitud encontrada", dto));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<SolicitudViaticoDTO>>> getAllSolicitudViaticos() {
        List<SolicitudViatico> solicitudes = solicitudViaticoService.getAllSolicitudViaticos();
        List<SolicitudViaticoDTO> dtos = mapperUtil.mapList(solicitudes, SolicitudViaticoDTO.class);
        return ResponseEntity.ok(ApiResponse.success("Solicitudes obtenidas exitosamente", dtos));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<SolicitudViaticoDTO>> updateSolicitudViatico(
            @PathVariable Long id, @Valid @RequestBody SolicitudViaticoDTO solicitudDTO) {
        SolicitudViatico solicitud = mapperUtil.map(solicitudDTO, SolicitudViatico.class);
        SolicitudViatico updated = solicitudViaticoService.updateSolicitudViatico(id, solicitud);
        if (updated == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(ApiResponse.error("Solicitud no encontrada"));
        }
        SolicitudViaticoDTO dto = mapperUtil.map(updated, SolicitudViaticoDTO.class);
        return ResponseEntity.ok(ApiResponse.success(ApiConstants.UPDATE_SUCCESS, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteSolicitudViatico(@PathVariable Long id) {
        solicitudViaticoService.deleteSolicitudViatico(id);
        return ResponseEntity.ok(ApiResponse.success(ApiConstants.DELETE_SUCCESS, null));
    }
}