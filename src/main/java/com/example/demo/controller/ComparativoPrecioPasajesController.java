package com.example.demo.controller;

import com.example.demo.dto.ComparativoPrecioPasajesDTO;
import com.example.demo.entity.ComparativoPrecioPasajes;
import com.example.demo.service.ComparativoPrecioPasajesService;
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
@RequestMapping(ApiConstants.API_BASE_PATH + "/comparativo-precio-pasajes")
public class ComparativoPrecioPasajesController {

    @Autowired
    private ComparativoPrecioPasajesService service;

    @Autowired
    private MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<ApiResponse<List<ComparativoPrecioPasajesDTO>>> getAll() {
        List<ComparativoPrecioPasajes> entities = service.getAll();
        List<ComparativoPrecioPasajesDTO> dtos = mapperUtil.mapList(entities, ComparativoPrecioPasajesDTO.class);
        return ResponseEntity.ok(ApiResponse.success("Comparativos obtenidos exitosamente", dtos));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<ComparativoPrecioPasajesDTO>> getById(@PathVariable Long id) {
        ComparativoPrecioPasajes entity = service.getById(id);
        if (entity == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(ApiResponse.error("Comparativo no encontrado"));
        }
        ComparativoPrecioPasajesDTO dto = mapperUtil.map(entity, ComparativoPrecioPasajesDTO.class);
        return ResponseEntity.ok(ApiResponse.success("Comparativo encontrado", dto));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<ComparativoPrecioPasajesDTO>> create(
            @Valid @RequestBody ComparativoPrecioPasajesDTO dto) {
        ComparativoPrecioPasajes entity = mapperUtil.map(dto, ComparativoPrecioPasajes.class);
        ComparativoPrecioPasajes created = service.create(entity);
        ComparativoPrecioPasajesDTO resultDTO = mapperUtil.map(created, ComparativoPrecioPasajesDTO.class);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.success(ApiConstants.CREATE_SUCCESS, resultDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<ComparativoPrecioPasajesDTO>> update(
            @PathVariable Long id, @Valid @RequestBody ComparativoPrecioPasajesDTO dto) {
        ComparativoPrecioPasajes entity = mapperUtil.map(dto, ComparativoPrecioPasajes.class);
        ComparativoPrecioPasajes updated = service.update(id, entity);
        if (updated == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(ApiResponse.error("Comparativo no encontrado"));
        }
        ComparativoPrecioPasajesDTO resultDTO = mapperUtil.map(updated, ComparativoPrecioPasajesDTO.class);
        return ResponseEntity.ok(ApiResponse.success(ApiConstants.UPDATE_SUCCESS, resultDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok(ApiResponse.success(ApiConstants.DELETE_SUCCESS, null));
    }
}