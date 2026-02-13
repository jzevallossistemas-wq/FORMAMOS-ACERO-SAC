package com.example.demo.controller;

import com.example.demo.dto.OrdenDTO;
import com.example.demo.entity.Orden;
import com.example.demo.service.OrdenService;
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
@RequestMapping(ApiConstants.API_BASE_PATH + "/ordenes")
public class OrdenController {

    @Autowired
    private OrdenService ordenService;

    @Autowired
    private MapperUtil mapperUtil;

    @PostMapping
    public ResponseEntity<ApiResponse<OrdenDTO>> createOrden(@Valid @RequestBody OrdenDTO ordenDTO) {
        Orden orden = mapperUtil.map(ordenDTO, Orden.class);
        Orden newOrden = ordenService.save(orden);
        OrdenDTO dto = mapperUtil.map(newOrden, OrdenDTO.class);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.success(ApiConstants.CREATE_SUCCESS, dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<OrdenDTO>> getOrdenById(@PathVariable Long id) {
        Orden orden = ordenService.findById(id);
        if (orden == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(ApiResponse.error("Orden no encontrada"));
        }
        OrdenDTO dto = mapperUtil.map(orden, OrdenDTO.class);
        return ResponseEntity.ok(ApiResponse.success("Orden encontrada", dto));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<OrdenDTO>>> getAllOrdenes() {
        List<Orden> ordenes = ordenService.findAll();
        List<OrdenDTO> dtos = mapperUtil.mapList(ordenes, OrdenDTO.class);
        return ResponseEntity.ok(ApiResponse.success("Órdenes obtenidas exitosamente", dtos));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<OrdenDTO>> updateOrden(
            @PathVariable Long id, @Valid @RequestBody OrdenDTO ordenDTO) {
        Orden orden = mapperUtil.map(ordenDTO, Orden.class);
        Orden updatedOrden = ordenService.update(id, orden);
        if (updatedOrden == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(ApiResponse.error("Orden no encontrada"));
        }
        OrdenDTO dto = mapperUtil.map(updatedOrden, OrdenDTO.class);
        return ResponseEntity.ok(ApiResponse.success(ApiConstants.UPDATE_SUCCESS, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteOrden(@PathVariable Long id) {
        ordenService.delete(id);
        return ResponseEntity.ok(ApiResponse.success(ApiConstants.DELETE_SUCCESS, null));
    }
}