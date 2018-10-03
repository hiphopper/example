package com.hannt.example.sequence.dao;

import com.hannt.example.sequence.domain.Sequence;

public interface SequenceDao {
    Sequence getSequence(String sequenceId);
    int getNextValue(String sequenceId);
}
