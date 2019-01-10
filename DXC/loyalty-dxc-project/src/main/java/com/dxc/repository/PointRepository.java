package com.dxc.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.dxc.entity.Point;

public interface PointRepository extends CrudRepository<Point, Long> {
  List<Point> findAll();
}
