package com.example.demo.controller;

import com.example.demo.dto.CotizacionPasajesDTO;
import com.example.demo.entity.CotizacionPasajes;
import com.example.demo.service.CotizacionPasajesService;
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
@RequestMapping(ApiConstants.API_BASE_PATH + "/cotizaciones-pasajes")
public class CotizacionPasajesController {

    @Autowired
    private CotizacionPasajesService cotizacionPasajesService;

    @Autowired
    private MapperUtil mapperUtil;

    @PostMapping
    public ResponseEntity<ApiResponse<CotizacionPasajesDTO>> createCotizacion(
            @Valid @RequestBody CotizacionPasajesDTO cotizacionDTO) {
        CotizacionPasajes cotizacion = mapperUtil.map(cotizacionDTO, CotizacionPasajes.class);
        CotizacionPasajes created = cotizacionPasajesService.createCotizacion(cotizacion);
        CotizacionPasajesDTO dto = mapperUtil.map(created, CotizacionPasajesDTO.class);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.success(ApiConstants.CREATE_SUCCESS, dto));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<CotizacionPasajesDTO>>> getAllCotizaciones() {
        List<CotizacionPasajes> cotizaciones = cotizacionPasajesService.getAllCotizaciones();
        List<CotizacionPasajesDTO> dtos = mapperUtil.mapList(cotizaciones, CotizacionPasajesDTO.class);
        return ResponseEntity.ok(ApiResponse.success("Cotizaciones obtenidas exitosamente", dtos));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<CotizacionPasajesDTO>> getCotizacionById(@PathVariable Long id) {
        CotizacionPasajes cotizacion = cotizacionPasajesService.getCotizacionById(id);
        if (cotizacion == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(ApiResponse.error("Cotización no encontrada"));
        }
        CotizacionPasajesDTO dto = mapperUtil.map(cotizacion, CotizacionPasajesDTO.class);
        return ResponseEntity.ok(ApiResponse.success("Cotización encontrada", dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<CotizacionPasajesDTO>> updateCotizacion(
            @PathVariable Long id, @Valid @RequestBody CotizacionPasajesDTO cotizacionDTO) {
        CotizacionPasajes cotizacion = mapperUtil.map(cotizacionDTO, CotizacionPasajes.class);
        CotizacionPasajes updated = cotizacionPasajesService.updateCotizacion(id, cotizacion);
        if (updated == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(ApiResponse.error("Cotización no encontrada"));
        }
        CotizacionPasajesDTO dto = mapperUtil.map(updated, CotizacionPasajesDTO.class);
        return ResponseEntity.ok(ApiResponse.success(ApiConstants.UPDATE_SUCCESS, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteCotizacion(@PathVariable Long id) {
        cotizacionPasajesService.deleteCotizacion(id);
        return ResponseEntity.ok(ApiResponse.success(ApiConstants.DELETE_SUCCESS, null));
    }
}
