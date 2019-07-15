import com.fasterxml.jackson.databind.ObjectMapper;
import io.qameta.allure.model.TestResult;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        File[] allureResults = new File("/home/dfrolov/IdeaProjects/jsonparser/src/main/resources/allure-results").listFiles();
        List<TestResult> testResultsList = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();
        for (File result : allureResults) {
            if(result.getName().contains("-result.json")) {
                TestResult testResult = null;
                try {
                    testResult = mapper.readValue(result, TestResult.class);
                    testResultsList.add(testResult);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
        System.out.println(testResultsList.get(0).getUuid());
    }
}

