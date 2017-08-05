package com.example.testframework.service;

import java.util.*;

import org.json.JSONException;

import com.example.testframework.domain.FieldComparisonFailure;

public class TestProjectServiceImpl implements TestProjectService {

	@Override
	public List<FieldComparisonFailure> compare(String expect, String actual) {
		List<FieldComparisonFailure> list = new ArrayList<FieldComparisonFailure>();
        Comparator comparator = new Comparator() {
            public int compare(Object o1, Object o2) {
                return 0;
            }

            public boolean equals(Object obj) {
                return false;
            }
        };
        Collections.sort(list,comparator);
        return list;
	}

}
