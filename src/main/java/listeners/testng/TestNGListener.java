package listeners.testng;

import org.testng.IExecutionListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import static utilities.PropertiesManager.initializeProperties;

public class TestNGListener implements IExecutionListener, ITestListener {

    @Override
    public void onExecutionStart() {

        System.out.println("**************** Welcome to Selenium Framework ****************");
        initializeProperties();
    }

    @Override
    public void onExecutionFinish() {
        System.out.println("**************** End of Execution ****************");
    }

    @Override
    public void onTestStart(ITestResult testResult) {
        System.out.println("**************** Start of Test Start ****************");
    }

    @Override
    public void onTestSuccess(ITestResult testResult) {
        System.out.println("**************** Test Success ****************");

    }

    @Override
    public void onTestFailure(ITestResult testResult) {
        System.out.println("**************** Test Failure ****************");
        System.out.println("Taking a screenshot ");
    }
}
