package com.ajex.couriertracking.service;

import com.ajex.couriertracking.dao.CallHistory;
import com.ajex.couriertracking.dto.CallHistoryDto;
import com.ajex.couriertracking.mapper.CallHistoryMapper;
import com.ajex.couriertracking.repository.CallHistoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@Service
@Transactional
public class CallHistoryService {
    private final CallHistoryRepository repository;
    private final CallHistoryMapper callHistoryMapper;

    public CallHistoryService(CallHistoryRepository repository, CallHistoryMapper callHistoryMapper) {
        this.repository = repository;
        this.callHistoryMapper = callHistoryMapper;
    }

    public List<CallHistoryDto> save(List<CallHistoryDto> callHistoryDto) {
        log.info("Caller info received {}",callHistoryDto);
        List<CallHistory> callHistoryList = callHistoryMapper.toEntity(callHistoryDto);

        return callHistoryMapper.toDto( repository.saveAll(callHistoryList));
    }

    public void deleteById(long id) {
        repository.deleteById(id);
    }

    public CallHistoryDto findById(long id) {
//        return callHistoryMapper.toDto(repository.findById(id).orElseThrow(ResourceNotFoundException::new));
        return null;
    }

    public Page<CallHistoryDto> findByCondition(CallHistoryDto callHistoryDto, Pageable pageable) {
        Page<CallHistory> entityPage = repository.findAll(pageable);
        List<CallHistory> entities = entityPage.getContent();
        return new PageImpl<>(callHistoryMapper.toDto(entities), pageable, entityPage.getTotalElements());
    }

    public CallHistoryDto update(CallHistoryDto callHistoryDto, long id) {
        CallHistoryDto data = findById(id);
        CallHistory entity = callHistoryMapper.toEntity(callHistoryDto);
      //  BeanUtil.copyProperties(data, entity);
      //  return save(callHistoryMapper.toDto(entity));
        return null;
    }
}