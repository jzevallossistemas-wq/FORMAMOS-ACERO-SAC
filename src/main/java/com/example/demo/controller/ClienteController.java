package com.example.demo.controller;

import com.example.demo.dto.ClienteDTO;
import com.example.demo.entity.Cliente;
import com.example.demo.service.ClienteService;
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
@RequestMapping(ApiConstants.API_BASE_PATH + "/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<ApiResponse<List<ClienteDTO>>> getAllClientes() {
        List<Cliente> clientes = clienteService.getAllClientes();
        List<ClienteDTO> dtos = mapperUtil.mapList(clientes, ClienteDTO.class);
        return ResponseEntity.ok(ApiResponse.success("Clientes obtenidos exitosamente", dtos));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<ClienteDTO>> getClienteById(@PathVariable Long id) {
        Cliente cliente = clienteService.getClienteById(id);
        if (cliente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(ApiResponse.error("Cliente no encontrado"));
        }
        ClienteDTO dto = mapperUtil.map(cliente, ClienteDTO.class);
        return ResponseEntity.ok(ApiResponse.success("Cliente encontrado", dto));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<ClienteDTO>> createCliente(@Valid @RequestBody ClienteDTO clienteDTO) {
        Cliente cliente = mapperUtil.map(clienteDTO, Cliente.class);
        Cliente createdCliente = clienteService.createCliente(cliente);
        ClienteDTO dto = mapperUtil.map(createdCliente, ClienteDTO.class);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.success(ApiConstants.CREATE_SUCCESS, dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<ClienteDTO>> updateCliente(
            @PathVariable Long id, @Valid @RequestBody ClienteDTO clienteDTO) {
        Cliente cliente = mapperUtil.map(clienteDTO, Cliente.class);
        Cliente updatedCliente = clienteService.updateCliente(id, cliente);
        if (updatedCliente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(ApiResponse.error("Cliente no encontrado"));
        }
        ClienteDTO dto = mapperUtil.map(updatedCliente, ClienteDTO.class);
        return ResponseEntity.ok(ApiResponse.success(ApiConstants.UPDATE_SUCCESS, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteCliente(@PathVariable Long id) {
        boolean deleted = clienteService.deleteCliente(id);
        if (!deleted) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(ApiResponse.error("Cliente no encontrado"));
        }
        return ResponseEntity.ok(ApiResponse.success(ApiConstants.DELETE_SUCCESS, null));
    }
}