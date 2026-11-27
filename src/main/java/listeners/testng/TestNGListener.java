package listeners.testng;

import org.testng.IExecutionListener;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utilities.AllureReportHelper;

import static utilities.PropertiesManager.frameworkConfig;
import static utilities.PropertiesManager.initializeProperties;

public class TestNGListener implements IExecutionListener, ITestListener {

    @Override
    public void onExecutionStart() {

        System.out.println("**************** Welcome to Selenium Framework ****************");
        initializeProperties();
        if (frameworkConfig.getProperty("cleanAllureReportBeforeExecution").equals("true")) {
            AllureReportHelper.cleanAllureReport();

        }
    }

    @Override
    public void onExecutionFinish() {
        System.out.println("**************** End of Execution ****************");
        if (frameworkConfig.getProperty("openReportAfterExecution").equals("true")) {
            AllureReportHelper.openAllureReport();

        }
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
