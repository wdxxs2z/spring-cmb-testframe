package com.example.testframework.domain;

public class FieldComparisonFailure {
	private final String field;
    private final Object expected;
    private final Object actual;

    public FieldComparisonFailure(String field, Object expected, Object actual) {
        this.field = field;
        this.expected = expected;
        this.actual = actual;
    }

    public String getField() {
        return field;
    }

    public Object getExpected() {
        return expected;
    }

    public Object getActual() {
        return actual;
    }
}
