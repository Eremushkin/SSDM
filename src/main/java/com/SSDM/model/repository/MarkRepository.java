package com.SSDM.model.repository;

import com.SSDM.model.entity.Mark;
import com.google.gwt.user.client.rpc.IsSerializable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MarkRepository extends JpaRepository<Mark, Long>, IsSerializable {}
