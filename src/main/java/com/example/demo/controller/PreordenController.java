package com.example.demo.controller;

import com.example.demo.dto.PreordenDTO;
import com.example.demo.entity.Preorden;
import com.example.demo.service.PreordenService;
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
@RequestMapping(ApiConstants.API_BASE_PATH + "/preordenes")
public class PreordenController {

    @Autowired
    private PreordenService preordenService;

    @Autowired
    private MapperUtil mapperUtil;

    @PostMapping
    public ResponseEntity<ApiResponse<PreordenDTO>> createPreorden(@Valid @RequestBody PreordenDTO preordenDTO) {
        Preorden preorden = mapperUtil.map(preordenDTO, Preorden.class);
        Preorden createdPreorden = preordenService.createPreorden(preorden);
        PreordenDTO dto = mapperUtil.map(createdPreorden, PreordenDTO.class);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.success(ApiConstants.CREATE_SUCCESS, dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<PreordenDTO>> getPreordenById(@PathVariable Long id) {
        Preorden preorden = preordenService.getPreordenById(id);
        if (preorden == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(ApiResponse.error("Preorden no encontrada"));
        }
        PreordenDTO dto = mapperUtil.map(preorden, PreordenDTO.class);
        return ResponseEntity.ok(ApiResponse.success("Preorden encontrada", dto));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<PreordenDTO>>> getAllPreordenes() {
        List<Preorden> preordenes = preordenService.getAllPreordenes();
        List<PreordenDTO> dtos = mapperUtil.mapList(preordenes, PreordenDTO.class);
        return ResponseEntity.ok(ApiResponse.success("Preórdenes obtenidas exitosamente", dtos));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<PreordenDTO>> updatePreorden(
            @PathVariable Long id, @Valid @RequestBody PreordenDTO preordenDTO) {
        Preorden preorden = mapperUtil.map(preordenDTO, Preorden.class);
        Preorden updatedPreorden = preordenService.updatePreorden(id, preorden);
        if (updatedPreorden == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(ApiResponse.error("Preorden no encontrada"));
        }
        PreordenDTO dto = mapperUtil.map(updatedPreorden, PreordenDTO.class);
        return ResponseEntity.ok(ApiResponse.success(ApiConstants.UPDATE_SUCCESS, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deletePreorden(@PathVariable Long id) {
        preordenService.deletePreorden(id);
        return ResponseEntity.ok(ApiResponse.success(ApiConstants.DELETE_SUCCESS, null));
    }
}