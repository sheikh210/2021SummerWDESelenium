package learnSelenium;

import org.junit.*;

public class LearnAnnotations {

    @BeforeClass
    public static void sharedStepsBeforeTestSuite() {
        System.out.println("Setting up reporting & logs");
    }

//    @Before
//    public void sharedStepsBeforeTestCases() {
//        System.out.println("Open browser");
//        System.out.println("Navigating to https://www.Sephora.com/");
//        System.out.println("Clearing the cookies");
//        System.out.println("Maximizing window");
//    }

    @Test
    public void testCase() {
        System.out.println("***This is our 1st test case***");
    }

    @Test
    public void testCase2() {
        System.out.println("***This is our 2nd test case***");
    }

    @Test
    public void testCase3() {
        System.out.println("***This is our 3rd test case***");
    }

//    @After
//    public void sharedStepsAfterTestCases() {
//        System.out.println("Closing browser\n");
//    }

    @AfterClass
    public static void sharedStepsAfterTestSuite() {
        System.out.println("Generating report...\n\n\n GENERATED!");
    }

}
