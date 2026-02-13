package com.example.demo.controller;

import com.example.demo.dto.SolicitudEfectivoDTO;
import com.example.demo.entity.SolicitudEfectivo;
import com.example.demo.service.SolicitudEfectivoService;
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
@RequestMapping(ApiConstants.API_BASE_PATH + "/solicitudes-efectivo")
public class SolicitudEfectivoController {

    @Autowired
    private SolicitudEfectivoService solicitudEfectivoService;

    @Autowired
    private MapperUtil mapperUtil;

    @PostMapping
    public ResponseEntity<ApiResponse<SolicitudEfectivoDTO>> createSolicitud(
            @Valid @RequestBody SolicitudEfectivoDTO solicitudDTO) {
        SolicitudEfectivo solicitud = mapperUtil.map(solicitudDTO, SolicitudEfectivo.class);
        SolicitudEfectivo created = solicitudEfectivoService.createSolicitud(solicitud);
        SolicitudEfectivoDTO dto = mapperUtil.map(created, SolicitudEfectivoDTO.class);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.success(ApiConstants.CREATE_SUCCESS, dto));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<SolicitudEfectivoDTO>>> getAllSolicitudes() {
        List<SolicitudEfectivo> solicitudes = solicitudEfectivoService.getAllSolicitudes();
        List<SolicitudEfectivoDTO> dtos = mapperUtil.mapList(solicitudes, SolicitudEfectivoDTO.class);
        return ResponseEntity.ok(ApiResponse.success("Solicitudes obtenidas exitosamente", dtos));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<SolicitudEfectivoDTO>> getSolicitudById(@PathVariable Long id) {
        SolicitudEfectivo solicitud = solicitudEfectivoService.getSolicitudById(id);
        if (solicitud == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(ApiResponse.error("Solicitud no encontrada"));
        }
        SolicitudEfectivoDTO dto = mapperUtil.map(solicitud, SolicitudEfectivoDTO.class);
        return ResponseEntity.ok(ApiResponse.success("Solicitud encontrada", dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<SolicitudEfectivoDTO>> updateSolicitud(
            @PathVariable Long id, @Valid @RequestBody SolicitudEfectivoDTO solicitudDTO) {
        SolicitudEfectivo solicitud = mapperUtil.map(solicitudDTO, SolicitudEfectivo.class);
        SolicitudEfectivo updated = solicitudEfectivoService.updateSolicitud(id, solicitud);
        if (updated == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(ApiResponse.error("Solicitud no encontrada"));
        }
        SolicitudEfectivoDTO dto = mapperUtil.map(updated, SolicitudEfectivoDTO.class);
        return ResponseEntity.ok(ApiResponse.success(ApiConstants.UPDATE_SUCCESS, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteSolicitud(@PathVariable Long id) {
        boolean deleted = solicitudEfectivoService.deleteSolicitud(id);
        if (!deleted) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(ApiResponse.error("Solicitud no encontrada"));
        }
        return ResponseEntity.ok(ApiResponse.success(ApiConstants.DELETE_SUCCESS, null));
    }
}