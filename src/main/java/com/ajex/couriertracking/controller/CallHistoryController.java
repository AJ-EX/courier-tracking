package com.ajex.couriertracking.controller;

import com.ajex.couriertracking.dto.CallHistoryDto;
import com.ajex.couriertracking.service.CallHistoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/call-history")
@RestController
@Slf4j
//@Api("call-history")
public class CallHistoryController {
    private final CallHistoryService callHistoryService;

    public CallHistoryController(CallHistoryService callHistoryService) {
        this.callHistoryService = callHistoryService;
    }

    @PostMapping
    public ResponseEntity<CallHistoryDto> save(@RequestBody @Validated CallHistoryDto callHistoryDto) {
        CallHistoryDto dto = callHistoryService.save(callHistoryDto);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CallHistoryDto> findById(@PathVariable("id") long id) {
        CallHistoryDto callHistory = callHistoryService.findById(id);
        return ResponseEntity.ok(callHistory);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") long id) {
//        Optional.ofNullable(callHistoryService.findById(id)).orElseThrow(() -> {
//            log.error("Unable to delete non-existent data！");
//            return new ResourceNotFoundException();
//        });
        callHistoryService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/page-query")
    public ResponseEntity<Page<CallHistoryDto>> pageQuery(CallHistoryDto callHistoryDto, @PageableDefault(sort = "createAt", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<CallHistoryDto> callHistoryPage = callHistoryService.findByCondition(callHistoryDto, pageable);
        return ResponseEntity.ok(callHistoryPage);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody @Validated CallHistoryDto callHistoryDto, @PathVariable("id") long id) {
        callHistoryService.update(callHistoryDto, id);
        return ResponseEntity.ok().build();
    }
}