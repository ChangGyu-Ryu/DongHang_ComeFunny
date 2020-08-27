package common.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class LogAop {
	//Before pointcut ����
	@Before("execution(* com.DongHang_ComeFunny.www..*.*(..))")
	public void before(JoinPoint join) {
		System.out.println("getTarget ��� : " + join.getTarget()+"");
		Logger logger = LoggerFactory.getLogger(join.getTarget()+"");
		logger.info("----------log-----------");
		
		//�Ű��������� Object[] �� �޾Ƽ�
		Object[] args = join.getArgs();
		if(args != null) {
			logger.info("method : " + join.getSignature().getName());
			logger.info("----------------�Ű�����-------------");
			for(Object arg : args) {
				logger.info(arg+"");
			}
			
		}
		
	}
}