package com.example.demo.controller;

import com.example.demo.dto.ComparativoPrecioCompraDTO;
import com.example.demo.entity.ComparativoPrecioCompra;
import com.example.demo.service.ComparativoPrecioCompraService;
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
@RequestMapping(ApiConstants.API_BASE_PATH + "/comparativo-precio-compra")
public class ComparativoPrecioCompraController {

    @Autowired
    private ComparativoPrecioCompraService service;

    @Autowired
    private MapperUtil mapperUtil;

    @PostMapping
    public ResponseEntity<ApiResponse<ComparativoPrecioCompraDTO>> create(
            @Valid @RequestBody ComparativoPrecioCompraDTO dto) {
        ComparativoPrecioCompra entity = mapperUtil.map(dto, ComparativoPrecioCompra.class);
        ComparativoPrecioCompra created = service.create(entity);
        ComparativoPrecioCompraDTO resultDTO = mapperUtil.map(created, ComparativoPrecioCompraDTO.class);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.success(ApiConstants.CREATE_SUCCESS, resultDTO));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<ComparativoPrecioCompraDTO>>> getAll() {
        List<ComparativoPrecioCompra> entities = service.getAll();
        List<ComparativoPrecioCompraDTO> dtos = mapperUtil.mapList(entities, ComparativoPrecioCompraDTO.class);
        return ResponseEntity.ok(ApiResponse.success("Comparativos obtenidos exitosamente", dtos));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<ComparativoPrecioCompraDTO>> getById(@PathVariable Long id) {
        ComparativoPrecioCompra entity = service.getById(id);
        if (entity == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(ApiResponse.error("Comparativo no encontrado"));
        }
        ComparativoPrecioCompraDTO dto = mapperUtil.map(entity, ComparativoPrecioCompraDTO.class);
        return ResponseEntity.ok(ApiResponse.success("Comparativo encontrado", dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<ComparativoPrecioCompraDTO>> update(
            @PathVariable Long id, @Valid @RequestBody ComparativoPrecioCompraDTO dto) {
        ComparativoPrecioCompra entity = mapperUtil.map(dto, ComparativoPrecioCompra.class);
        ComparativoPrecioCompra updated = service.update(id, entity);
        if (updated == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(ApiResponse.error("Comparativo no encontrado"));
        }
        ComparativoPrecioCompraDTO resultDTO = mapperUtil.map(updated, ComparativoPrecioCompraDTO.class);
        return ResponseEntity.ok(ApiResponse.success(ApiConstants.UPDATE_SUCCESS, resultDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok(ApiResponse.success(ApiConstants.DELETE_SUCCESS, null));
    }
}