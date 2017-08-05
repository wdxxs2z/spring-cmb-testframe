package com.example.testframework.service;

import java.util.List;

import com.example.testframework.domain.FieldComparisonFailure;

public interface TestProjectService {
	public List<FieldComparisonFailure> compare(String expect, String actual);
}
