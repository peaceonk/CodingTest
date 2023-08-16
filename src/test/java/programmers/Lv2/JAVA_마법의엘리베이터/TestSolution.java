package programmers.Lv2.JAVA_마법의엘리베이터;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.Assert.assertThat;
import static org.junit.Assume.assumeTrue;
import static org.hamcrest.CoreMatchers.is;

import java.util.*;
import java.util.stream.Stream;

import utils.JsonReader;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TestSolution {

    Solution solution = new Solution();
    final int test_time_limit = 1000;
    
    JsonReader json_reader = new JsonReader();

    String solutionPackagePath = solution.getClass().getPackage().getName();
    final String solutionFolderPath = solutionPackagePath.replaceAll("\\.","/");
    final String solutionFilePath = "/testcase.json";
    final String solutionEachPath = solutionFolderPath + solutionFilePath;
    Boolean testExecute = false;
    
    List<Arguments> arguList = new ArrayList<Arguments>();
    
    @BeforeAll
    void beforeAllTest() {
        System.out.println("========================================================Test initiate========================================================");

        Map testcase_map = new HashMap();

        testcase_map = json_reader.jsonReader(solutionEachPath);
        //System.out.println(testcase_map.toString());

        if(testcase_map == null && testcase_map.isEmpty()){
            testExecute = false;
            System.out.println("Warning : Test has been stopped. testcase_map is Empty.");
        }else {
            testExecute = true;
            
            List<String> testcase_keys_list = new ArrayList<>( testcase_map.keySet() );

            // 키 값으로 오름차순 정렬
            Collections.sort(testcase_keys_list);

            for(String testcase_key : testcase_keys_list){
                arguList.add( Arguments.of(testcase_key, testcase_map.get(testcase_key)));
            }
            //System.out.println(testcase_keys_list.toString());
        }

        assumeTrue(testExecute);
        //System.out.println("testExecute : " + testExecute);
    }

    @BeforeEach
    void beforeEachTest() {
        
    }

    @AfterAll
    void afterAllTest(){
        System.out.println("========================================================Test Terminate========================================================");
    }

    Stream<Arguments> arguListToStream() {
        return arguList.stream();
    }

    @Timeout(test_time_limit)
    @ParameterizedTest(name = "TESTCASE : {0}, PARAM : {1}")
    @MethodSource("arguListToStream")
    //@DisplayName(solutionPackagePath + "정답비교 테스트")
    void test(String tc_name, HashMap tc_params) {

        Object tc_result = tc_params.get("result");
        tc_params.remove("result");

        // System.out.println("tc_result : " + tc_params.get("result").getClass().getTypeName());

        List<String> tc_params_keys_list = new ArrayList<String>( tc_params.keySet() );
        Collections.sort(tc_params_keys_list);

        //System.out.println( tc_params_keys_list.toString() );

        List<Object> tc_params_list = new ArrayList<>();

        for(String tc_params_key : tc_params_keys_list){
            tc_params_list.add( tc_params.get(tc_params_key) );
        }

        Object[] tc_params_array = tc_params_list.toArray();

        //System.out.println( (String) Arrays.toString(tc_params_array));

        Object expected =null;
        Object actual = null;
        
        System.out.println("-----------------------------" + tc_name + " Solution Start-----------------------------");
        try{
            expected = tc_result;
            actual = solution.solution(tc_params_array);
        } catch(Exception e) {
            System.err.println("-------------------------" + tc_name + " Solution Source Error-------------------------");
        }
        System.out.println("-----------------------------" + tc_name + " Solution End-----------------------------");

        System.out.println("expected  : " + expected);
        System.out.println("actual  : "+ actual);

        assertThat(actual, is(expected));
    }

}