package programmers.Lv2.JAVA_마법의엘리베이터;

import org.assertj.core.internal.Arrays;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.Assert.assertThat;
import static org.junit.Assume.assumeTrue;

import static org.hamcrest.CoreMatchers.is;

import util.JsonReader;

import java.util.Map;
import java.util.stream.Stream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

record TestCase(Object param_1, Object param_2, Object result) {}

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TestSolution {

    final String solutionLevelPath = "Lv2\\";
    final String solutionFolderPath = "JAVA_마법의엘리베이터";
    final int testTimeLimit = 1000;

    final String solutionFilePath = "\\testcase.json";
    final String solutionEachPath = solutionLevelPath + solutionFolderPath + solutionFilePath;

    JsonReader jsonReader = new JsonReader();
    Solution solution = new Solution();
    Map testCaseMap = new HashMap();
    Boolean testExecute = false;

    List<Arguments> arguList = new ArrayList<Arguments>();
    
    @BeforeAll
    void beforeAllTest() {
        System.out.println("========================================================Test initiate========================================================");

        testCaseMap = jsonReader.jsonReader(solutionEachPath);
        //System.out.println(testCaseMap.toString());

        if(testCaseMap == null && testCaseMap.isEmpty()){
            System.out.println("Warning : Test has been stopped. testCaseMap is Empty.");
            testExecute = false;
        }else {
            testExecute = true;
            
            Iterator<String> keys = testCaseMap.keySet().iterator();

            while( keys.hasNext() ){
                String key = keys.next();

                List<String> keySet = new ArrayList<>(map.keySet());
                
                // 키 값으로 오름차순 정렬
                Collections.sort(keySet);

                for (String key : keySet) {
                    System.out.print("Key : " + key);
                    System.out.println(", Val : " + map.get(key));
                }

                arguList.add( Arguments.of(key, testCaseMap.get(key)));
            }
        }

        assumeTrue(testExecute);
        //System.out.println("testExecute : " + testExecute);
    }

    @BeforeEach
    void beforeEachTest() {
        
    }

    @AfterAll
    void afterAllTest(){
        System.out.println("========================================================Test End========================================================");
    }

    Stream<Arguments> arguListToStream() {
        return arguList.stream();
    }

    void solutionExecutor(Object ... params) throws Exception {

        Object param_1 = params[0];
        Object param_2 = params[1];
        Object param_3 = params[2];
        Object param_4 = params[3];
        Object param_5 = params[4];

        Object answer = solution.solution(16);
    }


    @Test
    @Timeout(testTimeLimit)
    @ParameterizedTest(name = "TESTCASE : {0}, PARAM : {1}")
    @MethodSource("arguListToStream")
    @DisplayName("코딩테스트 정답비교 테스트")
    void test(String testcase_name, HashMap testcase_param) {
        testcase_param.remove("result");
        //System.out.println("testcaseParam : " + testcase_param.toString());

        Object[] objectArray = testcase_param.entrySet().toArray();
        System.out.print("objectArray["+objectArray.length + "] : ");
        for(Object ob : objectArray ){

            System.out.print( (String)ob.toString() + ", ");
        }
        System.out.println("--");


        Object actual = new Object();
        Object expected = 7;
        
        System.out.println("-----------------------------Solution Start-----------------------------");
        try{
            //solutionExecutor();
            //actual = solution.solution(16);
        } catch(Exception e) {
            System.err.println("-------------------------Solution Source Error-------------------------");
        }
        System.out.println("-----------------------------Solution End-----------------------------");

        //assertThat(actual, is(expected));
        
    }

}