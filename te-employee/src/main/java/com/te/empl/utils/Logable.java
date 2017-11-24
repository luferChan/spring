package com.te.empl.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Logable {
	
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	public void info(String str)
	{
		logger.info(str);
	}
	
	public void info(String str,Object...params)
	{
		logger.info(str, params);
	}

	public void error(String str)
	{
		logger.error(str);
	}
	
	public void error(String str,Object...params)
	{
		logger.error(str, params);
	}
	
	public void warning(String str)
	{
		logger.warn(str);
	}
	
	public void warning(String str,Object...params)
	{
		logger.warn(str, params);
	}
}
