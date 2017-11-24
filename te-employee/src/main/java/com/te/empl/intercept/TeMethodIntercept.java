package com.te.empl.intercept;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.stereotype.Component;

import com.te.empl.utils.Logable;


@Component(value="teMethodIntercept")
public class TeMethodIntercept extends Logable implements MethodInterceptor {

	public Object invoke(MethodInvocation methodInvocation) throws Throwable {
	
		//Object result = methodInvocation.proceed();
		
		try {
			//1.记录类和方法名
			String methodName = new StringBuffer().append(methodInvocation.getThis().toString()).append("|").append(methodInvocation.getMethod().getName()).toString();		
			info("methodName = {}",methodName);
			
			//2.记录参数列表
			Object[] paramsArray  = methodInvocation.getArguments();
			for(int i=0; i<paramsArray.length; i++)
			{	
				if(paramsArray[i] == null)
				{
					continue;
				}
				info("\targ[{}] → {}", i, paramsArray[i].toString());
			}
			
			//3.记录当前函数的返回值
			//info("\treturn: {} - {}", methodName ,result);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return methodInvocation.proceed();
	}

}
