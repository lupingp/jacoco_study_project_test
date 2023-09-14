package com.example.study.project.studyproject.study;

public class StudyResult {

    private String result;

    public StudyResult(String result) {
        this.result = result;
    }

    public StudyResult(){};

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "StudyResult{" +
                "result='" + result + '\'' +
                '}';
    }

}
