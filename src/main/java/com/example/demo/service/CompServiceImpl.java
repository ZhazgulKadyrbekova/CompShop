package com.example.demo.service;

import com.example.demo.dto.CompDTO;
import com.example.demo.entity.CompEntity;
import com.example.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompServiceImpl implements CompService{

    @Autowired
    private CompRepository compRepository;

    @Autowired
    private CpuRepository cpuRepository;

    @Autowired
    private RamRepository ramRepository;

    @Autowired
    private HddRepository hddRepository;

    @Override
    public CompEntity create(CompDTO comp) {
        CompEntity compEntity = new CompEntity();
        compEntity.setName(comp.getName());
        compEntity.setCpu(cpuRepository.findById(comp.getCpu()).orElse(null));
        compEntity.setHdd(hddRepository.findById(comp.getHdd()).orElse(null));
        compEntity.setRam(ramRepository.findById(comp.getRam()).orElse(null));
        return compRepository.save(compEntity);
    }

    @Override
    public String delete(Long id) {
        compRepository.deleteById(id);
        return "Comp id " + id + " has been deleted";
    }

    @Override
    public List<CompEntity> getAll() {
        return (List<CompEntity>) compRepository.findAll();
    }

    @Override
    public CompEntity getComp(Long id) {
        return compRepository.findById(id).orElse(null);
    }
}
