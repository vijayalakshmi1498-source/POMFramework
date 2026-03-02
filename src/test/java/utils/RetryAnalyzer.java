package utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
	int count=0;//keeps track of how many times the test has been retried.
	int maxRetry=2;// sets the maximum number of retries allowed.
	
	public boolean retry(ITestResult result)
	{
		if(count>maxRetry)
		{
			count++;
			return true;
		}
		return false;
	}

	
}
