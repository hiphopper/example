package com.hannt.example.sequence.dao.impl;

import com.hannt.example.sequence.dao.SequenceDao;
import com.hannt.example.sequence.domain.Sequence;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Repository("sequenceDao")
public class SequenceDaoImpl implements SequenceDao {
    private final Map<String, Sequence> sequences = new HashMap<>();
    private final Map<String, AtomicInteger> values = new HashMap<>();

    public SequenceDaoImpl() {
        sequences.put("IT", new Sequence("IT", "30", "A"));
        values.put("IT", new AtomicInteger(10000));
    }

    @Override
    public Sequence getSequence(String sequenceId) {
        return sequences.get(sequenceId);
    }

    @Override
    public int getNextValue(String sequenceId) {
        AtomicInteger atomicInteger = values.get(sequenceId);
        return atomicInteger.getAndIncrement();
    }
}
