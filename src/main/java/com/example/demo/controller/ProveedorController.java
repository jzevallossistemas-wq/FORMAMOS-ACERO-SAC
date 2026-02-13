package com.example.demo.controller;

import com.example.demo.dto.ProveedorDTO;
import com.example.demo.entity.Proveedor;
import com.example.demo.service.ProveedorService;
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
@RequestMapping(ApiConstants.API_BASE_PATH + "/proveedores")
public class ProveedorController {

    @Autowired
    private ProveedorService proveedorService;

    @Autowired
    private MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<ApiResponse<List<ProveedorDTO>>> getAllProveedores() {
        List<Proveedor> proveedores = proveedorService.findAll();
        List<ProveedorDTO> dtos = mapperUtil.mapList(proveedores, ProveedorDTO.class);
        return ResponseEntity.ok(ApiResponse.success("Proveedores obtenidos exitosamente", dtos));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<ProveedorDTO>> getProveedorById(@PathVariable Long id) {
        Proveedor proveedor = proveedorService.findById(id);
        if (proveedor == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(ApiResponse.error("Proveedor no encontrado"));
        }
        ProveedorDTO dto = mapperUtil.map(proveedor, ProveedorDTO.class);
        return ResponseEntity.ok(ApiResponse.success("Proveedor encontrado", dto));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<ProveedorDTO>> createProveedor(@Valid @RequestBody ProveedorDTO proveedorDTO) {
        Proveedor proveedor = mapperUtil.map(proveedorDTO, Proveedor.class);
        Proveedor createdProveedor = proveedorService.save(proveedor);
        ProveedorDTO dto = mapperUtil.map(createdProveedor, ProveedorDTO.class);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.success(ApiConstants.CREATE_SUCCESS, dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<ProveedorDTO>> updateProveedor(
            @PathVariable Long id, @Valid @RequestBody ProveedorDTO proveedorDTO) {
        Proveedor proveedor = mapperUtil.map(proveedorDTO, Proveedor.class);
        Proveedor updatedProveedor = proveedorService.update(id, proveedor);
        if (updatedProveedor == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(ApiResponse.error("Proveedor no encontrado"));
        }
        ProveedorDTO dto = mapperUtil.map(updatedProveedor, ProveedorDTO.class);
        return ResponseEntity.ok(ApiResponse.success(ApiConstants.UPDATE_SUCCESS, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteProveedor(@PathVariable Long id) {
        proveedorService.delete(id);
        return ResponseEntity.ok(ApiResponse.success(ApiConstants.DELETE_SUCCESS, null));
    }
}